package part05_exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("part05_exam/di.xml");
         Service svc=(Service)context.getBean("svc");
         svc.prn();
         /*
          * 출력결과
          *  kim  a1234
          */
         
         
	}//end main()

}//end class











