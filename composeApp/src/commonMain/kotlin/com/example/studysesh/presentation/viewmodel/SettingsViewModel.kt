/*

class SettingsViewModel(private val appSettings: AppSettings) : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    init {
        viewModelScope.launch {
            appSettings.darkMode.collect {
                _state.value = _state.value.copy(darkMode = it)
            }
        }
    }

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch { appSettings.setDarkMode(enabled) }
    }
}

data class SettingsState(val darkMode: Boolean = false)
*/