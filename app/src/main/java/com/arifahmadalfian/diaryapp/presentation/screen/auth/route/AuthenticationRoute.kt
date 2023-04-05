package com.arifahmadalfian.diaryapp.presentation.screen.auth.route

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arifahmadalfian.diaryapp.navigation.Screen
import com.arifahmadalfian.diaryapp.presentation.screen.auth.AuthenticationScreen
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authenticationRoute() {
    composable(route = Screen.Authentication.route) {
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(
            loadingState = oneTapState.opened,
            oneTapState = oneTapState,
            messageBarState = messageBarState,
            onButtonClicked = {
                oneTapState.open()
            }
        )
    }
}