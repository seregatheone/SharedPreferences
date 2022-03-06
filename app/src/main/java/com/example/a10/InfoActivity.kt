package com.example.a10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val pat = intent.getStringExtra("pat")
        val age = intent.getStringExtra("age")
        val hobby = intent.getStringExtra("hobby")
        val textView = findViewById<TextView>(R.id.text)
        textView.text = name+"\n"+surname+"\n"+pat+"\n"+age+"\n"+hobby
    }
}