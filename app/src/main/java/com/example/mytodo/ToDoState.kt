package com.example.mytodo

data class ToDoState(
    val items: List<item_todo> = emptyList(),
    val textInput: String = ""
)