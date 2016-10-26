package prob02;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringTest {  
	

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("prob02/di.xml");
		Service svc=(Service)context.getBean("svc");
		svc.prn();
		/*
		 * 출력결과
		 *  레코드 삽입
		 */
	}

}
