package part06_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바코드에서 어노테이션을 이용한 스프링 환경설정

//현재클래스(Config)를 스프링 환경설정으로 사용함을 의미한다.

@Configuration
public class Config {
	
	public Config() {}

	
	// <bean id="user" class="part06_annotation.ServiceImp">
	// <constructor-age value="kim"/>
	// <constructor-age value="1234"/>
	// </bean>
	public User user(){
		return new User("kim","1234");
	}
	
	// <bean id ="svc" class="part06_annotation.ServiceImp">
	// <consturctor-age ref="user"/>
	// </bean>
	
	@Bean
	public ServiceImp svc(){
		return new ServiceImp(user());
	}
	
	@Bean(name="ss")
	public ServiceImp serviceImp(){
		return new ServiceImp(user());
	}

}//end class
