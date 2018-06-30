package com.hdm.itprojekt.client;

import java.io.Serializable;

import com.hdm.itprojekt.server.LoginServiceImpl;
import com.hdm.itprojekt.shared.bo.User;


/**
 * Diese Klasse ist Bestandteil des Login-Vorgangs, um sich als Benutzer an der
 * Applikation anmelden und diese nutzen zu koennen. Siehe dazu auch
 * {@link LoginServiceImpl}
 * 
 * @author Sina Koritko
 */

public class LoginInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean loggedIn = false;
	private String loginUrl;
	private String logoutUrl;
	private String emailAddress;

	
	
	public boolean isLoggedIn(){
		return loggedIn;
	}
	
	

	
	/**
	 * Get- und Set-Methoden aller Attribute
	 * @return
	 */
	
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}

	
	public String getLoginUrl() {
		return loginUrl;
	}
	
	

	public String getLogoutUrl() {
		return logoutUrl;
	}
	

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	

	public String getMail() {
		return emailAddress;
	}

	
	public void setMail(String mail) {
		this.emailAddress = mail;
	}

	
	




	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		
	}
	
	

}
