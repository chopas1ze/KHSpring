package part01;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceImp implements Service{
	private MemDaoImp dao;
	private TransactionTemplate transactionTemplate;
	
	public ServiceImp() {
		
	}

	public void setDao(MemDaoImp dao) {
		this.dao = dao;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	@Override
	public void insertProcess() {
		Object result = transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				try{
					dao.insertMethod(new MemDTO(44,"용팔이",50,"경기"));
					dao.insertMethod(new MemDTO(45,"유대위",20,"대전"));
					return "ok";
				}catch(Exception ex){
					status.setRollbackOnly();
					return "fail";
				}
				
				
			}
		});
			System.out.println("result:"+result);
		
	}//end insertProcess()
	
	
	
}//end class
