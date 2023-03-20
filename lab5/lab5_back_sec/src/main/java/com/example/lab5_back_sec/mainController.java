package com.example.lab5_back_sec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
     @GetMapping("")
    public String showHomepage(){
         return "index";
     }
}
