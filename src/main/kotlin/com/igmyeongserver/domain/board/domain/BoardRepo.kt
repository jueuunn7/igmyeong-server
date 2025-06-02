package com.igmyeongserver.domain.board.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepo : JpaRepository<Board, Long> {
    fun findAllByOrderByCreatedAtDesc(): MutableList<Board>
}