package com.example.simplekoinexample.retrofit

import com.example.simplekoinexample.db.TodoData
import io.reactivex.Single
import retrofit2.http.GET

interface Retrofit_Interface {

    // rx
    @GET("todos")
    fun getAllTodo() : Single<List<TodoData>>

}