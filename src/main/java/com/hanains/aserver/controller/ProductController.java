package com.hanains.aserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanains.aserver.domain.Product;
import com.hanains.aserver.domain.User;
import com.hanains.aserver.service.ProductService;
import com.hanains.aserver.service.UserService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ProductController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	public ProductController() {
		System.out.println(this.getClass());
	}
	
	@ResponseBody
	@RequestMapping(value="product/list", method=RequestMethod.GET, produces="application/json")
	public List<Product> list(@ModelAttribute Product product) throws Exception{
		
		System.out.println("----------------------------------------------------------product/list----------------------------------------------------------");
		
		List<Product> listProduct = productService.List();
		
		System.out.println(listProduct);
		
		return listProduct;
	}
	
	@ResponseBody
	@RequestMapping("product/selectProductPoint")
	public Product selectProductPoint(@ModelAttribute Product product) throws Exception{
		
		System.out.println("----------------------------------------------------------product/selectProductPoint----------------------------------------------------------");
		
		product.setNo(1);//test
		
		System.out.println(product.getPoint());
		
		Product pointProduct = productService.selectProductPoint(product);
		
		return pointProduct;
	}
	
	@ResponseBody
	@RequestMapping("product/getTotalCnt")
	public int getTotalCnt() throws Exception{
		
		System.out.println("----------------------------------------------------------product/getTotalCnt----------------------------------------------------------");
		
		int cnt = productService.getTotalCnt();
		
		return cnt;
	}
	
	@ResponseBody
	@RequestMapping(value="product/addPoint/{no}/{email}", method=RequestMethod.PUT , produces="application/json")
	public boolean testpoint(						 
							 @PathVariable("no") String no,
							 @PathVariable("email") String email
							) throws Exception{
				
		System.out.println("----------------------------------------------------------product/addpoint----------------------------------------------------------");
		
		User user =new User();
		
		user.setEmail(email);
		
		System.out.println(no + "/" + user);
		
		
		
		Map<String,Object> map = new ConcurrentHashMap<>();
		
		map.put("no", no);
		User findUser = userService.selectFindUser(user);
		
		map.put("member", findUser);
		
		System.out.println("::map::"+map);
		
		productService.addPoint(map);
		
		return true;
	}
	
	
	
//	@ResponseBody
//	@RequestMapping(value="product/addpoint/1/1", method=RequestMethod.GET , produces="application/json")
//	public boolean testpointdd(@ModelAttribute User user,@PathVariable String email,@PathVariable String no
////			@RequestParam(value="no", required=true, defaultValue="1") int no
//			) throws Exception{
//		
//		System.out.println("----------------------------------------------------------product/addpoint----------------------------------------------------------");
//		
//		return true;
//	}
//	
		
}
