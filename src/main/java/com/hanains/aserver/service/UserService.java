package com.hanains.aserver.service;

import java.util.List;
import java.util.Map;

import com.hanains.aserver.domain.User;


public interface UserService {
	
	public List<User> List() throws Exception;

	public User selectPoint(User user) throws Exception;

	public User login(User user) throws Exception;

	public User selectFindUser(User user) throws Exception;

	//
	public int selectPointForUser(Map<String, Object> map) throws Exception;

}
