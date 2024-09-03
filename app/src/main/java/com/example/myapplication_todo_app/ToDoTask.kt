package com.example.myapplication_todo_app

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

data class ToDoTask(
    val name: String,
    val isDone: MutableState<Boolean>,
    val color: Color
)
