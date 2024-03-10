package com.example.teaninnovators


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var forgotPasswordOption: TextView
    private lateinit var logBtn: Button
    private lateinit var logNum: EditText
    private lateinit var logPass: EditText
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        forgotPasswordOption = findViewById(R.id.forgotPasswordOption)
        logBtn = findViewById(R.id.logBtn)

        logBtn.setOnClickListener {
            val num = logNum.text.toString()
            val pass = logPass.text.toString()

            login(num, pass)
//            val intent = Intent(this, RoleActivity::class.java)
//            startActivity(intent)
        }
        forgotPasswordOption.setOnClickListener {
            val intent = Intent(this, OtpVerificationActivity::class.java)
            startActivity(intent)
        }
    }
    private fun login(num: String, pass: String) {
        mAuth.signInWithEmailAndPassword(num, pass)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    // code to login user
                    val intent = Intent(this@LoginActivity, RoleActivity::class.java)
                    finish()
                    startActivity(intent)
                } else{
                    Toast.makeText(this@LoginActivity, "User doesn't exist", Toast.LENGTH_SHORT).show()

                }
            }
    }
}