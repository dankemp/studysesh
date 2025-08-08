package com.example.studysesh.presentation.navigation

import Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class Navigator(start: Route = Route.Page(1)) {
    private val _route = MutableStateFlow(start)
    val route: StateFlow<Route> = _route.asStateFlow()

    fun goTo(route: Route) { _route.value = route }
    fun nextPage() {
        val current = _route.value
        if (current is Route.Page && current.index < 4) {
            _route.value = Route.Page(current.index + 1)
        }
    }
    fun prevPage() {
        val current = _route.value
        if (current is Route.Page && current.index > 1) {
            _route.value = Route.Page(current.index - 1)
        }
    }
    fun openSettings() { _route.value = Route.Settings }
}
