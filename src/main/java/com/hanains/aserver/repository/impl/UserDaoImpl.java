package com.hanains.aserver.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.aserver.domain.User;
import com.hanains.aserver.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession sqlSession;
	
	public UserDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public List<User> list() throws Exception {
		
		List<User>user = sqlSession.selectList("user.selectAll");
		
		return user;
	}

	@Override
	public User selectPoint(User user) throws Exception {
		
		User pointUser = sqlSession.selectOne("user.selectPoint", user);
		
		return pointUser;
	}

	@Override
	public User login(User user) throws Exception {
		
		User authUser = sqlSession.selectOne("user.selectUser", user);
		
		return authUser;
	}

	@Override
	public User selectFindUser(User user) throws Exception {
		
		User findUser = sqlSession.selectOne("user.selectFindUser", user);
		
		return findUser;
	}

	@Override
	public int selectPointForUser(Map<String, Object> map) {
		int point = sqlSession.selectOne("user.selectPointForUser", map);
		
		return point;
	}

	
	
	
	
}
