package com.example.studysesh.data.settings

import kotlinx.coroutines.flow.Flow

/**
 * Abstraction over user preferences.
 * Keep only what the UI needs as reactive Flows and simple setters.
 */
interface AppSettings {
    /** Emits current dark-mode value and updates when it changes. */
    val darkMode: Flow<Boolean>

    /** Persist a new dark-mode value. */
    suspend fun setDarkMode(enabled: Boolean)
}
