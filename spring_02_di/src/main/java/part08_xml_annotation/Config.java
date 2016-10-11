package part08_xml_annotation;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	
	@Bean
	public Random ran(){
		return new Random();
	}
	
	@Bean
	public long data(){
		return System.currentTimeMillis();
	}
	
	
}//end class
