package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

			ApplicationContext context = new ClassPathXmlApplicationContext("part01/tx.xml");
			Service svc=(Service)context.getBean("svc");
			svc.insertProcess();
		
		
		
	}//end main()

}//end class
