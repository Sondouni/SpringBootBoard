package com.koreait.springbootboard.user;

import com.koreait.springbootboard.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //select * pk,uid로 분기
    UserEntity selUser(UserEntity entity);
    //회원가입
    int insUser(UserEntity entity);
}
