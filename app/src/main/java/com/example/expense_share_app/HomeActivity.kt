package com.example.expense_share_app

import android.R
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.expense_share_app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private var drawer: DrawerLayout? = null
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView( binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val drawer = binding.drawerLayout
        val navView = binding.navView

        toggle = ActionBarDrawerToggle(this,
        drawer, R.string.ok, R.string.cancel)
        drawer!!.addDrawerListener(toggle)
        toggle.syncState()

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}