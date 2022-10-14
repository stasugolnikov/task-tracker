package com.itmo.ppo.tasktracker.service.mapper

import com.itmo.ppo.tasktracker.entity.TaskEntity
import com.itmo.ppo.tasktracker.entity.TaskStatus
import com.itmo.ppo.tasktracker.model.Task
import com.itmo.ppo.tasktracker.repository.TaskStatusRepository
import org.springframework.stereotype.Component
import javax.persistence.EntityNotFoundException

@Component
class TaskMapper(
    val taskStatusRepository: TaskStatusRepository
) {
    fun modelToEntity(model: Task): TaskEntity {
        val taskStatus: TaskStatus = taskStatusRepository.findByName(model.status)
            .orElseThrow {
                EntityNotFoundException("Status with name ${model.status} not found")
            }
        val entity = TaskEntity()
        entity.id = model.id
        entity.name = model.name
        entity.description = model.description
        entity.taskStatus = taskStatus
        return entity
    }

    fun entityToModel(entity: TaskEntity): Task {
        return Task(
            entity.id,
            entity.name!!,
            entity.description,
            entity.taskStatus?.name!!
        )
    }
}