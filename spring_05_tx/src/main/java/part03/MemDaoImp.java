package part03;

import org.mybatis.spring.SqlSessionTemplate;

public class MemDaoImp implements MemDao {
	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins",dto);
	}
	
	
}//end class
