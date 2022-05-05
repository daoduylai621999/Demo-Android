package com.example.recyclerview.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {
    private val _titleHistory = MutableLiveData<String>().apply {
        value = "This is History Fragment"
    }

    val titleHistory : LiveData<String> = _titleHistory
}