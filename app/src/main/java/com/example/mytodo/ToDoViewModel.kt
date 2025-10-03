package com.example.mytodo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {
    var state by mutableStateOf(ToDoState())
        private set

    fun onAction(action: ToDoAction) {
        when (action) {
            is ToDoAction.SetText -> {
                state = state.copy(textInput = action.text)
            }

            is ToDoAction.AddToDo -> {

                //if not text is entered and add button is clicked
                if (state.textInput.isBlank()) {
                    return
                }

                //text contains something
                val uid: Long = System.currentTimeMillis()

                val newItem = item_todo(
                    uid,
                    state.textInput,
                )

                //update the list and clear the input text field
                state = state.copy(
                    items = state.items + newItem,
                    textInput = ""
                )

            }

            is ToDoAction.MarkDone -> {
                state = state.copy(
                    items = state.items.map { item ->
                        if (item.uid == action.id) {
                            //toggle
                            item.copy(isDone = !item.isDone)
                        } else {
                            //keep item as it is
                            item
                        }
                    }
                )
            }

            is ToDoAction.DeleteToDO -> {
                state = state.copy(
                    //filter out items that does not ma
                    items = state.items.filter { item ->
                        item.uid != action.id
                    }
                )
            }
        }

    }
}