package com.example.myapplication_todo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_todo_app.ui.theme.MyApplication_todo_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication_todo_appTheme {

                navgetorrPages()
                }
            }
        }
    }


@Composable
fun navgetorrPages() {
    val navController = rememberNavController()
    val myList = remember { mutableStateListOf<ToDoTask>() }

    NavHost(
        navController = navController, startDestination = "Todo_my",
        builder = {
            composable("Todo_my") {
                Todo_my(
                    navController = navController,
                    onSave = { item, selectedColor ->
                        myList.add(ToDoTask(item, mutableStateOf(false),selectedColor))
                        navController.navigate("disply_myapp")
                    }
                )
            }
            composable("disply_myapp") {
                disply_myapp(navController = navController, myList = myList.toList(),onDelete = { task ->
                    myList.remove(task)
                })
            }
        }
    )
}

