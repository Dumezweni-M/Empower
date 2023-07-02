package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class monthSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthsummary)

//------------------- INDIVIDUAL COURSE BUTTONS ---------------------------------------------------


    var btnSew = findViewById<Button>(R.id.btnSew)
        btnSew.setOnClickListener {
            val intent = Intent(this, sewing::class.java)
            startActivity(intent)
        }


    var btnSki = findViewById<Button>(R.id.btnSki)
        btnSki.setOnClickListener {
            val intent = Intent(this, skills::class.java)
            startActivity(intent)
        }
    var btnAid = findViewById<Button>(R.id.btnAid)
        btnAid.setOnClickListener {
            val intent = Intent(this, aid::class.java)
            startActivity(intent)
        }

    var btnSca = findViewById<Button>(R.id.btnSca)
        btnSca.setOnClickListener {
            val intent = Intent(this, scaping::class.java)
            startActivity(intent)
        }



//--------------------------- NAVIGATION  ------------------------------------------------
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, weekSummary::class.java)
            startActivity(intent)
        }
    }
}