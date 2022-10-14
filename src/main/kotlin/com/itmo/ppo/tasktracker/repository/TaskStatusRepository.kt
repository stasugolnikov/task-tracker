package com.itmo.ppo.tasktracker.repository

import com.itmo.ppo.tasktracker.entity.TaskStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskStatusRepository : JpaRepository<TaskStatus, UUID> {
    fun findByName(name: String): Optional<TaskStatus>
}