package com.example.utaskdeo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)

        val button_tareas = root.findViewById<Button>(R.id.boton_tarea)
        val button_perfil1 = root.findViewById<TextView>(R.id.boton_perfil1)
        val button_perfil2 = root.findViewById<BottomNavigationItemView>(R.id.Perfil)
        val button_notificaciones = root.findViewById<BottomNavigationItemView>(R.id.Notif)
        val button_tareas1 = root.findViewById<BottomNavigationItemView>(R.id.Tareas)

        button_tareas.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment2)
        }
        button_perfil1.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
        button_perfil2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
        button_notificaciones.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_fourthFragment)
        }
        button_tareas1.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_fifthFragment)
        }




        /*bottomNavigationView.setOnClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.tarea ->{

                }

            }
        }*/
        return root
    }
    }
