package com.hdm.itprojekt.client.gui;

import java.util.Date;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.view.client.ListDataProvider;




public class EditNoteView extends Update{

	
	
	
	
	private Note currentNote = new Note();
	private String noteTitel = new String();
	private Note newNote = currentNote;
	private User user = new User();
	private User currentUser = new User();
	Date date = new Date();

	
	
	
	
	protected String getHeadlineText() {
		return "";
	}

	
	
	/**
	   * Erstellung aller Panels
	   */
	
	
	private HorizontalPanel headlinePanel = new HorizontalPanel();
	private HorizontalPanel textPanel = new HorizontalPanel();
	private HorizontalPanel datePanel = new HorizontalPanel();
	private HorizontalPanel buttonPanel = new HorizontalPanel();
	
	
	
	/**
	   * Erstellung aller Widgets
	   */
	
	private TextBox noteTitle = new TextBox();
	private TextArea textArea = new TextArea();
	final Button saveNoteBtn = new Button("Speichern");
	final Button deleteNoteBtn = new Button("Loeschen");
	final Button cancelEditNoteBtn = new Button("Abbrechen");
	private Label mainheadline = new Label("Notiz bearbeiten");
	private Label creDateLabel = new Label("Erstellungsdatum ");
	private Label creDate = new Label("");
	private Label modDateLabel = new Label("Zuletzt bearbeitet am ");
	private Label modDate = new Label("");
	
	
	
	
	protected void run() {
		this.append("");
		
		
		/**
		 * Connect the table to the data provider
		 * 
		 * dataProvider.addDataDisplay(cellList);
		 * cellList.setSelectionModel(selectionModel);
		 * noteTitle = Itprojekt.noteSelectionModel.getSelectedObject();
		 */
		
		//Zuteilung der Widgets zum jeweiligen Panel
		
		headlinePanel.add(mainheadline);
		buttonPanel.add(saveNoteBtn);
		buttonPanel.add(deleteNoteBtn);
		buttonPanel.add(cancelEditNoteBtn);
		textPanel.add(noteTitle);
		textPanel.add(textArea);
		datePanel.add(creDateLabel);
		datePanel.add(creDate);
		datePanel.add(modDateLabel);
		datePanel.add(modDate);
		
		RootPanel.get("contentBox").add(headlinePanel);
		RootPanel.get("contentBox").add(textPanel);
		RootPanel.get("contentBox").add(datePanel);
		RootPanel.get("contentBox").add(buttonPanel);
		
		textArea.setVisibleLines(20);
		textArea.setPixelSize(420, 350);
		
		noteTitle.setEnabled(false);
		textArea.setEnabled(false);
		saveNoteBtn.setEnabled(false);
		saveNoteBtn.setEnabled(false);
		deleteNoteBtn.setEnabled(false);
		
		
		
		
		 /**
	     * Zuweisung eines Styles fuer die jeweiligen Widgets
	     **/

		headlinePanel.setStyleName("headlinePanel");
		
		
		
		/**
	     * Erstellung der Clickhandler
	     **/
		
		
		
		
		
		
	}
	
	
}
