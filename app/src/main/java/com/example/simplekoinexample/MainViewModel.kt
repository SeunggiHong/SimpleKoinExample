package com.example.simplekoinexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplekoinexample.models.TodoData
import com.example.simplekoinexample.retrofit.Retrofit_Interface
import io.reactivex.schedulers.Schedulers

class MainViewModel(val apiService: Retrofit_Interface, val schedulers: RxSingleSchedulers): ViewModel() {

    val todoList = MutableLiveData<List<TodoData>>()

    fun fetchTodo() {
        apiService.getAllTodo().subscribeOn(Schedulers.io())
            .compose(schedulers.applySchedulers())
            .subscribe({ result -> todoList.postValue(result) },
                {it ->

                })

    }

}