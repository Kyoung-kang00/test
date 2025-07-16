package com.spring.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.common.UserDTO;

@Repository("userDAO_mybatis")
public class UserDAO_mybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원검색
	public UserDTO getUser(UserDTO vo) {
		
		return mybatis.selectOne("UserDAO.getUser", vo);
		
	}
	
	// 회원등록
	public List<UserDTO> getUserList(UserDTO vo) {
		
		return mybatis.selectList("UserDAO.getUserList", vo);
		
	}
	
	// 회원전체검색 - jsp뷰 작성해서 확인 필요

	// 회원수정 - jsp뷰 작성해서 확인 필요

	// 회원탈퇴 - jsp뷰 작성해서 확인 필요
	
}
