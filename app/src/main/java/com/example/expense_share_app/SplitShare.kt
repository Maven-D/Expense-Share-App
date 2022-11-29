package com.example.expense_share_app

import android.content.Intent
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

        val amount = intent.getIntExtra("Extra_amount", 0)
        val Headerstring = "Total Amount: $amount"
        binding.Amount.text = Headerstring

        val personname = intent.getStringExtra("Person1")
        val Headerstring2 = "Paid by: $personname"
        binding.person.text = Headerstring2

        val size1 = intent.getIntExtra("size_from_pay_activity", 0)

        calculatShare()
        binding.calculate.setOnClickListener{
            calculatShare()
        }
    }


    private fun calculatShare(){
        val size1 = intent.getIntExtra("size_from_pay_activity", 0)
        val amountr = intent.getIntExtra("Extra_amount", 0)

        var s1 = binding.share1EditText.text.toString().toInt()
        var s2 = binding.share2EditText.text.toString().toInt()
        var s3 = binding.share3EditText.text.toString().toInt()
        var s4 = binding.share4EditText.text.toString().toInt()

        if(size1==3)
            s4=0
        if(size1==2){
            s3=0
            s4=0
        }
        if(size1==1) {
            s2 = 0
            s3 = 0
            s4 = 0
        }
//     Calculate the share
        val sum = s1 + s2 + s3 + s4
        val result1 = amountr * (s1.toDouble() / sum.toDouble())
        val result2 = amountr * (s2.toDouble() / sum.toDouble())
        val result3 = amountr * (s3.toDouble() / sum.toDouble())
        val result4 = amountr * (s4.toDouble() / sum.toDouble())

        val fShare1 = NumberFormat.getCurrencyInstance().format(result1)
        val fShare2 = NumberFormat.getCurrencyInstance().format(result2)
        val fShare3 = NumberFormat.getCurrencyInstance().format(result3)
        val fShare4 = NumberFormat.getCurrencyInstance().format(result4)

        binding.result1.text = fShare1
        binding.result2.text = fShare2
        binding.result3.text = fShare3
        binding.result4.text = fShare4
    }
}

