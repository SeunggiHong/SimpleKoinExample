package com.example.simplekoinexample.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplekoinexample.models.api.RxSingleSchedulers
import com.example.simplekoinexample.models.data.TodoData
import com.example.simplekoinexample.models.repository.TodoRepository
import com.example.simplekoinexample.models.api.Retrofit_Interface
import com.example.simplekoinexample.utils.Constants.TAG
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application,
                    val apiService: Retrofit_Interface,
                    val schedulers: RxSingleSchedulers): AndroidViewModel(application) {

    private val repository: TodoRepository = TodoRepository(application)

    private val todoList = MutableLiveData<List<TodoData>>()
    private val allTodoList: LiveData<List<TodoData>> = repository.getAllTodoList()

    fun fetchTodo() {
        apiService.getAllTodo().subscribeOn(Schedulers.io())
            .compose(schedulers.applySchedulers())
            .subscribe({ result -> todoList.postValue(result) },
                {it ->

                })

    }

    fun saveTodo(todo: TodoData) {
        repository.saveTodo(todo)
        Log.d(TAG, "MainViewModel - saveTodo() called") 
    }

    fun updateTodo(todo: TodoData){
        repository.updateTodo(todo)
    }

    fun deleteTodo(todo: TodoData) {
        repository.deleteTodo(todo)
    }

    fun getAllTodoList(): LiveData<List<TodoData>> {
        Log.d(TAG, "MainViewModel - getAllTodoList() called")
        return allTodoList
    }

}