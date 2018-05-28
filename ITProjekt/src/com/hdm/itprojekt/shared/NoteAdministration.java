package com.hdm.itprojekt.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;




@RemoteServiceRelativePath("noteadministration")
public interface NoteAdministration extends RemoteService{
	
	 /**
	   * Initialisierung des Objekts. 
	   * 
	   * @throws IllegalArgumentException
	   */
	  public void init() throws IllegalArgumentException;
	  
	  
	  public User createUser(User user) throws IllegalArgumentException;
	  
	  public User getCurrentUser(User user) throws IllegalArgumentException;
	  
	  public User getUserByMail(User user) throws IllegalArgumentException;
	  
	  public User getUserByID(User user) throws IllegalArgumentException;
	  
	  public User editUser(User user) throws IllegalArgumentException;
	  
	  public void deleteUser(User user) throws IllegalArgumentException;
	  
	 
	  public Note createNote(Note note) throws IllegalArgumentException;
	  
	  public Note editNote(Note note) throws IllegalArgumentException;
	  
	  public void deleteNote(Note note) throws IllegalArgumentException;
	  
	  public ArrayList<Note> getNotesOfUser(User user) throws IllegalArgumentException;
	  
	  
	  
	  

	

}
