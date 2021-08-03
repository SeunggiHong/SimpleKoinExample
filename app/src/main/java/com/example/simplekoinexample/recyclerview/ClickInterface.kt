package com.example.simplekoinexample.recyclerview

import com.example.simplekoinexample.db.TodoData

interface ClickInterface {
    fun onDeleteClicked(todoData: TodoData)
}