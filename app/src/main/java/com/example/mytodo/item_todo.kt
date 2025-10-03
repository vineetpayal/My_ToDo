package com.example.mytodo

data class item_todo(
    val uid: Long,
    var content: String,
    var isDone: Boolean = false
)
