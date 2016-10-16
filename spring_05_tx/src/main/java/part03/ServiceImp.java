package part03;

import org.springframework.transaction.annotation.Transactional;

public class ServiceImp implements Service{
	private MemDaoImp dao;
	
	public ServiceImp() {
		
	}

	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}

	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void insertProcess() {
		dao.insertMethod(new MemDTO(54,"용팔이",50,"경기"));
		dao.insertMethod(new MemDTO(55,"유대위",20,"대전"));
	
	}//end insertProcess()

	@Transactional(rollbackFor=java.lang.Exception.class)
	@Override
	public void testProcess() throws Exception{
		//트랜잭션이 설정된 메소드(선언적 트랜잭션2가지방법)에서는  try~catch을 설정하면 안되고
		//메소드를 호출하는 곳에서 try~catch을 한다.
		//트랜잭션이 설정된 메소드에서 예외처리하면 트랜잭션이 적용이 안된다.
		
			dao.insertMethod(new MemDTO(58,"용팔이",50,"경기"));
			dao.insertMethod(new MemDTO(58,"유대위",20,"대전"));	
		
		
		
	}//end testProcess()
	
}//end class
