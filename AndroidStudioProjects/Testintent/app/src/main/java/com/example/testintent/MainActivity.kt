package com.example.testintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btn_next)
        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_id)

        btnNext.setOnClickListener {
            //현재 액티비티에서 SecondActivity 로 넘어가는 인텐트
            var intent = Intent(this, SecondActivity::class.java)

            // Edit Text 에 적은 Name 과 id 를 넘겨주는 코드
            // name 은 String, id 는 int 타입
            intent.putExtra("name",etName.text.toString())
            intent.putExtra("id",Integer.parseInt(etId.text.toString()))

            startActivity(intent)
        }
    }
}