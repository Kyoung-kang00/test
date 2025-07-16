package com.spring.biz.user.impl;

import java.util.ArrayList;
import com.spring.biz.common.UserDTO;

public interface UserService {

	// 사용자검색
	public UserDTO getUser(UserDTO vo) throws Exception;
	
	// (추가)등록된 전체사용자검색
	public ArrayList<UserDTO> getUserList() throws Exception;
	
}
