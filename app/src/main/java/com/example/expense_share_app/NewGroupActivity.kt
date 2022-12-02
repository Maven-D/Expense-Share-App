package com.example.expense_share_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.expense_share_app.databinding.ActivityNewGroupBinding

class NewGroupActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNewGroupBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.backButton.setOnClickListener{
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.createButton.setOnClickListener{
            val n = binding.sizeEditText.text.toString().toInt()
            if(n!=0){
                val intent = Intent(applicationContext, MyGroupsActivity::class.java)
                intent.putExtra("size", n)
                startActivity(intent)
             }
            else if(n.toString() == "" || n==0){
                Toast.makeText(applicationContext, "There should be atleast one member in the group!", Toast.LENGTH_LONG).show()
            }

    }
    }

}