package me.binf.admin.ckfinder;

import com.ckfinder.connector.configuration.DefaultPathBuilder;
import me.binf.admin.core.Configue;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class CustomPathBuilder extends DefaultPathBuilder {

	@Override
	public String getBaseDir(final HttpServletRequest request) {
		String dir=request.getParameter("dir");
		if(StringUtils.isNotBlank(dir)){
			return Configue.getUploadPath()+dir+"/";
		}else{
			return Configue.getUploadPath();
		}
	}
	
	@Override
	public String getBaseUrl(final HttpServletRequest request){
		String dir=request.getParameter("dir");
		if(StringUtils.isNotBlank(dir)){
			return Configue.getUploadUrl()+dir+"/";
		}else{
			return Configue.getUploadUrl();
		}
	}
}
