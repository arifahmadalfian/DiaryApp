package com.arifahmadalfian.diaryapp.presentation.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arifahmadalfian.diaryapp.R
import com.arifahmadalfian.diaryapp.presentation.components.GoogleButton

@Composable
fun AuthenticationContent(
    loadingState: Boolean,
    onButtonClicked: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth()
                .padding(all = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = stringResource(R.string.google_logo)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.welcome_to_diary_app),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
            )
            Text(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                text = stringResource(R.string.please_sign_in_to_continue),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            )
        }
        Column(
            modifier = Modifier
                .weight(2f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GoogleButton(
                loadingState = loadingState,
                onClick = onButtonClicked
            )
        }
    }
}