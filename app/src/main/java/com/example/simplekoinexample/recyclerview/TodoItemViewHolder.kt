package com.example.simplekoinexample.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.simplekoinexample.db.TodoData
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val todoTitlte = itemView.tv_todo_title
    private val todoDescrpiton = itemView.tv_todo_description

    fun bindWithView(todoData: TodoData) {
        todoTitlte.text = todoData.title
    }

}