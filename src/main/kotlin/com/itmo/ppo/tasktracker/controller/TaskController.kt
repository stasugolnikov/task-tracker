package com.itmo.ppo.tasktracker.controller

import com.itmo.ppo.tasktracker.model.Task
import com.itmo.ppo.tasktracker.service.TaskService
import org.springframework.web.bind.annotation.*
import java.util.UUID


@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(
    val taskService: TaskService
) {
    @GetMapping
    fun getTasks(@RequestParam(value = "limit", defaultValue = "100") limit: Int): List<Task> =
        taskService.getTasks(limit)

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: UUID): Task? = taskService.getTask(id)

    @PostMapping
    fun createTasks(@RequestBody task: Task): Task = taskService.createTask(task)

    @PutMapping
    fun updateTask(@RequestBody task: Task): Task? = taskService.updateTask(task)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: UUID) = taskService.deleteTask(id)
}