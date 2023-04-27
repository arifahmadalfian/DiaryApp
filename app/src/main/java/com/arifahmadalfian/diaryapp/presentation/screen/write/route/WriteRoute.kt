package com.arifahmadalfian.diaryapp.presentation.screen.write.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arifahmadalfian.diaryapp.navigation.Screen
import com.arifahmadalfian.diaryapp.util.Constants

fun NavGraphBuilder.writeRoute() {
    composable(
        route = Screen.Write.route,
        arguments = listOf(
            navArgument(name = Constants.WRITE_SCREEN_ARGUMENT_KEY) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) {

    }
}