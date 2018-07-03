package com.hdm.itprojekt.server.db;

import com.hdm.itprojekt.shared.bo.User;

public class TestDB {
	
	public static void main (String[] args){
		User user = new User();
		user.setMail("test@hdm.de");
		UserMapper.userMapper().insert(user);
	}

}

