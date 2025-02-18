package vttp5.batcha.shamus.final_mini_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloResource {
    
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
    
}
