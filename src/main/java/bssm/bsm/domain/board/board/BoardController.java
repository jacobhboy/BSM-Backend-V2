package bssm.bsm.domain.board.board;

import bssm.bsm.domain.board.board.dto.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public BoardResponseDto boardInfo(@PathVariable String boardId) {
        return boardService.boardInfo(boardId);
    }
}