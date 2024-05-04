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
        val view = binding.root
        setContentView(view)


        val txtemail : EditText = findViewById(R.id.editTextTextEmailAddress)
        val txtpass : EditText = findViewById(R.id.editTextTextPassword)


       binding.buttonIniciaSesion.setOnClickListener {
            setupp(txtemail.text.toString(), txtpass.text.toString())
        }

        binding.olvContrasenaButton.setOnClickListener{
            val chPassIntent : Intent = Intent( this, ChpassActivity::class.java)
            startActivity(chPassIntent)

        }

    }
    private fun setupp(editemail:String,editpassword:String){

            if (editemail.isNotEmpty() && editpassword.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(editemail,
                    editpassword).addOnCompleteListener(this){task ->
                    if (task.isSuccessful){
                        val verificado = FirebaseAuth.getInstance().currentUser?.isEmailVerified
                        if (verificado == true) {
                            Toast.makeText(this, "Bienvenido.", Toast.LENGTH_SHORT).show()

                            val principalIntent: Intent =
                                Intent(this, PrincipalActivity::class.java)
                            startActivity(principalIntent)
                        }else{
                            showAlertVerify()
                        }


                    }else{
                        showAlert()
                    }
                }
            }else{
                showAlertetEmpty()
            }


    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el inicio de sesion, verifique sus credenciales")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlertetEmpty() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Ingrese sus credenciales")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertVerify() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Su correo aun no ha sido verificado, por favor verifiquelo.")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    //private fun showPrincipal() {}


}