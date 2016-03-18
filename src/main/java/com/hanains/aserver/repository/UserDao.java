package com.hanains.aserver.repository;

import com.hanains.aserver.domain.User;

import java.util.*;

public interface UserDao {

	public List<User> list() throws Exception;

	public User selectPoint(User user) throws Exception;

	public User login(User user)throws Exception;

	public User selectFindUser(User user)throws Exception;

	public int selectPointForUser(Map<String, Object> map);

}
