package com.example.teaninnovators

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_access)

        val bottomNavigEmp = findViewById<BottomNavigationView>(R.id.bottomNavigEmp)

        val homeEmpFragment= HomeEmpfragment()
        val extraOptionFragment= ExtraOptionFragment()
        val messageEmpFragment= MessageEmpFragment()
        val paymentEmpFragment= PaymentEmpFragment()
        val postJobFragment= PostJobFragment()
        makeCurrentFragment(homeEmpFragment)


        bottomNavigEmp.setOnNavigationItemSelectedListener{
            when(it.itemId)
            {
                R.id.homeIcon->makeCurrentFragment(homeEmpFragment)
                R.id.messageIcon->makeCurrentFragment(extraOptionFragment)
                R.id.postJobIcon->makeCurrentFragment(messageEmpFragment)
                R.id.extraOptionsIcon->makeCurrentFragment(paymentEmpFragment)
                R.id.paymentIcon->makeCurrentFragment(paymentEmpFragment)
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.employerAcc,fragment)
            commit()
            }
}