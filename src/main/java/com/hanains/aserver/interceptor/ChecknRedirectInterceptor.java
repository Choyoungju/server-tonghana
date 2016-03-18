package com.hanains.aserver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ChecknRedirectInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		Device device = DeviceUtils.getCurrentDevice(RequestContextHolder.currentRequestAttributes()); 
		
		System.out.println(this.getClass()+"preHandle() called..");
		
		if (device.isMobile()) {
			System.out.println("모바일?접근" + device);
		} else if (device.isTablet()){
			System.out.println("테브릸?접근" + device);
		} else if (device.isNormal()){
			System.out.println("웹?접근" + device);
		} else {
			System.out.println("비정상접근");
		}
		
		return false;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


}
