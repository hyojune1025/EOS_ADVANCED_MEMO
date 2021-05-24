package com.example.firstassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, "김효준", Toast.LENGTH_SHORT).show()
            Log.d("student number","2020060319")
        }
    }
}