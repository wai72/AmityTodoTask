package com.grace.amitytask.todoList.features

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.grace.amitytask.todoList.domain.model.Todo
import com.grace.amitytask.todoList.presentation.MainViewModal
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(mainViewModal: MainViewModal = hiltViewModel()) {
    val todos: List<Todo> by mainViewModal.todoList.collectAsStateWithLifecycle(initialValue = emptyList())

    Scaffold {
        paddingValues ->  LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues),
        contentPadding = PaddingValues(8.dp)){
    }
        // Todo Api return empty
        if(todos.isEmpty()){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        // Todo list from Room Database
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Todo List",
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(12.dp)
            )
            LazyColumn(Modifier.fillMaxSize()) {
                items(todos.size) {
                    TodoItemCard(todo = todos[it])
                }
            }

        }


    }
}