package com.jabama.challenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _description = MutableLiveData(0)
    val description: LiveData<Int> = _description

}