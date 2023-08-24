package com.calculator.todolist.adopter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.calculator.todolist.R
import com.calculator.todolist.ViewModel.ToDoModel

class CustomAdopter(private val toDoList : List<ToDoModel>):RecyclerView.Adapter<CustomAdopter.viewHolder>() {

    class viewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {
        val startTime : TextView = itemView.findViewById(R.id.startTimeDisplayer);
        val endTime : TextView = itemView.findViewById(R.id.endTimeDisplayer);
        val todoContent : TextView = itemView.findViewById(R.id.todoContentDisplayer);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todolistview, parent, false)
        return viewHolder(view)
    }


    override fun getItemCount(): Int {
  return toDoList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
 val toDoModel = toDoList[position]
        holder.startTime.text = toDoModel.startTime
        holder.endTime.text = toDoModel.endTime
        holder.todoContent.text = toDoModel.taskToDo
    }

}