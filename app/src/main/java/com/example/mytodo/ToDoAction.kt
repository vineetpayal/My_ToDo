package com.example.mytodo

sealed class ToDoAction() {
    object AddToDo : ToDoAction()
    data class DeleteToDO(val id: Long) : ToDoAction()
    data class MarkDone(val id: Long) : ToDoAction()
    data class SetText(val text: String) : ToDoAction()
}