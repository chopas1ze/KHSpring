package part03_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("part03_property/di.xml");
		Service svc = (Service)context.getBean("svc1");
		//svc.prn1();
		svc = (Service)context.getBean("svc2");
		//svc.prn2();
		svc = (Service)context.getBean("svc3");
		//svc.prn1();
		svc = (Service)context.getBean("svc4");
		svc.prn2();
		
		
	}//end main()

}//end class
