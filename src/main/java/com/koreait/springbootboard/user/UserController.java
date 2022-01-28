package com.koreait.springbootboard.user;

import com.koreait.springbootboard.MyUserUtils;
import com.koreait.springbootboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private MyUserUtils userUtils;

    @GetMapping("/login")
    public void login(@ModelAttribute("entity") UserEntity entity){

    }

    @PostMapping("/login")
    public String loginProc(UserEntity entity){
        int result = service.selUser(entity);
        System.out.println(result);
        return "redirect:/";
    }

    @GetMapping("/join")
    public void join(@ModelAttribute("entity") UserEntity entity){

    }

    @PostMapping("/join")
    public String joinProc(UserEntity entity){
        System.out.println(entity);
        int result = service.join(entity);
        System.out.println(result);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logOut(){
        userUtils.makeLogout();
        return "redirect:/";
    }

}
