package com.example.teaninnovators

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.TeanInnovators.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class EmployerDetailsActivity : AppCompatActivity() {
    private lateinit var regNameEmployer: EditText
    private lateinit var regPhoneEmployer: EditText
    private lateinit var regPincodeEmployer: EditText

    private lateinit var dbRef: DatabaseReference
    private lateinit var btnNextEmp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_details)
        regNameEmployer = findViewById(R.id.regNameEmployer)
        regPhoneEmployer = findViewById(R.id.regPhoneEmployer)
        regPincodeEmployer = findViewById(R.id.regPincodeEmployer)

        dbRef= FirebaseDatabase.getInstance().getReference("EmployerDetails")
        btnNextEmp = findViewById(R.id.btnNextEmp)
        btnNextEmp.setOnClickListener {
            saveEmployeeDetails()
            val intent = Intent(this, EmployerAccessActivity::class.java)
            startActivity(intent)
        }
    }
    private fun saveEmployeeDetails()
    {
        val empName=regNameEmployer.text.toString()
        val empMobileNum=regPhoneEmployer.text.toString()
        val empPin=regPincodeEmployer.text.toString()
        if(empName.isEmpty()){
            regNameEmployer.error="Please enter Name"
        }
        if(empMobileNum.isEmpty()){
            regPhoneEmployer.error="Please enter Password"
        }
        if(empPin.isEmpty()){
            regPincodeEmployer.error="Please enter Password"
        }
        val employerId=dbRef.push().key!!
        val consumer=cons(employerId,empName,empMobileNum,empPin)
        dbRef.child(employerId).setValue(consumer).addOnCompleteListener{
            Toast.makeText(this,"Data inserted succeusfully", Toast.LENGTH_LONG).show()

        }.addOnFailureListener{ err->
            Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
        }
    }
}