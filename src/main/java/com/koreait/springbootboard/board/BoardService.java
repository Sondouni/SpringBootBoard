package com.koreait.springbootboard.board;

import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardEntity;
import com.koreait.springbootboard.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    //icategory별 리스트
    List<BoardVO> selBoardList(BoardDTO dto){
        return mapper.selBoardList(dto);
    }
}
