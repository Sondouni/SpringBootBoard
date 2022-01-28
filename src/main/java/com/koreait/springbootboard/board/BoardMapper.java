package com.koreait.springbootboard.board;

import com.koreait.springbootboard.board.model.BoardDTO;
import com.koreait.springbootboard.board.model.BoardEntity;
import com.koreait.springbootboard.board.model.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //icategory별 리스트 가져오기
    List<BoardVO> selBoardList(BoardDTO dto);
    //iboard별 board 가져오기
    BoardVO selBoard(BoardDTO dto);
}
