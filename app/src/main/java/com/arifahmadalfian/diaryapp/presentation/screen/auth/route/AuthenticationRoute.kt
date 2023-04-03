package com.arifahmadalfian.diaryapp.presentation.screen.auth.route

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arifahmadalfian.diaryapp.navigation.Screen
import com.arifahmadalfian.diaryapp.presentation.screen.auth.AuthenticationScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authenticationRoute() {
    composable(route = Screen.Authentication.route) {
        AuthenticationScreen(
            loadingState = false,
            onButtonClicked = {

            }
        )
    }
}