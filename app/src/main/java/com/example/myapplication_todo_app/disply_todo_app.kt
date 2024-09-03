package com.example.myapplication_todo_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun disply_myapp(
    navController: NavController,
    myList: List<ToDoTask>,
    onDelete: (ToDoTask) -> Unit
) {
    val totalTasks = myList.size
    val completedTasks = myList.count { it.isDone.value }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(40.dp)) {
            Text(
                text = "Total Tasks: $totalTasks / Completed: $completedTasks",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopCenter),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                contentPadding = PaddingValues(horizontal = 30.dp, vertical = 80.dp),
            ) {
                items(myList) { item ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            onDelete(item)
                        }) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "Delete Item",
                                tint = Color.Red
                            )
                        }

                        Checkbox(
                            checked = item.isDone.value,
                            onCheckedChange = { item.isDone.value = it }
                        )

                        Text(
                            text = item.name,
                            color = item.color,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = { navController.navigate("Todo_my") },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    }
}
