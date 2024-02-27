package com.hamon.kosmos_challenge.navigation

sealed class Routes(val route: String) {
    object ListMainScreen : Routes("list_main_screen")

    object DetailScreen : Routes("detail_screen")
}