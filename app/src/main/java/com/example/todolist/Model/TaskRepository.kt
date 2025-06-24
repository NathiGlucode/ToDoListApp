package com.example.todolist.Model

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: Flow<List<TaskEntity>> = taskDao.getAllTasks()
    val titleSummaries = taskDao.getTitleSummaries()
    val allTitles = taskDao.getAllTitles()


    suspend fun insert(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    suspend fun update(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    suspend fun delete(task: TaskEntity) {
        taskDao.deleteTask(task)
    }

    fun getTasksByPriority(priority: String): Flow<List<TaskEntity>> =
        taskDao.getTasksByPriority(priority)

    fun getCompletedTasks(): Flow<List<TaskEntity>> =
        taskDao.getCompletedTasks()

    fun getIncompleteTasks(): Flow<List<TaskEntity>> =
        taskDao.getIncompleteTasks()

}
