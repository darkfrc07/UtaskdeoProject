package com.example.utaskdeo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_third, container, false)

        val button_cerrar_sesion = root.findViewById<TextView>(R.id.cerrar_sesion_button)

        button_cerrar_sesion.setOnClickListener {

            FirebaseAuth.getInstance().signOut();
            findNavController().navigate(R.id.action_thirdFragment_to_mainActivity)
        }

        // Inflate the layout for this fragment
        return root
    }


}