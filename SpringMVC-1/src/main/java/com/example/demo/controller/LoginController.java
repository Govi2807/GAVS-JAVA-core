package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@Controller
public class LoginController {
	@GetMapping("/login")
	public String sayHello() {
		return "login";
	}
	@PostMapping("/login")
    @ResponseBody
	public String welcomeAll() {
		return "Users are Validated Welcome!!";
	}
}