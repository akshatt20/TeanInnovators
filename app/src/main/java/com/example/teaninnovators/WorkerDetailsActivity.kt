package com.example.teaninnovators

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R

class WorkerDetailsActivity : AppCompatActivity() {
    private lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_details)
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, WorkerAccessActivity::class.java)
            startActivity(intent)
        }
    }
}