package com.grace.amitytask.todoList.features

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.grace.amitytask.todoList.domain.model.Todo
import com.grace.amitytask.todoList.presentation.MainViewModal
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(mainViewModal: MainViewModal) {
    val todos: List<Todo> by mainViewModal.getTodoList.collectAsStateWithLifecycle(initialValue = emptyList())
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold (){
            paddingValues ->  LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues),
        contentPadding = PaddingValues(8.dp)){

    }

    }
}