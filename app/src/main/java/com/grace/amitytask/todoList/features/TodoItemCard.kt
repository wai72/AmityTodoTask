package com.grace.amitytask.todoList.features

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.grace.amitytask.todoList.domain.model.Todo

@Composable
fun TodoItemCard(todo: Todo) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(Modifier.fillMaxWidth(0.8f).padding(8.dp)){
                Text(text = todo.taskTitle, overflow = TextOverflow.Ellipsis, maxLines = 1)
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = todo.isCompleted.toString())
            }

        }

    }

}


