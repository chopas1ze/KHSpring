package part03_search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDaoImp implements EmpDAO {
	private SqlSessionTemplate sqlSession;
	
	public EmpDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<EmployeeDTO> search(String data) {
		
		
		return sqlSession.selectList("emp.list",data);
	}
	
	

}//end class
