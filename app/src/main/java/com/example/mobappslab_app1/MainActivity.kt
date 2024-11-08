package com.example.mobappslab_app1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var data: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = findViewById<TextView>(R.id.hello_tv)
        val editText = findViewById<TextView>(R.id.edit_text_1)
        textView.text = "Hello, World!"
        editText?.setOnEditorActionListener() { v, actionId, event ->
            data = editText.text.toString()
            true
        }
    }


    fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}