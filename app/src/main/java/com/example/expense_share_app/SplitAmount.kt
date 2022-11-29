package com.example.expense_share_app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.expense_share_app.databinding.ActivitySplitAmountBinding
import java.text.NumberFormat

class SplitAmount : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySplitAmountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplitAmountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val amountr = intent.getIntExtra("Extra_amount", 0)
        val HeaderString1 = "Total Amount: $amountr"
        binding.Amount.text = HeaderString1

        val person_name = intent.getStringExtra("Person")
        val HeaderString2 = "Paid By: $person_name"
        binding.paidBy.text = HeaderString2

        val size2 = intent.getIntExtra("size_from_pay_activity", 0)

        var string = (amountr.toDouble() / size2.toDouble())

        val fString = NumberFormat.getCurrencyInstance().format(string)

        if (size2 == 4) {
            binding.amount1.text = fString
            binding.amount2.text = fString
            binding.amount3.text = fString
            binding.amount4.text = fString
        }
        if (size2 == 3) {
            binding.amount1.text = fString
            binding.amount2.text = fString
            binding.amount3.text = fString
        }
        if (size2 == 2) {
            binding.amount1.text = fString
            binding.amount2.text = fString
        }
        if (size2 == 1) {
            binding.amount1.text = fString

        }
    }
}