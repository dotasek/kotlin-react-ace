@file:JsModule("react-ace")
@file:JsNonModule

package ace

import react.*

@JsName("default")
external val aceEditor: ComponentClass<AceEditorProps>

external interface AceEditorProps : Props {
    var ref : MutableRefObject<Nothing>
    var mode: String
    var theme : String
    var annotations : Array<AceAnnotation>
    var markers : Array<AceMarker>
    var defaultValue : String?
    var value : String?
    var setOptions : AceOptions
}

