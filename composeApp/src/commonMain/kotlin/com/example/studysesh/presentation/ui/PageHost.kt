import androidx.compose.runtime.Composable

@Composable
fun PageHost(index: Int) {
    when (index) {
        1 -> PageScreen(index = 1) { Page1() }
        2 -> PageScreen(index = 2) { Page2() }
        3 -> PageScreen(index = 3) { Page3() }
        4 -> PageScreen(index = 4) { Page4() }
    }
}