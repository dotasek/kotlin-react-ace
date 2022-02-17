package css

import kotlinext.js.invoke
import kotlinx.css.*
import styled.createGlobalStyle

/**
 * By default, we want to set the global styles for the entire project to 0 px margin and padding.
 */
object GlobalStyles {
    fun inject() {
        val styles = CssBuilder(allowClasses = true).apply {

        }
        createGlobalStyle(styles.toString())
    }
}
/*
object ComponentStyles : StyleSheet("ComponentStyles", isStatic = true) {
    val wrapper by css {
        padding(vertical = 16.px)

        backgroundColor = Color.green
    }
}*/