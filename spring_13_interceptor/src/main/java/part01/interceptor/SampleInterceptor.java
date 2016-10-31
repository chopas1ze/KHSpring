package part01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * preHandle - 컨트롤러에 들어가기전 접근
 * postHandle - 컨트롤러 접근 후 view 페이지 접근전
 * afterCompletion - 컨트롤러와 view 페이지 모두 접근 후 
 */

import aj.org.objectweb.asm.Handle;


public class SampleInterceptor extends HandlerInterceptorAdapter{
	//인터셉터에서 제외시켜줄 컨트롤러를 등록한다.
	static final String[] EXCLUDE_URL_LIST={"/write.do"};
	/*static final String[] EXCLUDE_URL_LIST={"/write.do","배열가능 "};*/
	
	
	public SampleInterceptor() {
		
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
		
		//스프링 3.2버전 이하에서 제외 처리하는방법
		String reqUrl=request.getRequestURI().toString();
		for(String target : EXCLUDE_URL_LIST){
			if(reqUrl.indexOf(target)>-1){
				return true;
			}
		}
		
		
		System.out.println("pre handle...");
		return true;   //호출했던 컨트롤러로 이동하는 리턴    반대는 false    
	}//end preHandle()
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			System.out.println("post handle...");
	}//end postHandle()

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
			System.out.println("afterCompletion Handle...");
	}//end afterCompletion()
	
}//end class
