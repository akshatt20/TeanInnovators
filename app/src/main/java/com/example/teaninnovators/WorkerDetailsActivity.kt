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

class WorkerDetailsActivity : AppCompatActivity() {
    private lateinit var btnNext: Button
    private lateinit var regName: EditText
    private lateinit var regAge: EditText
    private lateinit var regGender: EditText
    private lateinit var regPhone: EditText
    private lateinit var regSkills: EditText
    private lateinit var regYearsOfWorking: EditText
    private lateinit var regPincode: EditText
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_details)
        btnNext = findViewById(R.id.btnNext)
        regName = findViewById(R.id.regName)
        regAge = findViewById(R.id.regAge)
        regGender = findViewById(R.id.regGender)
        regPhone = findViewById(R.id.regPhone)
        regSkills = findViewById(R.id.regSkills)
        regYearsOfWorking = findViewById(R.id.regYearsOfWorking)
        regPincode = findViewById(R.id.regPincode)
        dbRef= FirebaseDatabase.getInstance().getReference("WorkerDetails")
        btnNext.setOnClickListener {
            val intent = Intent(this, WorkerAccessActivity::class.java)
            startActivity(intent)
        }

    }
    private fun saveWorkerDetails()
    {
        val workerName=regName.text.toString()
        val workerAge=regAge.text.toString()
        val workerGender=regGender.text.toString()
        val workerNo=regPhone.text.toString()
        val workerSkills=regSkills.text.toString()
        val workerYears=regYearsOfWorking.text.toString()
        val workerPass=regPincode.text.toString()
        if(workerName.isEmpty()){
            regName.error="Please enter Name"
        }
        if(workerAge.isEmpty()){
            regAge.error="Please enter Age"
        }
        if(workerGender.isEmpty()){
            regGender.error="Please enterGender"
        }
        if(workerNo.isEmpty()){
            regPhone.error="Please enter mobile number"
        }
        if(workerSkills.isEmpty()){
        regSkills.error="Please enter Skills"
    }
        if(workerYears.isEmpty()){
            regYearsOfWorking.error="Please enter Years of working"
        }
        if(workerPass.isEmpty()){
            regPincode.error="Please enter Pincode"
        }
        val workerId=dbRef.push().key!!
        val worker=UserModelWorker(workerId,workerName,workerAge,workerGender,workerNo,workerSkills,workerYears,workerPass)
        dbRef.child(workerId).setValue(worker).addOnCompleteListener{
            Toast.makeText(this,"Data inserted succeusfully", Toast.LENGTH_LONG).show()

        }.addOnFailureListener{ err->
            Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()
        }


    }
}