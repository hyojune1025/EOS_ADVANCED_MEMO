package com.example.testintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnSet = findViewById<Button>(R.id.btn_set)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvId = findViewById<TextView>(R.id.tv_id)

        btnSet.setOnClickListener {
            tvName.text = intent.getStringExtra("name")
            tvId.text = intent.getIntExtra("id",0).toString()
            //tvId.text = "${intent.getIntExtra("id",0)}" 위랑 동일한 코드
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "돌아갔습니다!", Toast.LENGTH_SHORT).show()
        }
    }
}