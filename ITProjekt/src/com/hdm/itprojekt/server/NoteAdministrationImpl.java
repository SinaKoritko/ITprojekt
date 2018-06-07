package com.hdm.itprojekt.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hdm.itprojekt.server.db.NoteMapper;
import com.hdm.itprojekt.server.db.UserMapper;
import com.hdm.itprojekt.shared.NoteAdministration;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;



@SuppressWarnings("serial")
public class NoteAdministrationImpl extends RemoteServiceServlet
implements NoteAdministration {

	

	
	
	
	
	  private Date date = new Date();
	  
	 /**
	   * Referenz auf das zugehörige Bank-Objekt.
	   */
	  private Note note = null;

	  /**
	   * Referenz auf den DatenbankMapper, der Notizobjekte mit der Datenbank
	   * abgleicht.
	   */
	  private NoteMapper noteMapper = null;

	  /**
	   * Referenz auf den DatenbankMapper, der Userobjekte mit der Datenbank
	   * abgleicht.
	   */
	  private UserMapper userMapper = null;

	  
	  //Initialisierung start
	  
	  public NoteAdministrationImpl() throws IllegalArgumentException {
		    /*
		     * Eine weitergehende Funktion muss der No-Argument-Constructor nicht haben.
		     * Er muss einfach vorhanden sein.
		     */
		  }
	
	  
	  /**
	   * Initialsierungsmethode. Diese Methode muss für jede Instanz von
	   * <code>NoteAdministrationImpl</code> aufgerufen werden.
	   */
	  
	  @Override
	  public void init() throws IllegalArgumentException {
	      /*
	       * Ganz wesentlich ist, dass die BankAdministration einen vollständigen Satz
	       * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	       * kommunizieren kann.
	       */
	      this.noteMapper = NoteMapper.noteMapper();
	      this.userMapper = UserMapper.userMapper();
	      
	    }
	
	  //Initialisierung Ende
	  
	  //Beginn Methoden fuer User Objekte
	  
	  /**
	   * Anlegen eines neuen Users. Dies führt implizit zu einem Speichern des
	   * neuen Users in der Datenbank.
	   * 
	   *Änderungen an User-Objekten müssen stets durch Aufruf
	   * von save(User user) in die Datenbank transferiert werden.
	   */
	
	
	@Override
	public User createUser(User user) throws IllegalArgumentException {
		User currentuser = new User();
		currentuser = this.userMapper.insert(user);
		return currentuser;
	}
	
	
	
	/*
	 * Auslesen des aktuellen Benutzernamen aus der Google Accounts API, um
	 * das Profil des aktuellen Benutzers aus der Datenbank zu lesen.
	 */
	/**
	public User getCurrentUser() throws IllegalArgumentException {
		User currentUser = new User();
		UserService userService = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User user = userService.getCurrentUser();
		String mail = user.getEmail();
		currentUser = this.getUserByMail(mail);
		return currentUser;
	}
	
	*/
	

	public User getUserByMail(String mail) throws IllegalArgumentException{
		User user = new User();
		if (this.userMapper.findByMail(mail) != null){
			user = this.userMapper.findByMail(mail);
		}
		else{
			User newUser = new User();
			newUser.setMail(mail);
			user = this.createUser(newUser);
			
		}
		return user;
	}
	
	
	
	@Override
	public User getUserByID(int userID) throws IllegalArgumentException{
		User user = new User();
		user = this.userMapper.findByKey(userID);
		return user;
	}
	
	

	@Override
	public User editUser(User user) throws IllegalArgumentException {
		User u = new User();
		u = this.userMapper.editUser(user);
		return u;
	}

	
	@Override
	public void deleteUser(User user) throws IllegalArgumentException {
		this.userMapper.deleteUser(user);
	}
		

	
	@Override
	public Note createNote(Note note) throws IllegalArgumentException {
		Note currentNote = new Note();
		currentNote = this.noteMapper.createNote(note);

		return currentNote;
	}

	
	@Override
	public Note editNote(Note note) throws IllegalArgumentException {
		Note currentNote = this.noteMapper.updateNote(note);
		return currentNote;
	}

	
	public void deleteNote(Note note) throws IllegalArgumentException {
		this.noteMapper.deleteNote(note);
		
	}

	@Override
	public ArrayList<Note> getNotesOfUser(User user) throws IllegalArgumentException {
		Vector<Note> vector = this.noteMapper.findByUser(user);
		ArrayList<Note> notes = new ArrayList<Note>();
		
		if (vector.size() == 0){
			Note currentNote = new Note();
			currentNote.setNoteTitle("erste Notiz");
			currentNote.setModDate(date);
			currentNote.setCreDate(date);
			currentNote = this.createNote(currentNote);
			vector = this.noteMapper.findByUser(user);
			
	}else {
		Boolean isExisting = new Boolean(false);
		notes.add(vector.get(0));
		for(int i = 0; i < vector.size(); i++){
			for(int y = 0; y < notes.size(); y++){
				if(vector.get(i).getNoteID() == notes.get(y).getNoteID()){
					isExisting = true;
				}
			}
				
				if(isExisting == false){
    				notes.add(vector.get(i));
    			}else{
    				isExisting = false;
    			}
		}
		}
	
			return notes;
	}
		
		
		



	@Override
	public User getCurrentUser(User user) throws IllegalArgumentException {
		User currentUser = new User();
		UserService userService = UserServiceFactory.getUserService();
		com.google.appengine.api.users.User apiuser = userService.getCurrentUser();
		String mail = apiuser.getEmail();
		currentUser = this.getUserByMail(mail);
		return currentUser;
	}

}
