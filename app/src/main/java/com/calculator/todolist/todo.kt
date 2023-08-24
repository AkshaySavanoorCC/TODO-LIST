package com.calculator.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calculator.todolist.ViewModel.ToDoModel
import com.calculator.todolist.adopter.CustomAdopter

class todo : AppCompatActivity() {
    lateinit var startTime:EditText
    lateinit var endTime:EditText
    lateinit var todoTask:EditText
    lateinit var addBtn : Button
    val data = ArrayList<ToDoModel>()
    lateinit var adaptor: CustomAdopter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        recyclerView = findViewById<RecyclerView>(R.id.recycleview)

//        val currentOrientation = resources.configuration.orientation
        startTime = findViewById(R.id.startTime)
        endTime = findViewById(R.id.endTime)
        todoTask = findViewById(R.id.todoContent)
        addBtn = findViewById(R.id.addBtn)


        addBtn.setOnClickListener {
            val stTime = startTime.text.toString()
            val edTime = endTime.text.toString()
            val task = todoTask.text.toString()
            if (stTime.isNotEmpty() && edTime.isNotEmpty() && task.isNotEmpty()) {
                val newTask = ToDoModel(stTime, edTime, task)
                data.add(newTask)
                adaptor.notifyDataSetChanged()
                startTime.text.clear()
                endTime.text.clear()
                todoTask.text.clear()
                hideKeyboard()


            }
            else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        adaptor = CustomAdopter(data)
        recyclerView.adapter = adaptor

    }
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

}