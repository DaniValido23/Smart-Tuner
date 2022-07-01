package com.example.firstappmobilecompose.navigation

import com.example.firstappmobilecompose.R


sealed class AppScreens(var route:String,var icon:Int,var title:String){
    object PagePrincipal : AppScreens("PagePrincipal", R.drawable.home,"HOME")
    object PageEarTraining : AppScreens("PageEarTrAINING",R.drawable.hearing,"TRAINING")
    //object PageTuner : AppScreens(" PageTuner",R.drawable.guitar,"TUNER")
    object Levels:AppScreens("Levels",R.drawable.hearing,"Levels")
    object PageTuner2:AppScreens("PageTuner2",R.drawable.guitar,"Tuner2")
}
