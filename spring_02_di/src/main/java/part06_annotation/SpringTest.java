package part06_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
			//Service svc = (Service)context.getBean("svc");

			//Bean이름 지정 가능-> config.java 
			Service svc = (Service)context.getBean("ss");
			
			svc.prn();
		
	}//end main()

}//end class
