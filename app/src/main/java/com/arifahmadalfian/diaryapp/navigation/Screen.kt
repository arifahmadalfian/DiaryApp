package com.arifahmadalfian.diaryapp.navigation

import com.arifahmadalfian.diaryapp.util.Constants.AUTHENTICATION_SCREEN
import com.arifahmadalfian.diaryapp.util.Constants.HOME_SCREEN
import com.arifahmadalfian.diaryapp.util.Constants.WRITE_SCREEN
import com.arifahmadalfian.diaryapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY

sealed class Screen(val route: String) {
    object Authentication : Screen(route = AUTHENTICATION_SCREEN)
    object Home : Screen(route = HOME_SCREEN)
    object Write :
        Screen(route = "$WRITE_SCREEN?$WRITE_SCREEN_ARGUMENT_KEY={$WRITE_SCREEN_ARGUMENT_KEY}") {
        fun passDiaryId(diaryId: String): String {
            return "$WRITE_SCREEN?$WRITE_SCREEN_ARGUMENT_KEY=$diaryId"
        }
    }
}