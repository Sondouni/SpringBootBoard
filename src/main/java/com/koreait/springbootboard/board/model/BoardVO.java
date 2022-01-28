package com.koreait.springbootboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO extends BoardEntity {
    private String writernm;
    private String catenm;
    private String profileimg;
}
