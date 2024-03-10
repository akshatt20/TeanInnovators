package com.example.teaninnovators


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R
class OtpVerificationActivity : AppCompatActivity() {
    private lateinit var verifyOtp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)
        verifyOtp = findViewById(R.id.verifyOtp)
        verifyOtp.setOnClickListener {
            val intent = Intent(this, RoleActivity::class.java)
            startActivity(intent)
        }
    }
}