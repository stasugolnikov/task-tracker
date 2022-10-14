package com.itmo.ppo.tasktracker.model

import java.util.*

data class Task(
    val id: UUID?,
    val name: String,
    val description: String?,
    val status: String,
)