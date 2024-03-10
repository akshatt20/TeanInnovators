package com.example.teaninnovators


import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.TeanInnovators.R
import com.example.teaninnovators.fragments.ExtraOptionFragment
import com.example.teaninnovators.fragments.HomeEmpfragment
import com.example.teaninnovators.fragments.MessageEmpFragment
import com.example.teaninnovators.fragments.PaymentEmpFragment
import com.example.teaninnovators.fragments.PostJobFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class EmployerAccessActivity : AppCompatActivity() {

    lateinit var frameLayout:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_access)

        val bottomNavigEmp = findViewById<BottomNavigationView>(R.id.bottomNavigEmp)
        frameLayout = findViewById(R.id.employerAcc)
        val homeEmpFragment= HomeEmpfragment()
        val extraOptionFragment= ExtraOptionFragment()
        val messageEmpFragment= MessageEmpFragment()
        val paymentEmpFragment= PaymentEmpFragment()
        val postJobFragment= PostJobFragment()
        
        makeCurrentFragment(HomeEmpfragment())

//        bottomNav = binding.bottomNavigEmp


        bottomNavigEmp.setOnItemSelectedListener{
            when(it.itemId)
            {

                R.id.homeIcon->makeCurrentFragment(HomeEmpfragment())
                R.id.messageIcon->makeCurrentFragment(MessageEmpFragment())
                R.id.postJobIcon->makeCurrentFragment(PostJobFragment())
                R.id.extraOptionsIcon->makeCurrentFragment(ExtraOptionFragment())
                R.id.paymentIcon->makeCurrentFragment(PaymentEmpFragment())
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.employerAcc,fragment)
        transaction.commit()
    }

}