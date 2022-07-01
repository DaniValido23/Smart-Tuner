package com.example.firstappmobilecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstappmobilecompose.MainViewModel
import com.example.firstappmobilecompose.core.TunerState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstappmobilecompose.screens.*
@Composable
fun AppNavigation(viewModel: TunerState) {

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.PagePrincipal.route){
        composable(route = AppScreens.PagePrincipal.route){
            PagePrincipal(navController)
        }

        composable(route = AppScreens.PageEarTraining.route){
            PageEarTraining(navController)
        }

        /*composable(route = AppScreens.PageTuner.route){
            PageTuner(navController)
        }*/

        composable(route = AppScreens.Levels.route){
            Levels(navController)
        }

        composable(route = AppScreens.PageTuner2.route){
            TunerScreen(navController,viewModel)
        }
    }
}