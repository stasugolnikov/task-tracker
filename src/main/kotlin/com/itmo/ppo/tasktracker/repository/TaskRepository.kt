package com.itmo.ppo.tasktracker.repository

import com.itmo.ppo.tasktracker.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskRepository : JpaRepository<TaskEntity, UUID>