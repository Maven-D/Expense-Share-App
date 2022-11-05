    package com.example.expense_share_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frame = findViewById<FrameLayout>(R.id.frame_layout)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val signupPage = SignupPage()
        val loginPage = LogIn()

        val bundle: Bundle? = intent.extras
        val callFrom = bundle?.get("callIntent")
        if(callFrom == 1) {
            fragmentTransaction.replace(frame.id, loginPage).commit()
        }
        else {
            fragmentTransaction.replace(R.id.frame_layout, signupPage).commit()
        }

    }
}