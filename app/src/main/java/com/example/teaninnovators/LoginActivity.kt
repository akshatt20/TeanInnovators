package com.example.teaninnovators


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LoginActivity : AppCompatActivity() {
    private lateinit var forgotPasswordOption: TextView
    private lateinit var logBtn: Button
    private lateinit var logPhoneEnd: EditText
    private lateinit var logPass: EditText

    private lateinit var dbRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        forgotPasswordOption = findViewById(R.id.forgotPasswordOption)
        logBtn = findViewById(R.id.logBtn)
        logPass = findViewById(R.id.logPass)
        logPhoneEnd = findViewById(R.id.logPhoneEnd)


        dbRef=FirebaseDatabase.getInstance().getReference("LoginDetails")


        logBtn.setOnClickListener {
            saveLogInDetails()
            val intent = Intent(this, RoleActivity::class.java)
            startActivity(intent)
        }
        forgotPasswordOption.setOnClickListener {
            val intent = Intent(this, EnterNumberActivity::class.java)
            startActivity(intent)
        }
    }
    private fun saveLogInDetails()
    {
        val empMobileNo=logPhoneEnd.text.toString()
        val empPass=logPass.text.toString()
        if(empMobileNo.isEmpty()){
            logPhoneEnd.error="Please enter Mobile number"
        }
        if(empPass.isEmpty()){
            logPass.error="Please enter Password"
        }
        val empId=dbRef.push().key!!
        val employee=UserModel(empId,empMobileNo,empPass)
        dbRef.child(empId).setValue(employee).addOnCompleteListener{
            Toast.makeText(this,"Data inserted succeusfully",Toast.LENGTH_LONG).show()

        }.addOnFailureListener{ err->
           Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_LONG).show()
        }
}
}