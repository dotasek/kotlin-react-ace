import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

external interface LineButtonProps : Props {
    var buttonText : String
    var line : Int
    var onMouseOverLine : (Int) -> Unit
    var onMouseLeaveLine : (Int) -> Unit
    var onClickLine : (Int) -> Unit
}

val lineButton = fc<LineButtonProps> { props ->
    p {
        attrs {
            onClickFunction = {
                props.onClickLine(props.line)
            }
            onMouseOver = {
                props.onMouseOverLine(props.line)
            }
            onMouseLeave = {
                props.onMouseLeaveLine(0);
            }
        }
        +props.buttonText
    }
}
