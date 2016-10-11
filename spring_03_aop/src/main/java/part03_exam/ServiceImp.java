package part03_exam;

public class ServiceImp implements Service{

	public ServiceImp() {}
		
	@Override
	public void prn() {
		System.out.println("prn");
		int sum = 0;
		for(int i = 0; i<100000000; i++)
			sum += i;
		
	}//end prn()

	
}//end class
