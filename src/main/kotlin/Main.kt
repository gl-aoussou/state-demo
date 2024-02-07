import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    val exampleViewModel = Dependencies.viewModel
    val state by exampleViewModel.state.collectAsState()

    MaterialTheme {

        Column(Modifier
            .fillMaxSize()
            .background(state.color)
        ) {


            displayName()

            Text(if (state.age != null) exampleViewModel.state.value.age.toString() else "age unknown")

            TextField(
                value = state.name,
                onValueChange = {exampleViewModel.onAction(ExampleAction.UpdateName(it)) },
                label = { Text("Name") }
            )

            Button(onClick = {
                exampleViewModel.onAction(ExampleAction.UpdateName(name))
            }) {
                Text("change name")
            }

            TextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") }
            )

            Button(onClick = {
                exampleViewModel.onAction(ExampleAction.UpdateAge(age.toInt()))
            }) {
                Text("change age")
            }

            Button(onClick = {

                if(exampleViewModel.state.value.available)
                exampleViewModel.onAction(ExampleAction.MakeUnavailable)
                else exampleViewModel.onAction(ExampleAction.MakeAvailable)
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
