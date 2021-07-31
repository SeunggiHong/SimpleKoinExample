package com.example.simplekoinexample.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplekoinexample.R
import com.example.simplekoinexample.db.TodoData

class TodoAdapter : RecyclerView.Adapter<TodoItemViewHolder>() {

    var todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val todoItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoItemViewHolder(todoItemViewHolder)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bindWithView(this.todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setItems(it: List<TodoData>) {
        this.todoList = it.toMutableList()
        notifyDataSetChanged()
    }

}