package com.igmyeongserver.domain.board.service

import com.igmyeongserver.domain.board.domain.Board
import com.igmyeongserver.domain.board.domain.BoardRepo
import com.igmyeongserver.domain.board.presentation.dto.req.CreateBoardReqDto
import com.igmyeongserver.domain.board.presentation.dto.res.BoardListResDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(
    private val boardRepo: BoardRepo
) {
    @Transactional(readOnly = true)
    fun getBoardList(): List<BoardListResDto> =
        boardRepo.findAllByOrderByCreatedAtDesc().map {
            BoardListResDto(
                id = requireNotNull(it.id),
                title = it.title,
                content = it.content,
                ip = it.ip.split(".").take(2).joinToString("."),
                createdAt = it.createdAt
            )
        }

    @Transactional
    fun createBoard(dto: CreateBoardReqDto, ip: String) {
        boardRepo.save(Board(
            title=dto.title,
            content=dto.content,
            ip=ip
        ))
    }
}