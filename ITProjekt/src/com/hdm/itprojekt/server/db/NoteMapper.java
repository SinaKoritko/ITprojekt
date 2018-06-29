package com.hdm.itprojekt.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;

/**Notebook Mapper Klasse bildet Note-Objekte auf eine relationale Datenbank ab.
 * Diese Klasse stellt Methoden zur Verfuegung, die das erstellen, editieren, auslesen/suchen und loeschen 
 * der gewuenschten Datensaezte erlauben. Die Mapperklasse stellt die Verbindungsschicht zwischen Datenbank
 * und Applikationslogik dar. Datenbank-Strukturen koennen in Objekte umgewandelt werden, jedoch auch Objekte 
 * in Datenbankstrukturen
*/

public class NoteMapper {
	
	/**Klasse wird nur einmal instantiiert(Singleton)
	 * 
	 */
	
	private static NoteMapper noteMapper = null;
	
	/**
	  * Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	  * Instanzen dieser Klasse zu erzeugen.
	  * 
	  */
	
	protected NoteMapper() {
	}
	
	 /**Diese Methode ist statisch. Sie stellt die 
	 * Singleton-Eigenschaft sicher, es kann nur eine Instanz von 
	 * NoteMapper  existieren.
	 * 
	 * @return NoteMapper-Objekt
	 */
	
	public static NoteMapper noteMapper(){
		if (noteMapper == null){
			noteMapper = new NoteMapper();
		}
		
		return noteMapper;
	}
	
	
	/**
	 * Ein Note-Objekt wird in der Datenbank hinzugefuegt. Der Primaerschluessel wird ueberprueft 
	 * und gegebenenfalls neu zugeordnet.
	 * @param note (Objekt, das gespeichert werden soll)
	 * @return neu uebergebenes Objekt, mit angepasster ID
	 */
	
	public Note createNote(Note note){
		
		
		
		//DB Verbindung erstellen
		Connection con = DBConnection.connection();
		
		try{
			//Leeres SQL Statement anlegen
			Statement stmt = con.createStatement();
			
			//Statement ausfuellen und als Query an DB senden
			ResultSet rs = stmt.executeQuery("SELECT MAX(noteID) AS maxnoteID" + "FROM notes");
			
			
			
				SimpleDateFormat mySQLformat = new SimpleDateFormat("yyyy-MM-dd");
	
			
			/**
			 * Es kann max. ein Ergebnis zurueck gegeben werden, da die id der Primaerschluessel ist.
			 * Daher wird geprueft ob ein Ergebnis vorliegt
			 */
			
			if (rs.next()){
				//Ergebnis-Tupe in Objekt umwandeln
				note.setNoteID(rs.getInt("maxnoteID") + 1);
				stmt = con.createStatement();
				
				
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				
				stmt.executeUpdate("INSERT INTO notes(noteId,noteTitle, noteContent, creDate, modDate, userID) VALUES ("
				 		+ note.getNoteID()
				 		+ ",\"" +note.getNoteTitle()+ "\""
				 		+ ",\"" +note.getNoteContent()+ "\""
				 		+ ",\"" +mySQLformat.format(note.getCreDate())+ "\""
						+ ",\"" +mySQLformat.format(note.getModDate())+ "\""
						+ ",\"" +note.getUserID()+ "\""
				 		+ ")");
				
				/**
				stmt.executeUpdate("INSERT INTO notes (noteID, noteTitle, noteContent, creDate, modDate, userID)"
									+ "VALUES (" + note.getNoteID() + "," + note.getNoteTitle() + "," 
									+ note.getNoteContent() + "," + creDate + "," + modDate + ")");
									
								*/
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		/**
		 * Note wird zurueckgegeben, da sich das Objekt eventuell im Laufe der Methode veraendert hat
		 */
		    
		return note;
	}
	
	
	/**
	 * Note-Objekt wird ueberarbeitet ind ie Datenbank geschrieben
	 * 
	 * @param note (Objekt, dass ueberarbeitet in DB geschrieben wird)
	 * @return als Parameter uebergebenes Objekt.
	 */
	
	public Note updateNote(Note note){
		Connection con = DBConnection.connection();
		
		
			SimpleDateFormat mySQLformat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE notes SET "
					+ "title=\"" +note.getNoteTitle()+ "\","
					+ "noteContent=\"" +note.getNoteContent()+ "\","
					+ "modDate=\"" + mySQLformat.format(note.getModDate())+ "\""
					+ "where noteID=" + note.getNoteID()					
					);
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return note;
	}
	
	
	
	/**
	 * Ein Note-Objekt soll mit seinen Daten aus der DB geloescht werden.
	 * 
	 * @param note (Objekt wird aus DB geloescht)
	 */
	
	public void deleteNote(Note note){
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM notes" + "WHERE noteID =" + note.getNoteID());
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	

	public Vector<Note> findByUser(User user) {
		// DB-Verbindung holen und Variablen zurücksetzen
				int userID = user.getUserID();
				Connection con = DBConnection.connection();
		//		int noteID = 0;

				Vector<Note> result = new Vector<Note>();
				
				Vector<Integer> noteIDs = new Vector<Integer>();
				
				try{
					//Leeres SQL Statement anlegen
					Statement stmt = con.createStatement();
					
					//Statement ausfuellen und als Query an DB schicken
					ResultSet rs = stmt.executeQuery("SELECT noteID, noteTitle FROM notes WHERE userID=\"" 
					+ user.getUserID()
					+ "\"");

					
					while (rs.next()){
					Note note = new Note();
					note.setNoteID(rs.getInt("noteID"));
					note.setNoteTitle(rs.getString("noteTitle"));
					result.add(note);
					}
					
				}
					
					
			catch (SQLException e){
				e.printStackTrace();
				return null;
			}
				
				return result;
	}
	
	
public Note findNoteByID(int id)  {
		
	Connection con = DBConnection.connection(); 
	Note currentNote = new Note();
	currentNote.setNoteID(id);
		
		
		try {
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT noteTitle, noteContent, noteCreDate, noteModDate FROM notes where noteID="
				+ id); 
	    if(rs.next()) {
	    	
	    	currentNote.setNoteTitle(rs.getString("noteTitle")); 
	    	currentNote.setNoteContent(rs.getString("noteContent"));
	    	currentNote.setCreDate(rs.getDate("creDate"));
	    	currentNote.setModDate(rs.getDate("modDate"));
	    	
	    	return currentNote;
	    }
		
		
	} catch (SQLException e) {  
		e.printStackTrace();
		return null;
	}
	
	return null;
}
	
	
	
}
