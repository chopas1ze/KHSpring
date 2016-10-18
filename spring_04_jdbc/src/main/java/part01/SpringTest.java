package part01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("part01/jdbc.xml");
		MemDao dao = (MemDao)context.getBean("dao");
		
		//dao.insertMethod(new MemDTO("박나리",40,"서울"));
		//dao.updateMethod(new MemDTO(16,"철수"));
		//dao.deleteMethod(20);
		
		List<MemDTO>  list = dao.list();
		for(MemDTO dto : list)
			System.out.printf("%d %s %d %s\n",dto.getNum(),dto.getName(),dto.getAge(),dto.getLoc());

	/*	MemDTO dto = dao.one(29);
		
			System.out.printf("%d %s %d %s\n",dto.getNum(),dto.getName(),dto.getAge(),dto.getLoc());
		
		System.out.println("count:"+dao.countMethod());*/
	}//end main()

}//end class
