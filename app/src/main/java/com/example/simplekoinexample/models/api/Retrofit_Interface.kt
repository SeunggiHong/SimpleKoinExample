package com.example.simplekoinexample.models.api

import com.example.simplekoinexample.models.data.TodoData
import io.reactivex.Single
import retrofit2.http.GET

interface Retrofit_Interface {

    // rx
    @GET("todos")
    fun getAllTodo() : Single<List<TodoData>>

}