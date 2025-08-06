class AppSettingsImpl(private val settings: Settings) : AppSettings {
    private val key = "dark_mode"
    private val state = MutableStateFlow(settings.getBoolean(key, false))

    override val darkMode: Flow<Boolean> get() = state

    override suspend fun setDarkMode(enabled: Boolean) {
        settings.putBoolean(key, enabled)
        state.value = enabled
    }
}
