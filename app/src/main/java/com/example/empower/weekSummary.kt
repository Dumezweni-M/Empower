package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class weekSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weeksummary)


//------------------- INDIVIDUAL COURSE BUTTONS ---------------------------------------------------
        var btnCook = findViewById<Button>(R.id.btnCoo)
        btnCook.setOnClickListener {
            val intent = Intent(this, course::class.java)
            startActivity(intent)
        }


        var btnChild = findViewById<Button>(R.id.btnChi)
        btnChild.setOnClickListener {
            val intent = Intent(this, childMinding::class.java)
            startActivity(intent)
        }

        var btnGarden = findViewById<Button>(R.id.btnGar)
        btnGarden.setOnClickListener {
            val intent = Intent(this, gardenMaintanance::class.java)
            startActivity(intent)
        }




//------------------- NAVIGATION BUTTONS ---------------------------------------------------

        var btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, monthSummary::class.java)
            startActivity(intent)
        }
    }
}