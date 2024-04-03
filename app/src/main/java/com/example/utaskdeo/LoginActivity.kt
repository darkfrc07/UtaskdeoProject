package com.example.utaskdeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.utaskdeo.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)


        val inicia_sesion_button : Button= findViewById(R.id.inicia_sesion_button)
        val txtemail : EditText = findViewById(R.id.editTextTextEmailAddress)
        val txtpass : EditText = findViewById(R.id.editTextTextEmailAddress)
        val back : ImageButton = findViewById(R.id.back_imageButton)

        inicia_sesion_button.setOnClickListener {
            setupp(txtemail.text.toString(), txtpass.text.toString())
        }

    }
    private fun setupp(editemail:String,editpassword:String){

            if (editemail.isNotEmpty() && editpassword.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(editemail,
                    editpassword).addOnCompleteListener(this){task ->
                    if (task.isSuccessful){
                        val principalIntent : Intent= Intent( this, PrincipalActivity::class.java)

                        startActivity(principalIntent)

                    }else{
                        showAlert()
                    }
                }
            }


    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el inicio de sesion")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    //private fun showPrincipal() {}


}