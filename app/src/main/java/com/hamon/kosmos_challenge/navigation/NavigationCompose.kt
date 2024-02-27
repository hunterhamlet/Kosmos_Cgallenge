package com.hamon.kosmos_challenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hamon.kosmos_challenge.ui.screens.ListMainScreen

@Composable
fun NavigationComposable() {

    // Create nav controller
    val navController = rememberNavController()

    //Create NavHost
    NavHost(navController = navController, startDestination = Routes.ListMainScreen.route) {

        // Create list main
        composable(Routes.ListMainScreen.route) {
            ListMainScreen()
        }

    }

}