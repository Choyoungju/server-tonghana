package com.hanains.aserver.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.aserver.domain.Product;
import com.hanains.aserver.domain.User;
import com.hanains.aserver.repository.ProductDao;

import java.util.*;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SqlSession sqlSession;
	
	public ProductDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public Product selectProductPoint(Product product) throws Exception {

		Product pointProduct = sqlSession.selectOne("product.selectProductPoint", product);
		return pointProduct;
	}

	@Override
	public List<Product> list() throws Exception {
		
		List<Product> product = sqlSession.selectList("product.selectAll");
		
		return product;
	}

	@Override
	public int getTotalCnt() throws Exception {
		
		int cnt = sqlSession.selectOne("product.getTotalCnt");
		
		return cnt;
	}

	@Override
	public void addPoint(Map<String, Object> map) throws Exception {
		sqlSession.update("product.addPoint", map);
	}
	
	
	
}
