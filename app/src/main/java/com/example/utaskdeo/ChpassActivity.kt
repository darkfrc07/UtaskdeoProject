package com.example.utaskdeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.utaskdeo.databinding.ActivityChpassBinding
import com.google.firebase.auth.FirebaseAuth
class ChpassActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChpassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChpassBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val txtemail: EditText = findViewById(R.id.editTextCorreoCh)
        binding.chPassButton.setOnClickListener {
            setupp(txtemail.text.toString())
        }
    }
    private fun setupp(editemail: String) {
        if (editemail.isNotEmpty() ){

            FirebaseAuth.getInstance().sendPasswordResetEmail(editemail).addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    Toast.makeText(this,"Revise su correo.", Toast.LENGTH_SHORT).show()

                    val mainIntent : Intent = Intent( this, MainActivity::class.java)
                    startActivity(mainIntent)


                }else{
                    showAlert()
                }
            }
        }else{
            showAlertetEmpty()
        }

    }
    private fun showAlertetEmpty() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("El espacio no puede estar vacio, ingrese su e-mail")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Verifique el e-mail ingresado")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
}