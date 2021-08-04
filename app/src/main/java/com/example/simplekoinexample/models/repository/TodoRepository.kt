package com.example.simplekoinexample.models.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.simplekoinexample.models.db.TodoDao
import com.example.simplekoinexample.models.data.TodoData
import com.example.simplekoinexample.models.db.TodoDatabase
import com.example.simplekoinexample.utils.Constants.TAG
import kotlinx.coroutines.*

/**
 *
 * coroutine으로 room 업데이트 처리
 *
 */
class TodoRepository(application: Application) {
    private val todoDao: TodoDao
    private val allTodoList: LiveData<List<TodoData>>

    init {
        val database = TodoDatabase.getInstance(application.applicationContext)
        todoDao = database!!.todoDao()
        allTodoList = todoDao.getAllTodo()

        val scope = CoroutineScope(Dispatchers.IO)
        Log.d(TAG, "TodoRepository init")
    }

    fun saveTodo(todo: TodoData) = runBlocking {
        this.launch (Dispatchers.IO){
            todoDao.insert(todo)
            Log.d(TAG, "TodoRepository - saveTodo()") 
        }
    }

    fun deleteTodo(todo: TodoData) = runBlocking {
        this.launch(Dispatchers.IO){
            todoDao.delete(todo)
            Log.d(TAG, "TodoRepository - deleteTodo() called")
        }
    }

    fun updateTodo(todo: TodoData) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.update(todo)
            Log.d(TAG, "TodoRepository - updateTodo() called")
        }
    }

    fun getAllTodoList() : LiveData<List<TodoData>> {
        return allTodoList
    }

}