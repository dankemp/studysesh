import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studysesh.presentation.navigation.LocalNavigator


@Composable
fun PageScreen(index: Int, content: @Composable () -> Unit) {
    val navigator = LocalNavigator.current
    Box(Modifier.fillMaxSize()) {
        content()

        IconButton(
            onClick = navigator::prevPage,
            modifier = Modifier.align(Alignment.TopStart).padding(8.dp),
            enabled = index > 1
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Previous")
        }

        IconButton(
            onClick = navigator::nextPage,
            modifier = Modifier.align(Alignment.TopEnd).padding(8.dp),
            enabled = index < 4
        ) {
            Icon(Icons.Default.ArrowForward, contentDescription = "Next")
        }

        IconButton(
            onClick = navigator::openSettings,
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 8.dp)
        ) {
            Icon(Icons.Default.Settings, contentDescription = "Settings")
        }
    }
}
