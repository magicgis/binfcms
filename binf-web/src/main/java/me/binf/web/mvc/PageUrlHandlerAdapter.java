package me.binf.web.mvc;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUrlHandlerAdapter implements HandlerAdapter {


	
	@Override
	public boolean supports(Object handler) {
		return true;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request,
			                   HttpServletResponse response,
                               Object handler) throws Exception {
		UrlPathHelper helper = new UrlPathHelper();
		String uri = helper.getOriginatingRequestUri(request);
		String ctx = helper.getOriginatingContextPath(request);
		
		if (!StringUtils.isBlank(ctx)) {
			uri=uri.substring(ctx.length());
		}
		uri=uri.substring(1);

		return null;
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return 0;
	}

}
