package com.hanains.aserver.aspect;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect
@Component
public class CommonAspectJ {
	
	@Around("execution( * *..repository.*.*(..))||execution(* *..service.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
	
		String task=pjp.getTarget().getClass()+"."+pjp.getSignature().getName();
		
		Device device = DeviceUtils.getCurrentDevice(RequestContextHolder.currentRequestAttributes());

		if(device.isTablet()){
		
			StopWatch stopWatch = new StopWatch();
			
			stopWatch.start(task);
			
			System.out.println("정상 접근");
			
			System.out.println("[Around before]\n[실행되는 메소드]="+task);
			
			if(pjp.getArgs().length !=0){
				System.out.println("[Around before]\n[method에 전달되는 인자]="+ pjp.getArgs()[0]);
			}
			
			Object res = pjp.proceed();//본 메소드 실행
			
			System.out.println("[Around after]\n[결과]="+res);
			
			stopWatch.stop();
			
			
			System.out.println("[Around after]\n[실행시간]"+"["+task+"]="+stopWatch.getTotalTimeMillis()+" millis");
			
			return res;
		
		} else if(device.isMobile()){
			
			return null;
			
		} else if(device.isNormal()){
			
			return null;
		}
		
		return null;
	}
	
}
