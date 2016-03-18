package com.hanains.aserver.repository;

import com.hanains.aserver.domain.Product;

import java.util.*;
public interface ProductDao {

	//point 적립
	public void addPoint(Map<String, Object> map) throws Exception;

	//product point 가져오기
	public Product selectProductPoint(Product product) throws Exception;

	//product 뿌리기
	public List<Product> list() throws Exception;

	//product table total 수 가져오기
	public int getTotalCnt() throws Exception;
	
}
