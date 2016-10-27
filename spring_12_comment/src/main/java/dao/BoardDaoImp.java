package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardDaoImp implements BoardDao {
	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImp() {
}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BoardDTO> boardListMethod() {
		return sqlSession.selectList("board.b_list");
	}

	@Override
	public BoardDTO boardViewMethod(int bno) {
		return sqlSession.selectOne("board.b_view",bno);
	}

	@Override
	public void replyInsertMethod(ReplyDTO rdto) {
		sqlSession.insert("reply.r_insert",rdto);
	}

	@Override
	public List<ReplyDTO> replyListMethod(int bno) {
		return sqlSession.selectList("reply.r_list",bno);
	}
	
	@Override
	public void replyDeleteMethod(int rno) {
		sqlSession.delete("reply.r_delete",rno);
	}
	
	@Override
	public void replyUpdateMethod(ReplyDTO rdto) {
		sqlSession.update("reply.r_update",rdto);
	}
	
	
}//end class
