package com.grace.amitytask.todoList.data.repository

import com.grace.amitytask.todoList.data.local.TodoDao
import com.grace.amitytask.todoList.domain.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao) {
    suspend fun insertTodo(todo: Todo) : Unit = dao.insertToDo(todo = todo)

    fun getTodoList(): Flow<List<Todo>> = dao.getTodoList()

    fun deleteTodoList() : Unit = dao.deleteTodoList();
}