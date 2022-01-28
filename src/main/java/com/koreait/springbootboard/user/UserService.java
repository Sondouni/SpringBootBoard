package com.koreait.springbootboard.user;

import com.koreait.springbootboard.MyUserUtils;
import com.koreait.springbootboard.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private MyUserUtils userUtils;

    public int join(UserEntity entity){

        entity.setUpw(BCrypt.hashpw(entity.getUpw(),BCrypt.gensalt()));

        try {
            return mapper.insUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //sel user pk/uid
    public int selUser(UserEntity entity){
        UserEntity resultEntity = null;
        try {
            resultEntity = mapper.selUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        if(resultEntity==null){
            return 2;
        }
        if(BCrypt.checkpw(entity.getUpw(),resultEntity.getUpw())){
            resultEntity.setUpw(null);
            userUtils.setLoginUser(resultEntity);
            return 1;
        }else {
            return 3;
        }
    }
}
