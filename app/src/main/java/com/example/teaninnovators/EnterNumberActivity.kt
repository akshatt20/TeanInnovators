package com.example.teaninnovators

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R



class EnterNumberActivity : AppCompatActivity() {
    private lateinit var sendOtpButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_number)
        sendOtpButton = findViewById(R.id.sendOtpButton)
        sendOtpButton.setOnClickListener {
            val intent = Intent(this, OtpVerificationActivity::class.java)
            startActivity(intent)
        }
    }
}