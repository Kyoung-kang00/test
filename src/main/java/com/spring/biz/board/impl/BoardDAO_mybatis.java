package com.spring.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.common.BoardDTO;
import com.spring.biz.common.JDBCUtil;

@Repository
public class BoardDAO_mybatis {

		@Autowired
		SqlSessionTemplate mybatis;
	
	
	//글 등록
		public void insertBoard(BoardDTO vo) {
			
			System.out.println("MyBatis의  insertBoard()처리");
			mybatis.insert("BoardDAO.insertBoard", vo);   // 맵퍼  namespace.id
			mybatis.commit();
		}
		
		//글 수정
		public void updateBoard(BoardDTO vo) {  // update board set title=?,content=? where seq=?
			System.out.println("MyBatis의  updateBoard()처리");
			mybatis.update("BoardDAO.updateBoard", vo);   // 맵퍼  namespace.id
			mybatis.commit();
		}
		
		//글 삭제
		public void deleteBoard(BoardDTO vo) {   // delete from board where seq=?
		}
		
		//글 상세조회
		public BoardDTO getBoard(BoardDTO vo) {   // select * from board where seq=?
			return mybatis.selectOne("BoardDAO.getBoard",vo);
		}
		
		//글 전체조회
		public List<BoardDTO> getBoardList(BoardDTO vo){      //  select * from board order by seq desc
			System.out.println("MyBatis의  getBoardList()처리");
			return mybatis.selectList("BoardDAO.getBoardList",vo);
		}
}
