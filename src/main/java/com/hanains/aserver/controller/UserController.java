package com.hanains.aserver.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.xalan.lib.ExsltBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanains.aserver.domain.User;
import com.hanains.aserver.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping("user/list")
	public List<User> list() throws Exception{
		
		System.out.println("----------------------------------------------------------user/list----------------------------------------------------------");
		
		List<User> user = userService.List();
		
		System.out.println(user);
		
		return user;
	}
	
	@RequestMapping("user/selectPoint")
	public User selectPoint(@ModelAttribute User user) throws Exception{
		
		System.out.println("----------------------------------------------------------user/selectPoint----------------------------------------------------------");
		
		user.setNo(1);//test용
		User pointUser = userService.selectPoint(user);
		return pointUser;
	}
	
	@RequestMapping("user/login")
	public User login(@ModelAttribute User user)throws Exception{
		
		System.out.println("----------------------------------------------------------user/login----------------------------------------------------------");
		
		User authUser = userService.login(user);
		
		return authUser;
	}
	
	//user의 아이디를 통해 
	@ResponseBody
	@RequestMapping(value="user/selectPointForUser/{email}")
	public int selectPointForUser(@PathVariable("email") String email) throws Exception{
			
		User user =new User();
		
		user.setEmail(email);
		
		System.out.println("----------------------------------------------------------selectPointForUser()----------------------------------------------------------");

		Map<String,Object> map = new ConcurrentHashMap<>();
		map.put("user", user);
		
		int point = userService.selectPointForUser(map);
		
		return point;
	}
	
}