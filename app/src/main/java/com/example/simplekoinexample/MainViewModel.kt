package com.example.simplekoinexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplekoinexample.db.TodoData
import com.example.simplekoinexample.models.TodoRepository
import com.example.simplekoinexample.retrofit.Retrofit_Interface
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application,
    val apiService: Retrofit_Interface, val schedulers: RxSingleSchedulers): AndroidViewModel(application)
{
    private val repository: TodoRepository = TodoRepository(application)

    val todoList = MutableLiveData<List<TodoData>>()

    fun fetchTodo() {
        apiService.getAllTodo().subscribeOn(Schedulers.io())
            .compose(schedulers.applySchedulers())
            .subscribe({ result -> todoList.postValue(result) },
                {it ->

                })

    }

    fun saveTodo(todo: TodoData) {
        repository.saveTodo(todo)
    }

    fun updateTodo(todo: TodoData){
        repository.deleteTodo(todo)
    }

}