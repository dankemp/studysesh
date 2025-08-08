package com.example.studysesh.data.settings

//import com.russhwolf.settings.Settings
//import com.russhwolf.settings.getBoolean
//import com.russhwolf.settings.putBoolean

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/*
class AppSettingsImpl(private val settings: com.russhwolf.settings.Settings) : AppSettings {
    private val key = "dark_mode"
    private val state = MutableStateFlow(settings.getBoolean(key, false))

    override val darkMode: Flow<Boolean> get() = state

    override suspend fun setDarkMode(enabled: Boolean) {
        settings.putBoolean(key, enabled)
        state.value = enabled
    }
}
*/