package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Queries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queries)

        var payName = findViewById<EditText>(R.id.payName)
        var payPhone = findViewById<EditText>(R.id.payPhone)
        var payEmail = findViewById<EditText>(R.id.payEmail)
        var comment = findViewById<EditText>(R.id.comment)


        val send = findViewById<Button>(R.id.sendBtn)
        send.setOnClickListener {
            val name = payName.text.toString()
            val phone = payPhone.text.toString()
            val email = payEmail.text.toString()
            val commentText = comment.text.toString()

            if (name.isBlank() || phone.isBlank() || email.isBlank() || commentText.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}