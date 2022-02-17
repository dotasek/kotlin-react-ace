import ace.AceOptions
import ace.AceAnnotation
import ace.AceMarker
import ace.aceEditor
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.*
import react.dom.h1
import styled.StyleSheet
import styled.css
import styled.styledDiv

val mainScope = MainScope()

val app = fc<Props> {

    var jsonExample: String? by useState("{ \"bunchOCrap\":\"\"\n\n\n}")

    var marker : Array<AceMarker> by useState(emptyArray())

    val editorRef = useRef(null)


    suspend fun fetchExample(): String {
        return window
            .fetch("http://localhost:8080/example.json")
            .await()
            .text()
            .await()
    }

    useEffectOnce {
        mainScope.launch {
            val exampleFetched = fetchExample()
            jsonExample = exampleFetched
        }
    }

    val gotoLine = { line : Int ->
        editorRef.asDynamic().current.editor.gotoLine(line)
        editorRef.asDynamic().current.editor.scrollToLine(line, true, true, null)

    }

    val addMarker = { line : Int ->
       marker = if (line == 0 ) emptyArray() else arrayOf(AceMarker(line - 1,0,line,0, "editor-focus-error", "line", true));
    }

    h1 {
        +"Ace Editor Demo"
    }

    for ( i  in arrayOf( 1, 30, 300)) {

            lineButton{
                attrs {
                    buttonText = "Highlight $i"
                    line = i
                    onClickLine = gotoLine
                    onMouseOverLine = addMarker
                    onMouseLeaveLine = addMarker
                }
            }
    }
    styledDiv {
        css {
            /*
            +CurrentMarkerStyle.error
            display = Display.flex
            flexDirection = FlexDirection.row
            alignItems = Align.center
            padding(vertical = 8.px, horizontal = 16.px)
       */
        }
        aceEditor{
            attrs {
                ref = editorRef
                mode = "json"
                theme = "github"
                annotations = arrayOf(AceAnnotation(0,0,"nyah", "error"))
                value = jsonExample
                setOptions = AceOptions(false)
                markers = marker
            }
        }
    }
}


/**
 * CSS
 */
object CurrentMarkerStyle : StyleSheet("CurrentMarkerStyle", isStatic = true) {
    val error by CurrentMarkerStyle.css {
        backgroundColor = Color.red
        cursor = Cursor.pointer
        position = Position.absolute
        //display = Display.inlineFlex
        //flexDirection = FlexDirection.row
        //minHeight = 32.px
        //alignSelf = Align.center
        //padding(horizontal = 16.px, vertical = 8.px)
    }
}