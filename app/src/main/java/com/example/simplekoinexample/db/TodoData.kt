package com.example.simplekoinexample.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "todo")
@Parcelize()
data class TodoData(
        @PrimaryKey(autoGenerate = true)
        val id: Long?,
        @ColumnInfo(name = "title")
        val title: String,
        @ColumnInfo(name = "content")
        val content: String
): Parcelable