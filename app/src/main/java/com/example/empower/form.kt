package com.example.empower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.time.measureTimedValue

class form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val payName = findViewById<EditText>(R.id.payName)
        val payPhone = findViewById<EditText>(R.id.payPhone)
        val payEmail = findViewById<EditText>(R.id.payEmail)

        val cardNum = findViewById<EditText>(R.id.tvCreditCardNumber)
        val expiryDate = findViewById<EditText>(R.id.tvExpiryDate)
        val secCode = findViewById<EditText>(R.id.tvSecurityCode)
        val billing = findViewById<EditText>(R.id.tvBillingAddress)

        val confirmPay = findViewById<Button>(R.id.confirmBtn)
        confirmPay.setOnClickListener {
            val name = payName.text.toString()
            val phone = payPhone.text.toString()
            val email = payEmail.text.toString()
            val cardNumber = cardNum.text.toString()
            val expiry = expiryDate.text.toString()
            val securityCode = secCode.text.toString()
            val billingAddress = billing.text.toString()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()
//               || cardNumber.isEmpty() ||  expiry.isEmpty() || securityCode.isEmpty() || billingAddress.isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                confirmPay.setOnClickListener {
                    val intent = Intent(this, Success::class.java)
                    startActivity(intent)
                }
            }
        }


        val receivedTotal = intent.getDoubleExtra("totalAmount", 0.0)

        val finalAmount = findViewById<TextView>(R.id.finalTotal)
        finalAmount.text = "Total : $receivedTotal"
    }
}