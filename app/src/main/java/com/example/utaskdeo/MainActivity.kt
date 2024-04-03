package com.example.utaskdeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.utaskdeo.databinding.ActivityLoginBinding
import com.example.utaskdeo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    }

    fun setupl(view: View) {

            val loginIntent : Intent = Intent( this, LoginActivity::class.java)
            startActivity(loginIntent)
    }
    fun setupr(view: View) {

        val registerIntent : Intent = Intent( this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }

}