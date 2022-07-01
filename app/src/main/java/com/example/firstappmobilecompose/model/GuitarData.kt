package com.example.firstappmobilecompose.model

import com.example.firstappmobilecompose.R

data class GuitarData (
    val title:String,
    val rating:Float,
    val desc:String,
    val imgUri:Int
    )

val guitarList = listOf(
    GuitarData(
        title = "Guitar1",
        rating = 4.0f,
        desc = "Guitar1",
        R.drawable.acoustic_guitar

    ),
    GuitarData(
        title = "Guitar2",
        rating = 4.0f,
        desc = "Guitar2",
        R.drawable.electric_guitar

    ),
    GuitarData(
        title = "Guitar3",
        rating = 4.0f,
        desc = "Guitar3",
        R.drawable.electric_acoustic_guitar

    )

)