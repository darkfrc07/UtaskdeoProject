import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utaskdeo.R
import com.example.utaskdeo.model.UserData
import com.example.utaskdeo.view.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class SecondFragment : Fragment() {

    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter<Any?>
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // Initialize Firebase components
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("Tasks").child(auth.currentUser!!.uid)

        // Initialize views
        addsBtn = view.findViewById(R.id.addingBtn)
        recv = view.findViewById(R.id.mRecycler)

        // Initialize userList and adapter
        userList = ArrayList()
        userAdapter = UserAdapter(requireContext(), userList)

        // Set RecyclerView layout manager and adapter
        recv.layoutManager = LinearLayoutManager(requireContext())
        recv.adapter = userAdapter

        // Set click listener for FloatingActionButton
        addsBtn.setOnClickListener { addInfo() }

        return view
    }

    private fun addInfo() {
        val inflater = LayoutInflater.from(requireContext())
        val v = inflater.inflate(R.layout.item_add, null)

        // Get references to EditText views
        val taskName = v.findViewById<EditText>(R.id.taskName)
        val description = v.findViewById<EditText>(R.id.taskDescription)

        // Create and show AlertDialog for adding task info
        AlertDialog.Builder(requireContext())
            .setView(v)
            .setPositiveButton("Ok") { dialog, _ ->
                val name = taskName.text.toString()
                val descriptionText = description.text.toString()
                // Add task info to userList
                userList.add(UserData("Nombre: $name", "Tarea: $descriptionText"))
                // Notify adapter of data change
                userAdapter.notifyDataSetChanged()
                Toast.makeText(requireContext(), "Tarea agregada", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(requireContext(), "Cancelar", Toast.LENGTH_SHORT).show()
            }
            .create()
            .show()
    }
    //
}
