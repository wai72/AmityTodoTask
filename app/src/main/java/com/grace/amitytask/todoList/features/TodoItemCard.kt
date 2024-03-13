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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.grace.amitytask.todoList.R
import com.grace.amitytask.todoList.domain.model.Todo
import com.grace.amitytask.todoList.others.Constants

@Composable
fun TodoItemCard(todo: Todo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Constants.NORMAL_MARGIN, vertical = Constants.NORMAL_MARGIN)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier
                    .fillMaxWidth(0.8f)
                    .padding(
                        horizontal = Constants.LargeX_MARGIN,
                        vertical = Constants.NORMAL_MARGIN
                    )){
                Text(text = todo.taskTitle, overflow = TextOverflow.Ellipsis, maxLines = 1, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(Constants.Large_MARGIN))
                Row (){
                    Text(text = "Complete Status :")
                    Spacer(modifier = Modifier.width(Constants.NORMAL_MARGIN))
                    Text(text = todo.isCompleted.toString(), color = colorResource(id = R.color.purple_500))
                }
            }

        }

    }

}


