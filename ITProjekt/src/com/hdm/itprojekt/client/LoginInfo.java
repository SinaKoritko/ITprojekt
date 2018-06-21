package com.hdm.itprojekt.client;

import java.io.Serializable;

import com.hdm.itprojekt.server.LoginServiceImpl;


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
	private String mail;
	private String firstname;
	private String lastname;
	
	
	
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
		return mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	public String getFirstname() {
		return firstname;
	}
	

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

	public String getLastname() {
		return lastname;
	}
	

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		
	}
	
	

}
