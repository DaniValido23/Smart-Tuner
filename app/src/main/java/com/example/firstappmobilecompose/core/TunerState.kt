package com.example.firstappmobilecompose.core

import androidx.compose.ui.graphics.Color
import com.example.firstappmobilecompose.ui.theme.TunedColor
import com.example.firstappmobilecompose.ui.theme.OutOfTuneColor
import com.example.firstappmobilecompose.ui.theme.Black



sealed class TunerState(open val note: NotesEnum?, val bgColor: Color) {
    class Down(override val note: NotesEnum) : TunerState(note, OutOfTuneColor)
    class Tuned(override val note: NotesEnum) : TunerState(note, TunedColor)
    class Up(override val note: NotesEnum) : TunerState(note, OutOfTuneColor)
    object NoSound : TunerState(null, Black)
}