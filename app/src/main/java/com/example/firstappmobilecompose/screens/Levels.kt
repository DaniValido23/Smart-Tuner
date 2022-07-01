package com.example.firstappmobilecompose.screens

import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstappmobilecompose.R

//Levels

@Composable
fun Levels(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {
        item {
            val uwu = LocalContext.current
            val mp: MediaPlayer = MediaPlayer.create(uwu, R.raw.audio)
            Text(

                text = "Level 1",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .absolutePadding(0.dp, 25.dp, 0.dp, 30.dp),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .height(400.dp),
                painter = painterResource(id = R.drawable.altavoz),
                contentDescription = "Smart Tuner"
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExtendedFloatingActionButton(
                    onClick = { mp.start() },
                    modifier = Modifier
                        .size(150.dp, 50.dp),
                    icon = { Icon(Icons.Filled.PlayArrow, contentDescription = null) },
                    text = {
                        Text(
                            text = "Play"
                        )
                    })
            }

            Text(
                text = "Can you guess the musical note ?",
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(0.dp, 80.dp, 0.dp, 20.dp),
                textAlign = TextAlign.Center,
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                PressIconButton(
                    onClick = {},
                    icon = { Icon(Icons.Filled.Close, contentDescription = null) },
                    text = { Text(text = "G minor") }
                )

                Spacer(modifier = Modifier.height(40.dp))

                PressIconButton(
                    onClick = {},
                    icon = { Icon(Icons.Filled.Close, contentDescription = null) },
                    text = { Text(text = "B major") }
                )

                Spacer(modifier = Modifier.height(40.dp))

                PressIconButton(
                    onClick = {},
                    icon = { Icon(Icons.Filled.Done, contentDescription = null) },
                    text = { Text(text = "LA minor") }
                )

                Spacer(modifier = Modifier.height(40.dp))


            }

        }
    }
}

@Composable
fun PressIconButton(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() },
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    Button(onClick = onClick, modifier = modifier, interactionSource = interactionSource) {
        AnimatedVisibility(visible = isPressed) {
            if (isPressed)
                Row {
                    icon()
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                }
        }
        text()
    }
}


