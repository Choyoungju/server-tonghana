package com.hanains.aserver.controller;


import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class TestController {

	public TestController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping("test/index")
	public String index(Device device){
		
		System.out.println("test/index");
		
		if (device.isMobile()) {
			System.out.println("모바일?접근" + device); //모바일 웹브라우저 접근
		} else if (device.isTablet()){
			System.out.println("테브릸?접근" + device); //디바이스 어플내 비동기 통신 접근
		} else if (device.isNormal()){
			System.out.println("웹?접근" + device); // desktop 웹브라우저 접근
		} else {
			System.out.println("비정상접근");
		}
	
		return "test";
	}

}
