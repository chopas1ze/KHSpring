package part04_collection;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Test2 {
	
	public static void main(String[] args) {
		Properties prop=System.getProperties();
		Set<Object> set=prop.keySet();
		Iterator<Object> ite=set.iterator();
		while(ite.hasNext()){
			Object key=ite.next();
			Object value=prop.get(key);
			System.out.printf("%s => %s\n",key, value);
		}
	}//end main()

}//end class
