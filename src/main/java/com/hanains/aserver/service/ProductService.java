package com.hanains.aserver.service;

import com.hanains.aserver.domain.Product;
import com.hanains.aserver.domain.User;

import java.util.*;

public interface ProductService {
	
	public void addPoint(Map<String, Object> map) throws Exception;

	public Product selectProductPoint(Product product) throws Exception;

	public List<Product> List() throws Exception;

	public int getTotalCnt() throws Exception;
	
}
