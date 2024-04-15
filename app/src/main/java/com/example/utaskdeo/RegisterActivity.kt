package com.example.utaskdeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.utaskdeo.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        val register_button : Button = findViewById(R.id.registro_button)
        val txtemail : EditText = findViewById(R.id.editTextTextEmailAdressR)
        val txtpass : EditText = findViewById(R.id.editTextTextPasswordR)


        register_button.setOnClickListener {
            setupp(txtemail.text.toString(), txtpass.text.toString())
        }

    }
    private fun setupp(editemail:String,editpassword:String){

            if (editemail.isNotEmpty() && editpassword.isNotEmpty()){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(editemail,
                    editpassword).addOnCompleteListener (this){task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Usuario creado.",Toast.LENGTH_SHORT).show()
                        val mainIntent : Intent = Intent( this, MainActivity::class.java)
                        startActivity(mainIntent)
                    }else{
                        showAlert()
                    }
                }
            }else {
                showAlertetEmpty()
            }


    }

    /*private fun showAlertExito() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Completado")
        builder.setMessage("Registro completado")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }*/

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al registrarse")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertetEmpty() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Los epacios no pueden estar vacios")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    //private fun showPrincipal(email: String, provider: ProviderType) {


    }
