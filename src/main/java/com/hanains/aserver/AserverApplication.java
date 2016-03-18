package com.hanains.aserver;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.switcher.SiteSwitcherHandlerInterceptor;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hanains.aserver.aspect.CommonAspectJ;
import com.hanains.aserver.interceptor.ChecknRedirectInterceptor;

@SpringBootApplication
@EnableWebMvc
@EnableConfigurationProperties(MyBatisProperties.class)
public class AserverApplication extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(AserverApplication.class, args);
	}
	
	@Bean
    public Filter applicationContextIdFilter(ApplicationContext context) {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return filter;
    }
	
    //<mvc:default-servlet-handler />
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //configurer.enable();
    }
    
    //<mvc:resources mapping="/profile-images/**" location="file:/temp/" />\
    //<mvc:resources mapping="/profile-images/**" location="file:/Users/kimmin-young/temp/" />
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/profile-images/**")
        		.addResourceLocations("file:/temp/");
    }
    
    
    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

//    @Bean
//    public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
//        return SiteSwitcherHandlerInterceptor.urlPath(" www.hanafn.com/");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(deviceResolverHandlerInterceptor());
//        registry.addInterceptor(siteSwitcherHandlerInterceptor());
        
    }
    
//    @Bean
//    public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
//        InternalResourceViewResolver delegate = new InternalResourceViewResolver();
//        delegate.setPrefix("/WEB-INF/views/");
//        delegate.setSuffix(".jsp");
//        LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
//        resolver.setMobilePrefix("mobile/");
//        resolver.setTabletPrefix("tablet/");
//        return resolver;
//    }
    
}
