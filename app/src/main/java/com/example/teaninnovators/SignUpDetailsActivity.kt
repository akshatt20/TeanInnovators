
package com.example.electrothonproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R

class SignUpDetailsActivity : AppCompatActivity() {
    private lateinit var regBtnSignUp: Button
    private lateinit var signInOption: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_details)
        regBtnSignUp = findViewById(R.id.regBtnSignUp)
        signInOption = findViewById(R.id.signInOption)
        regBtnSignUp.setOnClickListener {
            val intent = Intent(this, RoleActivity::class.java)
            startActivity(intent)

        }
        signInOption.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}