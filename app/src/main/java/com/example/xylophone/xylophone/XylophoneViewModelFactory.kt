package com.example.xylophone.xylophone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class XylophoneViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(XylophoneViewModel::class.java)){
            return XylophoneViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}