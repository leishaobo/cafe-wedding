package com.cafe.wedding.web.sys.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sys/login")
@Controller
public class LoginLogoutController {
	
	@RequestMapping("/login.html")
	public String login_ui(){
		return "login";
	}
	
	@RequestMapping("/index.html")
	public String index_ui(){
		return "index";
	}
}
