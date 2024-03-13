package com.grace.amitytask.todoList.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grace.amitytask.todoList.data.repository.TodoRepository
import com.grace.amitytask.todoList.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModal @Inject constructor(
    private val repository: TodoRepository,
    private val networkRepository: TodoNetworkRepository,
) : ViewModel(){
    var todo: Todo by mutableStateOf(Todo(0,"", false))
        private set


    init {
        getTodosFromNetwork()
    }

    val getTodoList : Flow<List<Todo>> = repository.getTodoList()

    private fun insertTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTodo(todo = todo)
        }
    }

    private fun deleteAllTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodoList()
        }
    }

    private fun getTodosFromNetwork(){
        deleteAllTodos()
        viewModelScope.launch {
            var todos = networkRepository.getTodos();
            println(todos)
            todos.forEach {
                insertTodo(it)
            }
        }
    }

}