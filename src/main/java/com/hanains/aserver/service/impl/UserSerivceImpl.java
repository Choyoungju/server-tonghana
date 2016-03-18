package com.hanains.aserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.aserver.domain.User;
import com.hanains.aserver.repository.UserDao;
import com.hanains.aserver.service.UserService;

import java.util.*;

@Service
public class UserSerivceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserSerivceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public List<User> List() throws Exception{
		
		List<User> user = userDao.list();
		
		return user;
	}

	@Override
	public User selectPoint(User user) throws Exception {
		
		User pointUser = userDao.selectPoint(user);
		
		return pointUser;
	}

	@Override
	public User login(User user) throws Exception {
		
		User authUser = userDao.login(user);
		
		return authUser;
	}

	@Override
	public User selectFindUser(User user) throws Exception {
		
		User findUser = userDao.selectFindUser(user);
		
		return findUser;
	}

	@Override
	public int selectPointForUser(Map<String, Object> map) throws Exception {
		int point = userDao.selectPointForUser(map);
		
		return point;
	}

	
}
