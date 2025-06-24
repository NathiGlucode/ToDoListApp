package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.Model.TaskDatabase
import com.example.todolist.Model.TaskRepository
import com.example.todolist.ViewModel.TaskViewModel
import com.example.todolist.ViewModel.TaskViewModelFactory
import com.example.todolist.ui.HomeScreenView
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.ui.weatherAPI



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = TaskDatabase.getDatabase(applicationContext)
        val repository = TaskRepository(db.taskDao())
        val factory = TaskViewModelFactory(repository)
        val taskViewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        setContent {
            ToDoListTheme {
                val taskState = taskViewModel.tasks.collectAsState()

                HomeScreenView(
                    tasks = taskState.value,
                    weather = weatherAPI("Sandton", "6:23", "17:30", "34°C"),
                    onAddTask = { },
                    viewModel = taskViewModel
                )
            }

        }
    }
}