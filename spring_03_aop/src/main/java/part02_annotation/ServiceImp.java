package part02_annotation;

public class ServiceImp implements Service{
	
	public ServiceImp() {
	}

	@Override
	public void prn1() {
		System.out.println("prn");
	}

	@Override
	public void prn1(int x) {
		System.out.println("prn:"+x);
	}

	@Override
	public void prn1(int a, int b) {
		System.out.printf("prn: a=%d b=%d\n",a,b);
	}

	@Override
	public void prn2() {
		System.out.println("prn2");
	}

	@Override
	public String prn3() {
		System.out.println("prn3");
		return "홍길동";
	}

	@Override
	public void prn4() {
		System.out.println("prn4");
		String data="";
		int num=Integer.parseInt("data");
	}

	@Override
	public void prn5() {
		System.out.println("prn5");
	}
	
	
	
}//end class
