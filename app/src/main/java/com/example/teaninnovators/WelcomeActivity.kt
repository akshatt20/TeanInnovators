package com.example.teaninnovators



import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R

class WelcomeActivity : AppCompatActivity() {
    private lateinit var englishSymbol: ImageView
    private lateinit var hindiSymbol: ImageView
    private lateinit var hindiText: TextView
    private lateinit var englishText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Initialize englishsymbol using findViewById
        englishSymbol = findViewById(R.id.englishSymbol)
        hindiSymbol = findViewById(R.id.hindiSymbol)
        hindiText = findViewById(R.id.hindiText)
        englishText = findViewById(R.id.englishText)


        englishSymbol.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }
        hindiSymbol.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }
        hindiText.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }
        englishText.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }

    }
}