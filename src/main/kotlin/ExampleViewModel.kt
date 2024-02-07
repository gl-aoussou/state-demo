import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExampleViewModel {

    private val _state = MutableStateFlow(ExampleState())
    val state = _state.asStateFlow()

    fun onAction(action: ExampleAction) {

        when (action) {
            ExampleAction.MakeAvailable -> makeAvailable()
            ExampleAction.MakeUnavailable -> makeUnavailable()
            is ExampleAction.UpdateAge -> updateAge(action.newAge)
            is ExampleAction.UpdateName -> updateName(action.newName)
        }

    }

    private fun updateName(newName: String) {
        _state.update { it.copy(name = newName) }
    }

    private fun updateAge(newAge: Int) {
        _state.update { it.copy(age = newAge) }
    }


    private fun makeAvailable() {
        _state.update {
            it.copy(
                available = true,
                color = Color.Blue
            ) }
    }

    private fun makeUnavailable() {
        _state.update { it.copy(
            available = false,
            color = Color.Red
        ) }
    }

}