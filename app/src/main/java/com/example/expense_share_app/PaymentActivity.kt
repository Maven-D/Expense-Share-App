package com.example.expense_share_app
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.content.Context
import android.content.Intent
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.annotation.SuppressLint
import androidx.core.content.ContextCompat.getSystemService
import com.example.expense_share_app.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPaymentBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val size_received = intent.getIntExtra("size_sent", 0)

        binding.ByAmountBtn.setOnClickListener {
            val amounts = binding.amountEditText.text.toString().toInt()
            val person = binding.personEditText.text.toString()
            if (amounts != 0) {
                val intent = Intent(applicationContext, SplitAmount::class.java)
                intent.putExtra("Extra_amount", amounts)
                intent.putExtra("size_from_pay_activity", size_received)
                intent.putExtra("Person", person )
                startActivity(intent)
            }
        }

        binding.BySplitBtn.setOnClickListener {
            val amounts = binding.amountEditText.text.toString().toInt()
            val person = binding.personEditText.text.toString()
            if (amounts != 0) {
                Intent(this, SplitShare::class.java).also {
                    intent.putExtra("Extra_amount", amounts)
                    intent.putExtra("size_from_pay_activity", size_received)
                    intent.putExtra("Person", person )
                    startActivity(it)
                }
            }
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}
