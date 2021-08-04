package com.example.simplekoinexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplekoinexample.R
import com.example.simplekoinexample.models.data.TodoData

class TodoAdapter(clickInterface: ClickInterface) : RecyclerView.Adapter<TodoItemViewHolder>() {
    private var mClickInterface: ClickInterface?= null

    init {
        this.mClickInterface = clickInterface
    }

    var todoList = mutableListOf<TodoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val todoItemViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoItemViewHolder(todoItemViewHolder, this.mClickInterface!!)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bindViewHolder(this.todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setItems(it: List<TodoData>) {
        this.todoList = it.toMutableList()
        notifyDataSetChanged()
    }

}