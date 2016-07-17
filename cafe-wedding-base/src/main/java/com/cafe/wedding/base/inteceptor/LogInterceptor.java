package com.cafe.wedding.base.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 系统日志拦截器
 * @author leishaobo
 * @email  leishaobo_cafe@163.com
 * @createime 2016年7月16日
 */
public class LogInterceptor extends HandlerInterceptorAdapter{
	
	ThreadLocal<Long> timer=new ThreadLocal<Long>();
	
	Logger logger=LoggerFactory.getLogger(LogInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		timer.set(System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String servletPath=request.getServletPath();
		String queryString=request.getQueryString();
		Long before=timer.get();
		Long now =System.currentTimeMillis();
		logger.info("本次请求:{}{} 使用了：{}毫秒",servletPath,queryString,(now-before));
		timer.remove();
		super.afterCompletion(request, response, handler, ex);
	}
	
}

