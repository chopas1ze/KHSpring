package part02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri=request.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1); 
		System.out.println("uri:"+uri);
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("chk")==null){
			response.sendRedirect("index.do?returnUrl="+uri);
			return false;
		}else {
			return super.preHandle(request, response, handler);
		}
		
		
	}//end preHandle()

}//end class
