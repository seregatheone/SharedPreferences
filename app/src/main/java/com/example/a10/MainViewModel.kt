package com.example.a10

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var number = 0
    val mutableLiveData:MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }



}