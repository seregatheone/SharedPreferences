package com.example.a10

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.a10.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val backgroundArr = arrayListOf(R.drawable.france,R.drawable.chinese)

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val sharedPreferences: SharedPreferences by lazy {
        when (val state =
            application.getSharedPreferences("settings", Context.MODE_PRIVATE)) {
            null -> {
                val editor = state?.edit()
                editor!!.putStringSet("settings", setOf("", "","","",""))
                editor.apply()
                application.getSharedPreferences("settings", Context.MODE_PRIVATE)
            }
            else -> state
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val startSharedPrefs = sharedPreferences.getStringSet("settings", hashSetOf("1", "2","3","4","5"))

        binding.editText.setText(startSharedPrefs!!.toList()[0].toString())
        binding.editText1.setText(startSharedPrefs.toList()[1].toString())
        binding.editText2.setText(startSharedPrefs.toList()[2].toString())
        binding.editText3.setText(startSharedPrefs.toList()[3].toString())
        binding.editText4.setText(startSharedPrefs.toList()[4].toString())


        binding.button.setOnClickListener {
            val intent = Intent(this,InfoActivity::class.java)
            intent.putExtra("name",binding.editText.text.toString())
            intent.putExtra("surname",binding.editText1.text.toString())
            intent.putExtra("pat",binding.editText2.text.toString())
            intent.putExtra("age",binding.editText3.text.toString())
            intent.putExtra("hobby",binding.editText4.text.toString())
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_file,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.SharedPreference -> saveSharedPreferences(
                arrayOf(binding.editText.text.toString(),binding.editText1.text.toString(),binding.editText2.text.toString(),
                    binding.editText3.text.toString(),binding.editText4.text.toString()))
            R.id.RandomBackground -> randomBackground()
            R.id.NewActivity -> newActivityStart()
        }
        return true
    }

    private fun newActivityStart() {
        val intent = Intent(this, ExtraActivity::class.java)
        startActivity(intent)

    }

    private fun randomBackground() {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        constraintLayout.setBackgroundResource(backgroundArr[Random().nextInt(2)])
    }

    private fun saveSharedPreferences(vararg: Array<String>) {
        val state =
            application.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = state?.edit()
        editor!!.putStringSet("settings", setOf(vararg[0],vararg[1],vararg[2],
            vararg[3],vararg[4]))
        editor.apply()
        application.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }
}