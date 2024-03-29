package com.grace.amitytask.todoList.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grace.amitytask.todoList.domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getTodoList(): Flow<List<Todo>>
}