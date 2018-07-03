package com.hdm.itprojekt.client.gui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.hdm.itprojekt.shared.bo.Note;

/**
 * Klasse zur Darstellung von Notiz-Objekten.
 * Solche Erweiterungen von <code>AbstractCell<T></code> dienen zur Erzeugung von
 * HTML-Code für benutzerdefinierte Objekte. In diesem Fall wird der <code>noteTitle</code>
 * eines Notizobjektes mit einem vorangestellten "Notiztitel " in einem <code>div-</code>Element
 * erzeugt.
 * 
 */

//public class NoteCell extends AbstractCell<Note> {
public class NoteCell extends AbstractCell<Note>{

	public void render(Context context, Note value, SafeHtmlBuilder sb) {
		//Value can be null, so do a null check
		
		if(value == null){
			return;
		}
		
		sb.appendHtmlConstant("<div notiztitel>");
		sb.appendEscaped(value.getNoteTitle());
		//sb.appendEscaped(value.getNoteTitle());
		sb.appendHtmlConstant("</div>");
	}


}
