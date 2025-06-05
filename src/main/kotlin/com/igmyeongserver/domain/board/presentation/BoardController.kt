package com.igmyeongserver.domain.board.presentation

import com.igmyeongserver.domain.board.presentation.dto.req.CreateBoardReqDto
import com.igmyeongserver.domain.board.presentation.dto.res.BoardListResDto
import com.igmyeongserver.domain.board.service.BoardService
import io.swagger.v3.oas.annotations.Operation
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/board")
class BoardController(private val boardService: BoardService) {

    @GetMapping
    @Operation(summary = "Get all boards")
    fun getBoardList(): ResponseEntity<List<BoardListResDto>> {
        return ResponseEntity.ok(boardService.getBoardList())
    }

    @PostMapping
    @Operation(summary = "Create a new board")
    fun createBoard(
        @RequestBody dto: CreateBoardReqDto,
        request: HttpServletRequest,
    ): ResponseEntity<Void> {
        val ip: String = request.getHeader("X-Forwarded-For") ?: request.remoteAddr
        boardService.createBoard(dto, ip)
        return ResponseEntity.created(URI.create("/board")).build()
    }
}