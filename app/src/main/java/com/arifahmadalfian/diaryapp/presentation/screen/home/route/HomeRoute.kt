package com.arifahmadalfian.diaryapp.presentation.screen.home.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arifahmadalfian.diaryapp.navigation.Screen
import com.arifahmadalfian.diaryapp.util.Constants.APP_ID
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun NavGraphBuilder.homeRoute() {
    composable(route = Screen.Home.route) {
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    scope.launch(Dispatchers.IO) {
                        App.create(APP_ID).currentUser?.logOut()
                    }
                }
            ) {
                Text(text = "Logout")
            }
        }
    }
}