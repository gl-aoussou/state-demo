import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    val viewModel = ViewModel()
    val state by viewModel.state.collectAsState()

    MaterialTheme {

        Column(Modifier
            .fillMaxSize()
            .background(state.color)
        ) {

            Text(state.name ?: "not named")

            Text(if (state.age != null) viewModel.state.value.age.toString() else "age unknown")

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )

            Button(onClick = {
                viewModel.onAction(ExampleAction.UpdateName(name))
            }) {
                Text("change name")
            }

            TextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") }
            )

            Button(onClick = {
                viewModel.onAction(ExampleAction.UpdateAge(age.toInt()))
            }) {
                Text("change age")
            }

            Button(onClick = {

                if(viewModel.state.value.available)
                viewModel.onAction(ExampleAction.MakeUnavailable)
                else viewModel.onAction(ExampleAction.MakeAvailable)
            }) {
                Text("change availability")
            }

        }


    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
