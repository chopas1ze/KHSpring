package part01;

public class ServiceMysqlImp implements Service{
	public ServiceMysqlImp() {
		System.out.println("constructor");
	}

	@Override
	public void prn() {
		System.out.println("mysql");
	}

}
