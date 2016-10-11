package part11_listener;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("part11_listener/di.xml");
		Service svc = (Service) context.getBean("svc");
		svc.prn();
		//메모리에서 제거
		context.destroy();
		//연결을 끊어주는것
		//context.close();
	}// end main()

}// end class
