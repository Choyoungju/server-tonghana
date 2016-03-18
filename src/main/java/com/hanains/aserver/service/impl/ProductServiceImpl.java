package com.hanains.aserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

import com.hanains.aserver.domain.Product;
import com.hanains.aserver.domain.User;
import com.hanains.aserver.repository.ProductDao;
import com.hanains.aserver.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public List<Product> List() throws Exception {
		
		List<Product> product = productDao.list();
		
		return product;
	}

	@Override
	public Product selectProductPoint(Product product) throws Exception {
		
		Product productPoint = productDao.selectProductPoint(product);
		
		return productPoint;
	}

	@Override
	public int getTotalCnt() throws Exception {
		
		int cnt = productDao.getTotalCnt();
		
		return cnt;
	}

	@Override
	public void addPoint(Map<String, Object> map) throws Exception {
		productDao.addPoint(map);
	}


	
}
