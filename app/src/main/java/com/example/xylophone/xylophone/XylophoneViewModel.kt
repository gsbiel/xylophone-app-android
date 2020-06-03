package com.example.xylophone.xylophone
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _playEvent = MutableLiveData<String?>()
    val playEvent: LiveData<String?>
        get() = _playEvent

    init{
        _playEvent.value = null
    }

    fun onNotePressed(note: String) {
        _playEvent.value = note
    }
}