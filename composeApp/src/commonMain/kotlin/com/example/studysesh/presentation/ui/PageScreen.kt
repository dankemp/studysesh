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
