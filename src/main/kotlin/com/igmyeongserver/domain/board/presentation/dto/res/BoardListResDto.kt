package com.igmyeongserver.domain.board.presentation.dto.res

import java.time.LocalDateTime

data class BoardListResDto(
    val id: Long,
    val title: String,
    val content: String,
    val ip: String,
    val createdAt: LocalDateTime
)
