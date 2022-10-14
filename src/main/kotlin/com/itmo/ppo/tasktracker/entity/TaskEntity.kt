package com.itmo.ppo.tasktracker.entity

import com.itmo.ppo.tasktracker.entity.TaskStatus
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "task")
class TaskEntity {
    @Id
    @GeneratedValue
    var id: UUID? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @ManyToOne
    @JoinColumn(name = "status_id")
    var taskStatus: TaskStatus? = null
}