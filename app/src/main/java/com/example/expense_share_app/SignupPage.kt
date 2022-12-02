package com.example.expense_share_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.expense_share_app.databinding.FragmentSignupPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SignupPage : Fragment() {
     private lateinit var _binding: com.example.expense_share_app.databinding.FragmentSignupPageBinding
     private val binding get()= _binding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): ConstraintLayout {
        super.onCreate(savedInstanceState)
        _binding = FragmentSignupPageBinding.inflate(inflater, container,false)
        auth = Firebase.auth
        val user = auth.currentUser
        if(user != null) {
            startActivity(Intent(context, HomeActivity::class.java))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val signInButton = view.findViewById<Button>(R.id.sign_in_button)
        signInButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("callIntent", 1)
                    startActivity(intent)
        })

        val name = view.findViewById<EditText>(R.id.name_edit_text)
        val email = view.findViewById<EditText>(R.id.email_edit_text)
        val password = view.findViewById<EditText>(R.id.password_edit_text)
        val confirmPassword = view.findViewById<EditText>(R.id.confirmPassword_edit_text)

        val signUpButton = view.findViewById<Button>(R.id.sign_up_button)
        signUpButton.setOnClickListener(View.OnClickListener {
            if(confirmPassword.text.toString() != password.text.toString()) {
                Toast.makeText(context, "Please Confirm the password correctly", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener() { task ->
                if(task.isSuccessful) {

                    auth.currentUser?.sendEmailVerification()?.addOnCompleteListener() { verify ->
                        if(verify.isSuccessful) {
                            val userName = name.text.toString()
                            val userEmail = name.text.toString()
                            val userPassword = name.text.toString()
                            val ref = Firebase.database.reference
                            val newUser = User(userName, userEmail, userPassword)
                            ref.child("users").child(newUser.encodeData(userEmail)).setValue(newUser)
                        }
                    }
                }
                else {
                    Toast.makeText(context, "Invalid input data", Toast.LENGTH_SHORT).show()
                }
            }
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("callIntent", 1)
            startActivity(intent)
        })
    }
}