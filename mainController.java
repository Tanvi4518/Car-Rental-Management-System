package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class mainController {

    @GetMapping("/")
	public String startPage() {
		return "StartPage";
	}

    @GetMapping("/admin")
    public String goAdmin(){
          return "AdminLogin";
    }
    
    @GetMapping("/customer")
    public String goCustomer(){
          return "list-employees";
    }
    
}
