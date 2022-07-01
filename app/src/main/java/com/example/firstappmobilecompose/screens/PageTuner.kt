package com.example.firstappmobilecompose.screens

import android.annotation.SuppressLint
import be.tarsos.dsp.pitch.PitchDetector
import be.tarsos.dsp.pitch.PitchDetectionHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstappmobilecompose.R
import com.example.firstappmobilecompose.core.TunerState
import com.example.firstappmobilecompose.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PageTuner(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar_PageTuner() },
        content = { PageTuner_BodyContent() },
        bottomBar = { BottomAppBar_PageTuner(navController) }
    )
}

@Composable
fun TopAppBar_PageTuner() {
    TopAppBar(
        title = { Text(text = "Smart Tuner", color = Color.Black) },
        backgroundColor = colorResource(id = R.color.Secondary_Color)
    )
}

@Composable
fun BottomAppBar_PageTuner(navController: NavController) {
    BottomAppBar(
        backgroundColor = colorResource(id = R.color.Secondary_Color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate(route = AppScreens.PagePrincipal.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Home", fontSize = 20.sp, color = Color.Black)
            }

            Button(
                onClick = { navController.navigate(route = AppScreens.PageTuner2.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Tuner", fontSize = 20.sp, color = Color.Black)
            }

            Button(
                onClick = { navController.navigate(route = AppScreens.PageEarTraining.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Training", fontSize = 20.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun PageTuner_BodyContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {
        item {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .height(400.dp),
                painter = painterResource(id = R.drawable.guitarra),
                contentDescription = "Smart Tuner"
            )
            Spacer(modifier = Modifier.height(80.dp))
            ButtonChangeTopGuitar()
            Spacer(modifier = Modifier.height(180.dp))
            CustomLinearProgressBar()
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}

@Composable
private fun CustomLinearProgressBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            backgroundColor = Color.LightGray,
            color = Color.Red //progress color
        )
    }
}

@Composable
fun ButtonChangeTopGuitar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Change Top Guitar")
        }
    }
}










