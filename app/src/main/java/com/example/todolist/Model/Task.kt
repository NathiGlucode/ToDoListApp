package com.example.todolist.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String, //title
    val title: String, //changes from categories
    val deadline: Long,
    val priority: String,
    val isCompleted: Boolean = false
)
