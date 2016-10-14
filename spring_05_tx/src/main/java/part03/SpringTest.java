package part03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

			ApplicationContext context = new ClassPathXmlApplicationContext("part03/tx.xml");
			Service svc=(Service)context.getBean("svc");
			
			try{
				//svc.insertProcess();
				svc.testProcess();
				System.out.println("result:ok");
			}catch (Exception e) {
				//exception 이벤트 에러 찾는 용도
				System.out.println("result:fail");
			}
			
	}//end main()

}//end class
