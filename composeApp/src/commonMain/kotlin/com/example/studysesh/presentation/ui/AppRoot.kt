package com.example.studysesh.presentation.ui

import PageHost
import SettingsScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.studysesh.presentation.navigation.Navigator
//import com.example.studysesh.presentation.navigation.Routes
//import com.example.studysesh.presentation.ui.PageHost
//import com.example.studysesh.presentation.ui.SettingsScreen


@Composable
fun AppRoot(navigator: Navigator) {
    val localNavigator = staticCompositionLocalOf<Navigator> {
        error("Navigator not provided")
    }

    CompositionLocalProvider(localNavigator provides navigator) {
        val route by navigator.route.collectAsState()

        when (route) {
            is Route.Page -> PageHost((route as Route.Page).index)
            Route.Settings -> SettingsScreen()
        }
    }
}


