import css.GlobalStyles
import kotlinx.browser.document
import react.dom.render

fun main() {
  GlobalStyles.inject();

  render(document.getElementById("root")) {
    child(app)
  }
}
