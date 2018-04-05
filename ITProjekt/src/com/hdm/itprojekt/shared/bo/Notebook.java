package com.hdm.itprojekt.shared.bo;

import java.util.Date;

public class Notebook extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	
	
	private int nbID;
	private String nbTitle;
	private Date nbModDate;
	private Date nbCreDate;
	private int userID;
	
	
	
	public int getNbID() {
		return nbID;
	}
	public void setNbID(int nbID) {
		this.nbID = nbID;
	}
	
	
	public String getNbTitle() {
		return nbTitle;
	}
	public void setNbTitle(String nbTitle) {
		this.nbTitle = nbTitle;
	}
	
	
	public Date getNbModDate() {
		return nbModDate;
	}
	public void setNbModDate(Date nbModDate) {
		this.nbModDate = nbModDate;
	}
	
	
	public Date getNbCreDate() {
		return nbCreDate;
	}
	public void setNbCreDate(Date nbCreDate) {
		this.nbCreDate = nbCreDate;
	}
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	

}
