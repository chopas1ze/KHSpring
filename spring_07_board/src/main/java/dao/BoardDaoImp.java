package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.PageDTO;

public class BoardDaoImp implements BoardDAO{
	public BoardDaoImp() {
	}
	
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int count() {
		return sqlSession.selectOne("board.count");
		
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		return sqlSession.selectList("board.list",pv);
	}

	@Override
	public void readCount(int num) {
			
	}

	
	@Override
	public BoardDTO content(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO updateNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO dto) {
		sqlSession.update("borad.upt",dto);
		
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("board.del",num);
	}

	@Override
	public String getFile(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}//end class