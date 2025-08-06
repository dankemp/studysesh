@Composable
fun SettingsScreen(viewModel: SettingsViewModel = rememberSettingsViewModel()) {
    val state by viewModel.state.collectAsState()
    val navigator = LocalNavigator.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = navigator::backFromSettings) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) {
        Column(Modifier.padding(it).padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Dark mode")
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = state.darkMode,
                    onCheckedChange = viewModel::setDarkMode
                )
            }
        }
    }
}
