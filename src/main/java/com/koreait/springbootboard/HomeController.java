package com.koreait.springbootboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired private HomeService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
