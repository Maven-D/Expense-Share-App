package com.example.expense_share_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.expense_share_app.databinding.ActivitySplitShareBinding
import java.text.NumberFormat

class SplitShare : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySplitShareBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplitShareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val amountr = intent.getIntExtra("Extra_amount", 0)
        val Headerstring = "Total Amount: $amountr"
        binding.Amount.text = Headerstring
        calculateShare()
    }

    private fun calculateShare(){
   val string1 = binding.share1EditText.text.toString()
   val string2 = binding.share2EditText.text.toString()
   val string3 = binding.share3EditText.text.toString()
   val string4 = binding.share4EditText.text.toString()

    val s1 = string1.toDoubleOrNull()
    val s2 = string2.toDoubleOrNull()
    val s3 = string3.toDoubleOrNull()
    val s4 = string4.toDoubleOrNull()

        val amountr = intent.getIntExtra("Extra_amount", 0)

        if (amountr == null || amountr == 0) {
            display(0.0, 0.0, 0.0, 0.0 )
            return
        }
        
//     Calculate the share
        val sum = s1!!+s2!!+s3!!+s4!!
        val result1 = amountr * (s1/sum)
        val result2 = amountr * (s2 /sum)
        val result3 = amountr *(s3 /sum)
        val result4 = amountr * (s4 /sum)

        display(result1, result2, result3, result4)
    }

 private fun display(result1: Double, result2: Double, result3: Double, result4: Double) {
            val fShare1 = NumberFormat.getCurrencyInstance().format(result1)
            val fShare2 = NumberFormat.getCurrencyInstance().format(result2)
            val fShare3 = NumberFormat.getCurrencyInstance().format(result3)
            val fShare4 = NumberFormat.getCurrencyInstance().format(result4)

            binding.result1.text =fShare1
            binding.result2.text = fShare2
            binding.result3.text = fShare3
            binding.result4.text = fShare4
        }
}