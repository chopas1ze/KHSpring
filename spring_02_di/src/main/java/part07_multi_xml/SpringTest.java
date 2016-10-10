package part07_multi_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

			String data[] = new String[2];
			data[0] = "part07_multi_xml/di1.xml";
			data[1] = "part07_multi_xml/di2.xml";
			
			ApplicationContext context = new ClassPathXmlApplicationContext(data);
			
			String sn = (String)context.getBean("sn");
			System.out.println("문자열:"+sn);
			
			Integer it = (Integer)context.getBean("it");
			System.out.println("정수:"+it);
		
	}//end main()

}//end class
