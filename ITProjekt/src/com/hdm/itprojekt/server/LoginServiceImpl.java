package com.hdm.itprojekt.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.hdm.itprojekt.client.LoginInfo;
import com.hdm.itprojekt.client.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInfo login(String requestUri){
		UserService userService = UserServiceFactory.getUserService();
		User currentuser = userService.getCurrentUser();
		LoginInfo loginInfo = new LoginInfo();
		
		if (currentuser != null){
			loginInfo.setLoggedIn(true);
			loginInfo.setMail(currentuser.getEmail());
			loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
		}
		else{
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}
		return loginInfo;
	}
}
