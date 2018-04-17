package com.hdm.itprojekt.shared;

import java.io.Serializable;


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
	private String email;
	private String firstname;
	private String lastname;
	
	
	
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	
	/**
	 * Get- und Set-Methoden aller Attribute
	 * @return
	 */
	
	public boolean isLoggedIn(){
		return loggedIn;
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
	

	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
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
	
	

}
