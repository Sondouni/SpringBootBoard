package com.koreait.springbootboard.board;

import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax/board")
public class BoardRestController {
    @Autowired
    private BoardService service;

    @GetMapping("/{icategory}")
    private List<BoardVO> getList(@PathVariable int icategory, BoardDTO dto){
        dto.setIcategory(icategory);
        return service.selBoardList(dto);
    }
}
