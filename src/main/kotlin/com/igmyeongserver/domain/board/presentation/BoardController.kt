package com.igmyeongserver.domain.board.presentation

import com.igmyeongserver.domain.board.presentation.dto.res.BoardListResDto
import com.igmyeongserver.domain.board.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/board")
class BoardController(private val boardService: BoardService) {
    @GetMapping()
    fun getBoardList(): ResponseEntity<List<BoardListResDto>> {
        return ResponseEntity.ok(boardService.getBoardList())
    }
}