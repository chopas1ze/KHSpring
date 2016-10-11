package part03_exam;

public class StopWatch {

	private long cal1, cal2;
	
	public void start(){
		cal1 = System.currentTimeMillis();
		System.out.println("start:"+cal1);
		
	}//end start()
	
	
	public void stop(){
		cal2 = System.currentTimeMillis();
		System.out.println("stop:"+cal2);
		
	}//end end()
	
	public long getTotalTimeMillis(){
		return cal2 - cal1;
		
	}//end getTotalTimeMillis()
	
}//end class
