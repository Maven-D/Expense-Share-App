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
import android.util.Log
import android.widget.Toast
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

        val sizeReceived = intent.getIntExtra("size_sent", 0)

        binding.ByAmountBtn.setOnClickListener {
            val amounts = binding.amountEditText.text.toString().toInt()
            val person = binding.personEditText.text.toString()
            val purp = binding.purposeEditText.text.toString()
            if (amounts != 0) {
                val intent = Intent(applicationContext, SplitAmount::class.java)
                intent.putExtra("Extra_amount", amounts)
                intent.putExtra("size_from_pay_activity", sizeReceived)
                intent.putExtra("Person", person)

                intent.putExtra("purpose", purp)
                startActivity(intent)
            }
            else if ((amounts == null) || amounts == 0) {
                startActivity(intent)
            } else if ((amounts.toString() == null) || amounts == 0) {

                Toast.makeText(applicationContext, "Amount cannot be zero!", Toast.LENGTH_LONG)
                    .show()
            }
        }

        binding.BySplitBtn.setOnClickListener {
            val person = binding.personEditText.text.toString()
            Log.d("inside bysplitbtn", "onCreate: $person")
            val amounts = binding.amountEditText.text.toString().toInt()
            val purp = binding.purposeEditText.text.toString()

            if (amounts != 0) {
                val intent = Intent(this, SplitShare::class.java)
                intent.putExtra("Extra_amount", amounts)
                intent.putExtra("size_from_pay_activity", sizeReceived)
                intent.putExtra("Person", person)

                intent.putExtra("purpose", purp)

                startActivity(intent)

                val amount1 = binding.amountEditText.text.toString().toInt()
                val person1 = binding.personEditText.text.toString()
                if (amount1 != 0) {
                    val intent = Intent(applicationContext, SplitShare::class.java)
                    intent.putExtra("Extra_amount", amount1)
                    intent.putExtra("size_from_pay_activity", sizeReceived)
                    intent.putExtra("Person", person1)
                    startActivity(intent)
                }
            }

            binding.backButton.setOnClickListener {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
