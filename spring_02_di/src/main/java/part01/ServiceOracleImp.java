package part01;
/*
 * 참조가 되는 객체 정의
 * 1 인터페이스를 상속받아 정의한다.
 * 2 무인자 생성자를 정의한다.
 */


public class ServiceOracleImp implements Service{

	//상속받은 객체는 무인자 생성자를 생성하도록 권장하고있으니 꼭 하길 바람.
	public ServiceOracleImp() {}
	
	@Override
	public void prn() {
		System.out.println("oracle");
		
	}

}//end class
