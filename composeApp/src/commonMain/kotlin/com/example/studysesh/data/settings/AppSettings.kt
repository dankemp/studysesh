interface AppSettings {
    val darkMode: Flow<Boolean>
    suspend fun setDarkMode(enabled: Boolean)
}
