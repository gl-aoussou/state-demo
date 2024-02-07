import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun displayName() {

    val viewModel = Dependencies.viewModel
    val state by viewModel.state.collectAsState()

   Text(text =state.name )


}