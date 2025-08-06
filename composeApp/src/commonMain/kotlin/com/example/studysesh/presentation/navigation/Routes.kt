sealed interface Route {
    data class Page(val index: Int) : Route {
        init { require(index in 1..4) }
    }
    data object Settings : Route
}
