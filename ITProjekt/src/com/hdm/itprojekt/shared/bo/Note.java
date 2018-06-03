package com.hdm.itprojekt.shared.bo;

import java.util.Date;

public class Note extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	
	private int noteID;
	private String noteTitle;
	private String noteContent;
	private Date creDate;
	private Date modDate;
	private int userID;
	
	
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	
	
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	
	
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
	
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date CreDate) {
		this.creDate = CreDate;
	}
	
	
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	

	
	
	
	

}
