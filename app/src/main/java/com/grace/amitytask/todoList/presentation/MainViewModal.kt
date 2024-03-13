package com.grace.amitytask.todoList.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.grace.amitytask.todoList.data.repository.TodoNetworkRepository
import com.grace.amitytask.todoList.data.repository.TodoRepository
import com.grace.amitytask.todoList.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModal @Inject constructor(
    private val localRepository: TodoRepository,
    private val networkRepository: TodoNetworkRepository,
) : ViewModel(){
    val todoList : Flow<List<Todo>> = localRepository.getTodoList()
    val todoListLiveData: LiveData<List<Todo>> = localRepository.getTodoList().asLiveData()

    init {
        checkAlreadySaveToLocalDB()
    }
    private fun insertTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.insertTodo(todo = todo)
        }
    }

    private fun getTodosFromNetwork(){
        print("call to api")
        viewModelScope.launch {
            var todos = networkRepository.getTodosFormAPI();
            todos.forEach {
                insertTodo(it)
            }
        }
    }

    // check already save to local database
    fun checkAlreadySaveToLocalDB() {
        viewModelScope.launch {
            localRepository.getTodoList().collect { todos ->
                if (todos.isEmpty()) {
                   getTodosFromNetwork();
                }
            }
        }
    }

}