package com.example.mytodo

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ToDoScreen(
    state: ToDoState, onAction: (ToDoAction) -> Unit, modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .height(56.dp),
            ) {
                //text field for new toDos
                OutlinedTextField(
                    value = state.textInput,
                    onValueChange = { text ->
                        onAction(ToDoAction.SetText(text))
                    },
                    modifier = Modifier
                        .weight(.2f)
                )

                //Add Button
                Button(
                    onClick = {
                        onAction(ToDoAction.AddToDo)
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Button"
                    )
                }
            }

            //List of todos
            LazyColumn(
            ) {
                items(state.items) { item ->
                    Text(
                        text = item.content,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    )

                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoScreenPreview() {
    // 1. Create a dummy state to provide data for the preview
    val sampleState = ToDoState(
        items = listOf(
            item_todo(uid = 1, content = "Buy groceries", isDone = false),
            item_todo(uid = 2, content = "Finish project report", isDone = true)
        ), textInput = "New task name"
    )

    // 2. Call your actual Composable with the dummy state
    ToDoScreen(state = sampleState, {}
        // Note: We'll add the onAction callback soon!
    )
}