package com.grace.amitytask.todoList.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("title")
    val taskTitle: String,

    @SerializedName("completed")
    val isCompleted: Boolean
)
