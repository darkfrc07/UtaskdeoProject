package com.example.utaskdeo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utaskdeo.model.UserData
import com.example.utaskdeo.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondFragment : Fragment() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        /**set List*/
        userList = ArrayList()

        /**set find Id*/
        addsBtn = view.findViewById(R.id.addingBtn)
        recv = view.findViewById(R.id.mRecycler)

        /**set Adapter*/
        userAdapter = UserAdapter(requireContext(), userList)

        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = userAdapter

        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }

        return view
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(requireContext())
        val v = inflater.inflate(R.layout.item_add, null)

        /**set view*/
        val taskName = v.findViewById<EditText>(R.id.taskName)
        val description = v.findViewById<EditText>(R.id.taskDescription)

        val addDialog = AlertDialog.Builder(requireContext())

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val name = taskName.text.toString()
            val description = description.text.toString()
            userList.add(UserData("Nombre: $name", "Tarea : $description"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Tarea agregada", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(requireContext(), "Cancelar", Toast.LENGTH_SHORT).show()
        }

        addDialog.create().show()
    }
}
