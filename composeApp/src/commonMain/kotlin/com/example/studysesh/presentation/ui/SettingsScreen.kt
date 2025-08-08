import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studysesh.presentation.navigation.LocalNavigator
import Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var darkMode by remember { mutableStateOf(false) }
    val navigator = LocalNavigator.current

    Column {
        CenterAlignedTopAppBar(
            title = { Text("Settings") },
            navigationIcon = {
                IconButton(onClick = { navigator.goTo(Route.Page(1)) }) {
                    Text("← Back")
                }
            }
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Dark mode")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = darkMode,
                    onCheckedChange = { darkMode = it }
                )
            }
        }
    }
}