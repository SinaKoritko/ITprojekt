package com.hdm.itprojekt.shared.bo;

import java.io.Serializable;

import com.google.gwt.view.client.ProvidesKey;



public class User implements Serializable{
	
	
	/**
	 * Deklaration der serialVersionUID zur Serialisierung der Objekte
	 */
	private static final long serialVersionUID = 1L;
	public static final ProvidesKey<User> KEY_PROVIDER = null;
	
	/**
	 * Deklaration der Variablen des Users
	 */
	
	private int UserID;
	private String mail;
	private String firstname;
	private String lastname;
	
	
	/**
	 * Definieren von Set-/Get-Methoden, um Werte fuer Variablen setzten und abfragen zu koennen
	 * @return
	 */
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
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
	
	
	
	

}
