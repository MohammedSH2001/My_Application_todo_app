package com.example.myapplication_todo_app

import androidx.compose.animation.AnimatedVisibility

import android.annotation.SuppressLint
import android.provider.CalendarContract
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable


fun Todo_my(navController: NavController, onSave: (String, Color) -> Unit) {
    val entertodo = remember { mutableStateOf("") }
    val selectedColor = remember { mutableStateOf(Color.Yellow) }
    var changeIcon: Boolean = false

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primaryContainer
                ),
                title = {
                    Text(
                        text = "Todo List",
                        color = Color.Black,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 27.sp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("") }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.padding(50.dp))

        OutlinedTextField(
            value = entertodo.value,
            onValueChange = { entertodo.value = it },
            label = { Text(text = "Enter todo ", color = Color.Gray) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(0.dp)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Black,
            ),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            Button(
                onClick = {
                    selectedColor.value = Color.Red
                    changeIcon = !changeIcon
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedColor.value == Color.Red) Color.DarkGray else Color.Red
                )
            ) {
                Text(text = "")
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {
                    selectedColor.value = Color.Blue
                },
                colors = ButtonDefaults.buttonColors(containerColor = if (selectedColor.value == Color.Blue) Color.DarkGray else Color.Blue)
            ) {
                Text(text = "")
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {
                    selectedColor.value = Color.Yellow
                },
                colors = ButtonDefaults.buttonColors(containerColor = if (selectedColor.value == Color.Yellow) Color.DarkGray else Color.Yellow)

            ) {
                Text(text = "")
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(onClick = {
                if (entertodo.value.isNotBlank()) {
                    onSave(entertodo.value, selectedColor.value)
                    entertodo.value = ""
                }
            }) {
                Text(text = "Add")
            }
        }
    }
}



