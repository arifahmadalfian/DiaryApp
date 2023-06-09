package com.arifahmadalfian.diaryapp.presentation.screen.auth.route

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arifahmadalfian.diaryapp.navigation.Screen
import com.arifahmadalfian.diaryapp.presentation.screen.auth.AuthenticationScreen
import com.arifahmadalfian.diaryapp.presentation.screen.auth.AuthenticationViewModel
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authenticationRoute(
    navigateToHome: () -> Unit
) {
    composable(route = Screen.Authentication.route) {
        val viewModel: AuthenticationViewModel = viewModel()
        val authenticated by viewModel.authenticated
        val loadingState by viewModel.loadingState
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(
            authenticated = authenticated,
            loadingState = loadingState,
            oneTapState = oneTapState,
            messageBarState = messageBarState,
            onButtonClicked = {
                oneTapState.open()
                viewModel.setLoading(true)
            },
            onTokenIdReceived = { tokenId ->
                viewModel.signInWithMongoAtlas(
                    tokenId = tokenId,
                    onSuccess = {
                        viewModel.setLoading(false)
                        messageBarState.addSuccess("Success")
                    },
                    onError = { e ->
                        viewModel.setLoading(false)
                        messageBarState.addError(e)
                    }
                )
            },
            onDialogDismissed = { message ->
                viewModel.setLoading(false)
                messageBarState.addError(Exception(message))
            },
            navigateToHome = navigateToHome
        )
    }
}