package com.hdm.itprojekt.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hdm.itprojekt.shared.bo.User;

public class UserMapper {
	
	//Instanziieren des UserMappers
	private static UserMapper userMapper = null;
	
	/**
	 * Mithilfe des <code>protected</code>-Attributs im Konstruktor wird
	 * verhindert, dass von anderen Klassen eine neue Instanz der Klasse
	 * geschaffen werden kann.
	 */
	
	protected UserMapper(){
		
	}
	

	
	/**
	 * Aufruf eines USER-Mappers fuer Klassen, die keinen Zugriff auf den
	 * Konstruktor haben.
	 * 
	 * @return Einzigartige Mapper-Instanz zur Benutzung in der
	 *         Applikationsschicht
	 */
	
	public static UserMapper userMapper(){
		if(userMapper == null){
			userMapper = new UserMapper();
		}
		
		return userMapper;
	}
	

	/**
	 * Read-Methode - Anhand einer vorgegebenen id wird der dazu gehoerige User
	 * in der Datenbank gesucht.
	 * 
	 * @param userID
	 *            Die id des Users, der aus der Datenbank gelesen werden soll
	 * @return Das durch die id referenzierte User-Objekt
	 */

	public User findByKey(int userID){
		
		//DB Verbindung herstellen
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			//Statement ausfuellen und als Query an DB senden
			ResultSet rs = stmt.executeQuery("SELECT userID, mail, firstname, lastname FROM users" 
					+ "WHERE userID =" + userID);
			
			/**
			 * Da id Primaerschluessel ist, kann max. nur ein Tupel zurueckgegeben
			 * werden. Pruefe, ob ein Ergebnis vorliegt.
			 */
			
			if(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt("userID"));
				user.setMail(rs.getString("Mail"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				return user;
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
	
	
	
public User findByMail(String mail){
		
		//DB Verbindung herstellen
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			//Statement ausfuellen und als Query an DB senden
			ResultSet rs = stmt.executeQuery("SELECT userID, mail, firstname, lastname FROM users" 
					+ "WHERE mail =" + mail);
			
			/**
			 * Da mail einzigartig ist, kann max. nur ein Tupel zurueckgegeben
			 * werden. Pruefe, ob ein Ergebnis vorliegt.
			 */
			
			if(rs.next()){
				User user = new User();
				user.setUserID(rs.getInt("userID"));
				user.setMail(rs.getString("mail"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				return user;
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
	
	
	/**
	 * Insert-Methode - Ein User-Objekt wird �bergeben und die zugehoerigen
	 * Werte in ein SQL-Statement geschrieben, welches ausgef�hrt wird, um das
	 * Objekt in die Datenbank einzutragen.
	 * 
	 * @param user
	 *            User, der in die Datenbank geschrieben werden soll
	 * @return User-Objekt, das in die Datenbank geschrieben wurde
	 */
	
	public User insert(User user){
		
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			/**
			 * Zunaechst schauen wir nach, welches der momentan hoechste
			 * Primaerschluesselwert ist.
			 */
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(useriD) AS maxUserID" + "FROM users");
			
			if (rs.next()){
				
				/**
				 * user erhaelt den bisher maximalen, nun um 1 inkrementierten
				 * Primaerschluessel.
				 */
				user.setUserID(rs.getInt("maxUserID") + 1);
				
				//Neues SQL  Statement erzeugen
				stmt = con.createStatement();
				
				//Einfuegeoperation fuer Statement
				stmt.executeUpdate("INSERT INTO users (userID, mail, firstname, lastname)" + "VALUES ('" + user.getUserID() + "','" + user.getMail() + "','" + user.getFirstname() + "','" + user.getLastname() + "')" );
				
				return user;
				
			} 
			
		}catch (SQLException e){
			e.printStackTrace();
				
			return null;
		
		}
		
		return null;
		
	}
	
	/**
	 * Delete-Methode - Ein User-Objekt wird �bergeben, anhand dessen der
	 * zugehoerige Eintrag in der Datenbank geloescht wird
	 * 
	 * @param user
	 * User, der geloescht werden soll
	 */

	public void deleteUser(User user){
		
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM users" + "WHERE userID =" + user.getUserID());
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Edit-Methode - Ein Profil wird uebergeben und die zugehoerigen Werte in ein
	 * SQL-Statement geschrieben, welches ausgefuehrt wird, um die
	 * Informationswerte des Profils in der Datenbank zu aktualisieren.
	 * 
	 * @param user
	 *            Der User, dessen Variablen in der DB geaendert werden soll.
	 */

	public User editUser(User user){
		
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("UPDATE users" + "SET firstname ='" + user.getFirstname() + "'," + "lastname ='" + user.getLastname() + "WHERE userID =" + user.getUserID());
		
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return user;
	}
	

}
