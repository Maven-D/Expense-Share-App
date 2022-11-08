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
        val stringInTextField = binding.amountEditText.text.toString()
        val amount = stringInTextField.toDoubleOrNull()

        // If the cost is null or 0, then display 0 tip and exit this function early.
        if (amount == null || amount == 0.0) {
            display(0.0)
            return
        }


        // Calculate the share
        var share = amount * 0.5

        display(share)
    }

        /**
         * Format the share amount according to the local currency and display it onscreen.
         */
        private fun display(share: Double) {
            val formattedShare = NumberFormat.getCurrencyInstance().format(share)
            binding.result.text = getString(R.string.share_amount, formattedShare)
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


//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_payment)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
//}