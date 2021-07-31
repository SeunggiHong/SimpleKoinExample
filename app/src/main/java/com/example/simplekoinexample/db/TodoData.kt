package com.example.simplekoinexample.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoData(@PrimaryKey(autoGenerate = true) val id: Long,
                    @ColumnInfo(name = "title") val title: String,
                    @ColumnInfo(name = "content") val content: String)