package com.example.expense_share_app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.expense_share_app.databinding.FragmentSignupPageBinding


class SignupPage : Fragment() {
     private var _binding: FragmentSignupPageBinding? = null
     private val binding get()= _binding!!

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): ConstraintLayout {
        super.onCreate(savedInstanceState)
        _binding = FragmentSignupPageBinding.inflate(inflater, container,false)
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
        val signUpButton = view.findViewById<Button>(R.id.sign_up_button)
        signUpButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        })
    }
}