package part02;

public class ServiceImp implements Service{
	private MemDaoImp dao;
	
	public ServiceImp() {
		
	}

	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}

	@Override
	public void insertProcess() {
		dao.insertMethod(new MemDTO(48,"용팔이",50,"경기"));
		dao.insertMethod(new MemDTO(49,"유대위",20,"대전"));
	
	}//end insertProcess()
	
}//end class
