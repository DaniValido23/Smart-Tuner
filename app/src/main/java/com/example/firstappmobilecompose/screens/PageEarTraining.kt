package com.example.firstappmobilecompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstappmobilecompose.R
import com.example.firstappmobilecompose.navigation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PageEarTraining(navController:NavController) {
    Scaffold(
        topBar = { TopAppBar_PageEarTraining() },
        content = { PageEarTraining_BodyContent(navController) },
        bottomBar = { BottomAppBar_PageEarTRaining(navController) }
    )
}

@Composable
fun TopAppBar_PageEarTraining() {
    TopAppBar(
        title = { Text(text = "Smart Tuner", color = Color.Black) },
        backgroundColor = colorResource(id = R.color.Secondary_Color)
    )
}

@Composable
fun BottomAppBar_PageEarTRaining(navController: NavController) {
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
fun PageEarTraining_BodyContent(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainBlue))
    ) {
        item {
            RowButtonLevel(navController)
            RowButtonLevel(navController)
            RowButtonLevel(navController)
            RowButtonLevelLocked()
            Spacer(modifier = Modifier.height(70.dp))
            ButtonExit()
        }


    }
}


@Composable
fun RowButtonLevel(navController: NavController) {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonLevels(navController)
            ButtonLevels(navController)
        }
    }
}

@Composable
fun RowButtonLevelLocked() {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonLevelsLocked()
            ButtonLevelsLocked()
        }
    }
}


@Composable
fun ButtonLevels(navController: NavController) {
    Card(elevation = 0.dp, modifier = Modifier.size(150.dp)) {
        Column(
            modifier = Modifier.background(colorResource(id = R.color.MainBlue))
        ) {
            Text(
                text = "Level",
                color = Color.White,
                modifier = Modifier.absolutePadding(42.dp, 15.dp, 0.dp, 0.dp),
                fontSize = 25.sp

            )

            Spacer(modifier = Modifier.height(10.dp))

            ExtendedFloatingActionButton(
                text = { Text(text = "GO!", color = Color.White, fontSize = 15.sp) },
                modifier = Modifier.size(150.dp, 50.dp),
                onClick = { navController.navigate(route = AppScreens.Levels.route) },
                backgroundColor = colorResource(id = R.color.Blue_Buttom)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Composable
fun ButtonLevelsLocked() {
    Card(elevation = 0.dp, modifier = Modifier.size(150.dp)) {
        Column(
            modifier = Modifier.background(colorResource(id = R.color.MainBlue))
        ) {
            Text(
                text = "Level",
                color = Color.White,
                modifier = Modifier.absolutePadding(42.dp, 15.dp, 0.dp, 0.dp),
                fontSize = 25.sp

            )

            Spacer(modifier = Modifier.height(10.dp))

            ExtendedFloatingActionButton(
                text = { Text(text = "Locked!", color = Color.White, fontSize = 15.sp) },
                modifier = Modifier.size(150.dp, 50.dp),
                onClick = { /*TODO*/ },
                backgroundColor = colorResource(id = R.color.Red_Exit)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ButtonExit() {
    //val activity =(LocalContext.current as? Activity)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}