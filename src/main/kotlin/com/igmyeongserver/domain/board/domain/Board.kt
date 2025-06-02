package com.igmyeongserver.domain.board.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @Column(nullable = false, )
    val ip: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)