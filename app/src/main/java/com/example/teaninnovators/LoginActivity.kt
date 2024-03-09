package com.example.teaninnovators


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R


class LoginActivity : AppCompatActivity() {
    private lateinit var forgotPasswordOption: TextView
    private lateinit var logBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        forgotPasswordOption = findViewById(R.id.forgotPasswordOption)
        logBtn = findViewById(R.id.logBtn)
        logBtn.setOnClickListener {
            val intent = Intent(this, RoleActivity::class.java)
            startActivity(intent)
        }
        forgotPasswordOption.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }


    }
}