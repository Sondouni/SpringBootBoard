package com.koreait.springbootboard.board;

import com.koreait.springbootboard.Const;
import com.koreait.springbootboard.board.model.BoardEntity;
import com.koreait.springbootboard.board.model.BoardVO;
import com.koreait.springbootboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(){
    }
}
