package part08_xml_annotation;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("part08_xml_annotation/di.xml");
		Random ran = (Random)context.getBean("ran");
		System.out.println("난수:"+ran.nextDouble());
		
		Object date = (Object)context.getBean("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		String data = sdf.format(date);
		System.out.println("시간:"+data);
		
		
		
	}//end main()

}//end class
