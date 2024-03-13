package com.grace.amitytask.todoList.data.remote

import com.grace.amitytask.todoList.domain.model.Todo
import retrofit2.http.GET

interface TodoApi {
    @GET("todos")
    suspend fun getTodosFormAPI(): List<Todo>
}