package part05;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemDaoImp implements MemDao {

	private SqlSessionTemplate sqlSession;
	
	
	public MemDaoImp() {}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<MemDTO> listMethod() {
		return sqlSession.selectList("mem.all");
	}

	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins",dto);
	}
	
	

}// end class
