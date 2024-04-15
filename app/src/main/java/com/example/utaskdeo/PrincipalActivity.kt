package com.example.utaskdeo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.utaskdeo.databinding.ActivityPrincipalBinding
import com.example.utaskdeo.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun setup (email: String, provider:String) {
        var txtemail : TextView = findViewById(R.id.usuariotextView)
        var txtproveedor : TextView = findViewById(R.id.proveedoriotextView)
        txtemail.text = email
        txtproveedor.text= provider



        val boton = binding.logoutbutton
        boton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}