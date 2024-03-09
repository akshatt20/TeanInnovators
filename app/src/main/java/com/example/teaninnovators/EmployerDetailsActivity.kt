package com.example.teaninnovators

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R



class EmployerDetailsActivity : AppCompatActivity() {
    private lateinit var btnNextEmp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_details)
        btnNextEmp = findViewById(R.id.btnNextEmp)
        btnNextEmp.setOnClickListener {
            val intent = Intent(this, EmployerAccessActivity::class.java)
            startActivity(intent)
        }
    }
}