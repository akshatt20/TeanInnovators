
package com.example.teaninnovators


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpDetailsActivity : AppCompatActivity() {
    private lateinit var regBtnSignUp: Button
    private lateinit var signInOption: TextView
    private lateinit var regName: EditText
    private lateinit var regNumber: EditText
    private lateinit var regPassword: EditText

    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_details)
        supportActionBar?.hide()

        regBtnSignUp = findViewById(R.id.regBtnSignUp)
        signInOption = findViewById(R.id.signInOption)
        regName = findViewById(R.id.regName)
        regNumber = findViewById(R.id.regNumber)
        regPassword = findViewById(R.id.regPassword)

        mAuth = FirebaseAuth.getInstance()

        regBtnSignUp.setOnClickListener {
            val name = regName.text.toString()
            val number = regNumber.text.toString()
            val password = regPassword.text.toString()

            signUp(name, number, password)
//            val intent = Intent(this, RoleActivity::class.java)
//            startActivity(intent)
        }
        signInOption.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUp(name: String, number: String, password: String) {
        mAuth.createUserWithEmailAndPassword(number, password)
            .addOnCompleteListener(this){
                task ->
                if (task.isSuccessful) {
                    // code to move to home activity
                    addUserToDatabase(name, number, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUpDetailsActivity, RoleActivity::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignUpDetailsActivity, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uid: String?) {
        mDbRef = FirebaseDatabase.getInstance().reference

        if (uid != null) {
            mDbRef.child("user").child(uid).setValue(EmployeeData(name, email, uid))
        }
    }
}