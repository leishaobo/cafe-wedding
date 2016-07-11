package com.cafe.wedding.web.sys.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.wedding.base.sys.domain.SysUser;
import com.cafe.wedding.base.sys.service.SysUserService;

@RequestMapping("/sys/user")
@Controller
public class UserController {

	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/list.html")
	public String login_ui(){
		return "sys/user/list";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll(@PageableDefault(size=20,page=0) Pageable pageable){
		return sysUserService.findAll(pageable);
	}
	
	@RequestMapping("/testJson")
	@ResponseBody
	public Object testJson(@PageableDefault(size=20,page=0) Pageable pageable,String realname){
		return sysUserService.findByRealname(pageable, realname);
	}
}
