package com.example.expense_share_app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.NumberFormat
import com.example.expense_share_app.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Setup a click listener on the calculate button to calculate the tip
        binding.calculateButton.setOnClickListener { calculateShare() }

//        // Set up a key listener on the EditText field to listen for "enter" button presses
//        binding.calculateButton.setOnKeyListener { view, keyCode, _ ->
//            handleKeyEvent(
//                view,
//                keyCode
//            )
    }


    /**
     * Calculates the share based on the user input.
     */
    private fun calculateShare() {
        // Get the decimal value from the cost of service EditText field
        val string1 = binding.amountEditText.text.toString()
        val string2 = binding.share1EditText.text.toString()
        val string3 = binding.share2EditText.text.toString()
        val string4 = binding.share3EditText.text.toString()
        val string5 = binding.share4EditText.text.toString()

        val amount = string1.toDoubleOrNull()
        val s1 = string2.toDoubleOrNull()
        val s2 = string3.toDoubleOrNull()
        val s3 = string4.toDoubleOrNull()
        val s4 = string5.toDoubleOrNull()

        // If the cost is null or 0, then display 0 amount.
        if (amount == null || amount == 0.0) {
            display(0.0, 0.0, 0.0, 0.0 )
            return
        }


        // Calculate the share
        val result1 = amount * s1!! * 0.01
        val result2 = amount * s2!! * 0.01
        val result3 = amount * s3!! *0.01
        val result4 = amount * s4!! *0.01

        display(result1, result2, result3, result4)
    }

        /**
         * Format the share amount according to the local currency and display it onscreen.
         */
        private fun display(result1: Double, result2: Double, result3: Double, result4: Double) {
            val fShare1 = NumberFormat.getCurrencyInstance().format(result1)
            val fShare2 = NumberFormat.getCurrencyInstance().format(result2)
            val fShare3 = NumberFormat.getCurrencyInstance().format(result3)
            val fShare4 = NumberFormat.getCurrencyInstance().format(result4)

            binding.result1.text = getString(R.string.share_amount, fShare1)
            binding.result2.text = getString(R.string.share_amount, fShare2)
            binding.result3.text = getString(R.string.share_amount, fShare3)
            binding.result4.text = getString(R.string.share_amount, fShare4)
        }

        /**
         * Key listener for hiding the keyboard when the "Enter" button is tapped.
         */
        fun handleKeyEvent(view: View, keyCode: Int): Boolean {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                // Hide the keyboard
                val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                return true
            }
            return false
        }

    }