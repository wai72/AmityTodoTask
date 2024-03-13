package com.grace.amitytask.todoList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grace.amitytask.todoList.domain.model.Todo

@Database(entities = [Todo :: class], version = 1, exportSchema = true)
abstract class TodoDatabase : RoomDatabase(){
    abstract fun todoDao(): TodoDao
}