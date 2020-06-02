package com.example.xylophone.xylophone

import android.util.Log
import androidx.lifecycle.ViewModel

class XylophoneViewModel: ViewModel() {

    // This variables are accessed in the layout file through data binding
    val note_C: String = "C"
    val note_D: String = "D"
    val note_E: String = "E"
    val note_F: String = "F"
    val note_G: String = "G"
    val note_A: String = "A"
    val note_B: String = "B"

    fun onNotePressed(note: String) {
        Log.i("XylophoneViewModel", "Tocar nota: ${note}")
    }
}