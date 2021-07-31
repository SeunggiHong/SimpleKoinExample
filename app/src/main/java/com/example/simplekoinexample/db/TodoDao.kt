package com.example.simplekoinexample.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Insert
    fun insert(todo: TodoData)

    @Delete
    fun delete(todo: TodoData)

    @Update
    fun update(todo: TodoData)

    @Query("SELECT * FROM todo ORDER BY id DESC")
    fun getAllTodo(): LiveData<List<TodoData>>

}