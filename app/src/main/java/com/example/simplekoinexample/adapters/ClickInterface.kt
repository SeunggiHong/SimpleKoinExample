package com.example.simplekoinexample.adapters

import com.example.simplekoinexample.models.data.TodoData

interface ClickInterface {
    fun onDeleteClicked(todoData: TodoData)
}