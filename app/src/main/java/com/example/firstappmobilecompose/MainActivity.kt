package com.example.firstappmobilecompose

import android.Manifest.permission.RECORD_AUDIO
import com.google.accompanist.permissions.rememberPermissionState
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstappmobilecompose.core.NotesEnum
import com.example.firstappmobilecompose.core.TunerState
import com.example.firstappmobilecompose.core.preventAutoLockScreen
import com.example.firstappmobilecompose.navigation.AppNavigation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus


@OptIn(ExperimentalPermissionsApi::class)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    public val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preventAutoLockScreen(window)
        setContent {
            val micPermissionState = rememberPermissionState(RECORD_AUDIO)

            MaterialTheme {
                when (micPermissionState.status) {
                    is PermissionStatus.Granted -> {
                        //TunerScreen(viewModel.tunerState.collectAsState().value)
                        AppNavigation(viewModel.tunerState.collectAsState().value)
                    }
                    is PermissionStatus.Denied -> {
                        WithoutPermissionScreen { micPermissionState.launchPermissionRequest() }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onResume() {
        super.onResume()
        viewModel.startAudioListener(this)
    }

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onPause() {
        super.onPause()
        viewModel.stopAudioListener()
    }
/*
    @Preview(widthDp = 200, heightDp = 200)
    @Composable
    fun TunedView() = TunerScreen(TunerState.Tuned(NotesEnum.A))

    @Preview(widthDp = 200, heightDp = 200)
    @Composable
    fun OutOfTuneViewDown() = TunerScreen(TunerState.Down(NotesEnum.A))

    @Preview(widthDp = 200, heightDp = 200)
    @Composable
    fun OutOfTuneViewUp() = TunerScreen(TunerState.Up(NotesEnum.A))

    @Preview(widthDp = 200, heightDp = 200)
    @Composable
    fun NoSound() = TunerScreen(TunerState.NoSound)*/

}











