package com.arifahmadalfian.diaryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.arifahmadalfian.diaryapp.presentation.screen.auth.route.authenticationRoute
import com.arifahmadalfian.diaryapp.presentation.screen.home.route.homeRoute
import com.arifahmadalfian.diaryapp.presentation.screen.write.route.writeRoute

@Composable
fun SetupNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        authenticationRoute(
            navigateToHome =  {
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }
        )
        homeRoute(
            navigateToWrite = {
                navController.navigate(Screen.Write.route)
            }
        )
        writeRoute()
    }
}