package com.example.firstappmobilecompose.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.example.firstappmobilecompose.navigation.AppScreens



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PagePrincipal(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar() },
        content = { BodyContent(navController)},
        bottomBar = { BottomAppBar(navController) }
    )
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "Smart Tuner", color = Color.Black) },
        backgroundColor = colorResource(id = com.example.firstappmobilecompose.R.color.Secondary_Color)
    )
}

@Composable
fun BottomAppBar(navController: NavController) {
    BottomAppBar(
        backgroundColor = colorResource(id = com.example.firstappmobilecompose.R.color.Secondary_Color)
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
                        id = com.example.firstappmobilecompose.R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Home", fontSize = 20.sp, color = Color.Black)
                //Icon(painter = painterResource(id = com.example.firstappmobilecompose.R.drawable.guitaricon), contentDescription ="None" )

            }

            Button(
                onClick = { navController.navigate(route = AppScreens.PageTuner2.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = com.example.firstappmobilecompose.R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Tuner", fontSize = 20.sp, color = Color.Black)
            }

            Button(
                onClick = { navController.navigate(route = AppScreens.PageEarTraining.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = com.example.firstappmobilecompose.R.color.Secondary_Color
                    )
                )
            ) {
                Text(text = "Training", fontSize = 20.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun BodyContent(navController: NavController) {
    val activity = (LocalContext.current as? Activity)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = com.example.firstappmobilecompose.R.color.MainBlue))
    ) {

        item {
            Text(
                text = "Smart Tuner",
                fontSize = 40.sp,
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
                painter = painterResource(id = com.example.firstappmobilecompose.R.drawable.img_mobile),
                contentDescription = "Smart Tuner"
            )

            Text(
                text = "Hi, Daniel",
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

                ExtendedFloatingActionButton(
                    backgroundColor = colorResource(id = com.example.firstappmobilecompose.R.color.Blue_Buttom),
                    onClick = { navController.navigate(route = AppScreens.PageTuner2.route) },
                    text = { (Text(text = "Go Tune!", color = Color.White)) },
                )

                Spacer(modifier = Modifier.height(40.dp))

                ExtendedFloatingActionButton(
                    backgroundColor = colorResource(id = com.example.firstappmobilecompose.R.color.Red_Exit),
                    onClick = { activity?.finish() },
                    text = { (Text(text = "Exit", color = Color.White)) },
                )

                Spacer(modifier = Modifier.height(100.dp))

            }

        }
    }
}