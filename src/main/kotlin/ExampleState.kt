import androidx.compose.ui.graphics.Color

data class ExampleState(
    val name: String = "",
    val age: Int? = null,
    val available: Boolean = false,
    val color: Color = Color.Red
)
