package com.example.a10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ExtraActivity : AppCompatActivity() {
    private val viewModel by lazy{ ViewModelProvider(this)[MainViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra)
        val button = findViewById<Button>(R.id.inc)
        val textView = findViewById<TextView>(R.id.number)

        viewModel.mutableLiveData.observe(this) {
            textView.text = it.toString()
        }
        button.setOnClickListener {
            viewModel.mutableLiveData.value = ++viewModel.number
        }


    }
}