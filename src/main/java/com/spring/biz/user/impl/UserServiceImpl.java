package com.spring.biz.user.impl;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.common.UserDTO;

// 서비스로직(비즈니스로직)
@Service("userService")
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public UserDTO getUser(UserDTO vo) throws Exception {
		
		// DAO를 호출하여  사용자정보를 가져와서 반환하는 서비스를 구현해 보세요
		
		return userDAO.getUser(vo);
	}

	@Override
	public ArrayList<UserDTO> getUserList() throws Exception {
		
		// DAO를 호출하여  사용자정보를 가져와서 반환하는 서비스를 구현해 보세요
		
		return userDAO.getUserList();
	}

}
