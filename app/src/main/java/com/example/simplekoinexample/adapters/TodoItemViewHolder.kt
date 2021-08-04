package com.example.simplekoinexample.adapters

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.simplekoinexample.models.data.TodoData
import com.example.simplekoinexample.utils.Constants.TAG
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoItemViewHolder(itemView: View, clickInterface: ClickInterface) : RecyclerView.ViewHolder(itemView) {

    private val todoTitle = itemView.tv_todo_title
    private val todoContent = itemView.tv_todo_content
    private val todoDeleteBtn = itemView.iv_todo_delete

    private var mClickInterface: ClickInterface?= null

    init {
        Log.d(TAG, "TodoItemViewHolder init.")
        this.mClickInterface = clickInterface
    }

    fun bindViewHolder(todoData: TodoData) {
        todoTitle.text = todoData.title
        todoContent.text = todoData.content

        todoDeleteBtn.setOnClickListener {
            mClickInterface?.onDeleteClicked(todoData)
        }
    }

}