import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.studysesh.presentation.navigation.LocalNavigator
import com.example.studysesh.presentation.navigation.Navigator
import com.example.studysesh.presentation.navigation.Route
import com.example.studysesh.presentation.ui.PageScreen
import com.example.studysesh.presentation.ui.Page1Content
import com.example.studysesh.presentation.ui.Page2
import com.example.studysesh.presentation.ui.SettingsScreen
import androidx.compose.runtime.staticCompositionLocalOf




@Composable
fun AppRoot(navigator: Navigator) {
    val LocalNavigator = staticCompositionLocalOf<Navigator> {
        error("Navigator not provided")
    }

    CompositionLocalProvider(LocalNavigator provides navigator) {
        val route by navigator.route.collectAsState()

        when (route) {
            is Route.Page -> PageHost((route as Route.Page).index)
            Route.Settings -> SettingsScreen()
        }
    }
}

@Composable
fun PageHost(index: Int) {
    when (index) {
        1 -> PageScreen(index = 1) { Page1() }
        2 -> PageScreen(index = 2) { Page2() }
        3 -> PageScreen(index = 3) { Page3() }
        4 -> PageScreen(index = 4) { Page4() }
    }
}
