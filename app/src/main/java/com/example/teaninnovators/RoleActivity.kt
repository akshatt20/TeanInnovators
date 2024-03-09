package com.example.teaninnovators


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R

class RoleActivity : AppCompatActivity() {
    private lateinit var employerSymbol: ImageView
    private lateinit var workerSymbol: ImageView
    private lateinit var employerText: TextView
    private lateinit var textWorker: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role)
        employerSymbol = findViewById(R.id.employerSymbol)
        workerSymbol = findViewById(R.id.workerSymbol)
        employerText = findViewById(R.id.employerText)
        textWorker = findViewById(R.id.textWorker)
        employerSymbol.setOnClickListener {
            val intent = Intent(this, EmployerDetailsActivity::class.java)
            startActivity(intent)
        }
        workerSymbol.setOnClickListener {
            val intent = Intent(this, WorkerDetailsActivity::class.java)
            startActivity(intent)
        }
        employerText.setOnClickListener {
            val intent = Intent(this, EmployerDetailsActivity::class.java)
            startActivity(intent)
        }
        textWorker.setOnClickListener {
            val intent = Intent(this, WorkerDetailsActivity::class.java)
            startActivity(intent)
        }

    }
}