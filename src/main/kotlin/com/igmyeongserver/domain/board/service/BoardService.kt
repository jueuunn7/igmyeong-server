package com.igmyeongserver.domain.board.service

import com.igmyeongserver.domain.board.domain.BoardRepo
import com.igmyeongserver.domain.board.presentation.dto.res.BoardListResDto
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepo
) {

    fun getBoardList(): List<BoardListResDto> {
        return boardRepository.findAllByOrderByCreatedAtDesc().map {
            BoardListResDto(
                id = requireNotNull(it.id),
                title = it.title,
                content = it.content,
                ip = it.ip,
                createdAt = it.createdAt
            )
        }
    }
}

// 원래 맵도 바로 쓸 수 있는데 ㄱㄷㄱㄷ
// 쌤이 불러서 ㄱㄷㄱㄷ
