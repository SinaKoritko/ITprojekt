package com.hdm.itprojekt.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;



public interface NoteAdministrationAsync {
	
	  void init(AsyncCallback<Void> callback);
	
	
	  void createUser(User user, AsyncCallback<User> callback);
	  
	  void getCurrentUser(User user, AsyncCallback<User> callback);
	  
	  void getUserByMail(User user, AsyncCallback<User> callback);
	  
	  void getUserByID(User user, AsyncCallback<User> callback);
	  
	  void editUser(User user, AsyncCallback<User> callback);
	  
	  void deleteUser(User user, AsyncCallback<Void> callback);
	
	
	  void createNote(Note note, AsyncCallback<Note> callback);
	  
	  void editNote(Note note, AsyncCallback<Note> callback);
	  
	  void deleteNote(Note note, AsyncCallback<Void> callback);
	  
	  void getNotesOfUser(User user, AsyncCallback<ArrayList<Note>> callback);

}
