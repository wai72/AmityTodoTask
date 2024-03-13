package com.grace.amitytask.todoList.data.repository

import com.grace.amitytask.todoList.data.remote.TodoApi
import com.grace.amitytask.todoList.domain.model.Todo
import javax.inject.Inject

class TodoNetworkRepository @Inject constructor(
    private val api: TodoApi,
) {
    suspend fun getTodosFormAPI() : List<Todo>{
        return api.getTodosFormAPI();
    }
}