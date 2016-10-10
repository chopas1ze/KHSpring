package part04_collection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ServiceImp implements Service {

	private List<Integer> list;
	private Map<String, Integer> map;
	private Set<String> set;
	private Properties prop;
	
	
	
	public void setList(List<Integer> list) {
		this.list = list;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public ServiceImp() {
	}
	
	@Override
	public void prn1() {
		
			for(Integer it : list)
				System.out.println(it);
		
	}

	@Override
	public void prn2() {
			Set<String> set = map.keySet();
			Iterator<String> ite = set.iterator();
			while(ite.hasNext()){
				String key = ite.next();
				Integer value = map.get(key);
				System.out.printf("%s %d\n", key, value);
			}
			
	}

	@Override
	public void prn3() {
			Iterator<String> ite = set.iterator();
			while(ite.hasNext()){
				System.out.printf("%s\n",ite.next());
			}
	}

	@Override
	public void prn4() {
			Set<Object> set = prop.keySet();
			Iterator<Object> ite = set.iterator();
			while(ite.hasNext()){
				Object key = ite.next();
				Object value = prop.get(key);
				System.out.printf("%s %s\n", key, value);
			}
	}

	
}//end class
