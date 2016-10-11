package part01_xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectCommon {

		public AspectCommon() {
		}
		
		public void comm1(){
			System.out.println("before");
		}
		
		public void comm2(){
			System.out.println("after");
		}
		
		public void comm3(String name){
			System.out.println("comm3:"+name);
		}
		
		public void comm4(Exception ex){
			System.out.println("comm4");
			if (ex != null)
				System.out.println(ex.toString());
		}
		
		public void comm5(ProceedingJoinPoint point){
			System.out.println("comm5 start");
			try {
				point.proceed(); //핵심로직으로 권한을 위임한다.
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("comm5 end");
		}
	
}//end class
