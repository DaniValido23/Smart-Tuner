package com.example.firstappmobilecompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.example.firstappmobilecompose.R
import com.example.firstappmobilecompose.ui.theme.TunedColor



@ExperimentalPermissionsApi
@Composable
fun WithoutPermissionScreen(launchPermissionRequest: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.request_permission_message),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(12.dp))
        
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = TunedColor),
            onClick = { launchPermissionRequest() }
        ) {
            Text(stringResource(R.string.grant_permission))
        }
    }
}



