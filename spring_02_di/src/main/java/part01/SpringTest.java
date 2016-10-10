package part01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

public class SpringTest {

	/*
	 * 컨테이너(container)
	 * 1 BeanFactory -getBean() 할때 빈들이 컨테이너에 생성됨 
	 * 2 ApplicationContext - container가 생성될때 빈들이 컨테이너에 생성됨
	 * 3 WebApplicationContext - was(tomcat)가 실행될때 빈들이 컨테이너에 생성됨 
	 */
	
	public static void main(String[] args) {
		/*
		 * 환경설정(part01/dl.xml)에 선언된 빈들을 생성하고 관리해주는 객체를 container라 한다.
		 * 현재 사용되고 있는 container은 ApplicationContext이다.
		 */
		
		//ApplicationContext 컨테이너(클래스) 에 di.xml의 bean 들을 관리하고 생성한다. 
		ApplicationContext context = new ClassPathXmlApplicationContext("part01/di.xml");
		//getBean의 리턴 타입은 오브젝트이기떄문 Service 로 다운캐스트한다.
		Service svc =(Service)context.getBean("svc");
		svc.prn();
		
	}//end main()

}//end class
