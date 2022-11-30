package com.example.expense_share_app

import android.os.Bundle

import android.text.Editable
import android.text.TextWatcher

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.ui.AppBarConfiguration
import com.example.expense_share_app.databinding.ActivitySplitShareBinding
import java.text.NumberFormat
import java.util.*
import kotlin.concurrent.schedule

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

        val size1 = intent.getIntExtra("size_from_pay_activity", 0)

        val s1 = binding.share1EditText
        val s2 = binding.share2EditText
        val s3 = binding.share3EditText
        val s4 = binding.share4EditText



        s1.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!validate(p0, s2.text, s3.text, s4.text)) return
                val share1 = p0.toString().toInt()
                val share2 = s2.text.toString().toInt()
                val share3 = s3.text.toString().toInt()
                val share4 = s4.text.toString().toInt()
                calculateShare(share1, share2, share3, share4, amountr)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        s2.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!validate(s1.text, p0, s3.text, s4.text)) return
                val share2 = p0.toString().toInt()
                val share1 = s1.text.toString().toInt()
                val share3 = s3.text.toString().toInt()
                val share4 = s4.text.toString().toInt()
                calculateShare(share1, share2, share3, share4, amountr)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        s3.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!validate(s1.text, s2.text, p0, s4.text)) return
                val share3 = p0.toString().toInt()
                val share2 = s2.text.toString().toInt()
                val share1 = s1.text.toString().toInt()
                val share4 = s4.text.toString().toInt()
                calculateShare(share1, share2, share3, share4, amountr)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        s4.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!validate(s1.text, s2.text, s3.text, p0)) return
                val share4 = p0.toString().toInt()
                val share2 = s2.text.toString().toInt()
                val share3 = s3.text.toString().toInt()
                val share1 = s1.text.toString().toInt()
                calculateShare(share1, share2, share3, share4, amountr)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

    }
    //     Calculate the share
    fun calculateShare(s1:Int, s2:Int, s3:Int, s4:Int, amountr:Int) {
        val sum = s1 + s2 + s3 + s4
        val result1 = (amountr * s1) / sum
        val result2 = (amountr * s2) / sum
        val result3 = (amountr * s3) / sum
        val result4 = (amountr * s4) / sum

        val fShare1 = NumberFormat.getCurrencyInstance().format(result1)
        val fShare2 = NumberFormat.getCurrencyInstance().format(result2)
        val fShare3 = NumberFormat.getCurrencyInstance().format(result3)
        val fShare4 = NumberFormat.getCurrencyInstance().format(result4)

        binding.result1.text =fShare1
        binding.result2.text = fShare2
        binding.result3.text = fShare3
        binding.result4.text = fShare4
    }

    fun validate(s1:Editable?, s2:Editable?, s3:Editable?, s4:Editable?) : Boolean {
        return s1 != null && s2 != null && s3 != null && s4 != null && s1.toString() != ""
                && s2.toString() != "" && s3.toString() != "" && s4.toString() != ""
    }

}