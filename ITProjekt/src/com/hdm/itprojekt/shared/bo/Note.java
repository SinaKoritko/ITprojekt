package com.hdm.itprojekt.shared.bo;

import java.util.Date;

public class Note extends BusinessObject{
	
	private static final long serialVersionUID = 1L;
	
	private int noteID;
	private String noteTitle;
	private String noteSubTitle;
	private String noteContent;
	private Date noteCreDate;
	private Date noteModDate;
	private int userID;
	private int nbID;
	
	
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
	
	
	public String getNoteSubTitle() {
		return noteSubTitle;
	}
	public void setNoteSubTitle(String noteSubTitle) {
		this.noteSubTitle = noteSubTitle;
	}
	
	
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	
	
	public Date getNoteCreDate() {
		return noteCreDate;
	}
	public void setNoteCreDate(Date noteCreDate) {
		this.noteCreDate = noteCreDate;
	}
	
	
	public Date getNoteModDate() {
		return noteModDate;
	}
	public void setNoteModDate(Date noteModDate) {
		this.noteModDate = noteModDate;
	}
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	public int getNbID() {
		return nbID;
	}
	public void setNbID(int nbID) {
		this.nbID = nbID;
	}
	
	
	
	

}
