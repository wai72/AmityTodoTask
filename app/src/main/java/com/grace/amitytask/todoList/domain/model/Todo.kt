package com.grace.amitytask.todoList.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val taskTitle: String,
    val isCompleted: Boolean
)
