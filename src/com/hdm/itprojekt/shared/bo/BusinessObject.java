package com.hdm.itprojekt.shared.bo;

import java.io.Serializable;

public abstract class BusinessObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id = 0;

	/**
	 * Gibt die eindeutige Datenbank-ID des Objekts zur�ck.
	 * @return id
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * Setzt die ID des Objekts
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gibt ein Objekt als String zurueck. Dabei wird ein Format definiert
	 * 
	 * @return String im vorgefertigten Format
	 */

	public String toString() {

		return this.getClass().getName() + " #" + this.id;
	}

	/**
	 * Vergleicht das aufrufende BO mit dem im Parameterbereich uebergebenen BO.
	 * 
	 * @param o
	 * @return boolischer Wert
	 */

	public boolean equals(Object o) {

		if (o != null && o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) o;
			try {
				if (bo.getId() == this.id)
					return true;
			} catch (IllegalArgumentException e) {

				return false;
			}
		}

		return false;
	}

}
