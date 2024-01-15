package com.pacheco.purrfectbreeds.router

sealed class Destination(open val route: String) {
    data class Breeds(override val route: String = "breeds"): Destination(route = route)
    data class Favorites(override val route: String = "favorites"): Destination(route = route)
    data class Details(override val route: String = "details/", val id: String = "{id}"): Destination(route = route) {
        fun getRouteWithId() = route + id
    }
}