@file:JsModule("react-ace")
@file:JsNonModule

import kotlinext.js.Object
import org.w3c.dom.Element
import react.*

@JsName("default")
external val aceEditor: ComponentClass<AceEditorProps>

external interface AceEditorProps : Props {
    var ref : MutableRefObject<Nothing>
    var mode: String
    var theme : String
    var annotations : Array<Annotation>
    var markers : Array<Marker>
    var defaultValue : String?
    var value : String?
    var setOptions : AceOptions
}

