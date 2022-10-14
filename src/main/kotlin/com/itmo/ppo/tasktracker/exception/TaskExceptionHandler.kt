package com.itmo.ppo.tasktracker.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class TaskExceptionHandler {
    @ExceptionHandler(EntityNotFoundException::class, IllegalArgumentException::class)
    fun handle(e: Exception) = ResponseEntity.badRequest().body<Error>(Error(e.message))

    data class Error(
        val error: String?
    )
}
