package com.hdm.itprojekt.client.gui;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hdm.itprojekt.client.ClientsideSettings;
import com.hdm.itprojekt.shared.NoteAdministrationAsync;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;

public class CreateNoteView extends Update {
	
	
	private NoteAdministrationAsync noteAdministration = ClientsideSettings.getAdministration();
	

	private String noteTitel = new String();
	Date date = new Date();
	
	private Note note = new Note();
	private Note currentNote = new Note();
	
	private User user = new User();
	private User currentUser = new User();
	
	

	protected String getHeadlineText() {
		return "";
	}
	
	

	/**
	   * Erstellung aller Panels
	   */
	
	
	private HorizontalPanel headlinePanel = new HorizontalPanel();
	private VerticalPanel textPanel = new VerticalPanel();
	private HorizontalPanel datePanel = new HorizontalPanel();
	private HorizontalPanel buttonPanel = new HorizontalPanel();
	
	
	
	/**
	   * Erstellung aller Widgets
	   */
	
	private TextArea noteTitle = new TextArea();
	private TextArea textArea = new TextArea();
	final Button saveNoteBtn = new Button("Speichern");
	final Button cancelEditNoteBtn = new Button("Abbrechen");
	private Label titleLabel = new Label("Titel");
	private Label contentLabel = new Label ("Notiz Text");
	private Label mainheadline = new Label("Notiz erstellen/bearbeiten");
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
		buttonPanel.add(cancelEditNoteBtn);
		textPanel.add(titleLabel);
		textPanel.add(noteTitle);
		textPanel.add(contentLabel);
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
		textArea.setPixelSize(500, 250);
		noteTitle.setVisibleLines(20);
		noteTitle.setPixelSize(500, 20);
		
		

		
		 /**
	     * Zuweisung eines Styles fuer die jeweiligen Widgets
	     **/

		headlinePanel.setStyleName("headlinePanel");
		mainheadline.setStyleName("mainheadline");
		saveNoteBtn.setStyleName("btns");
		cancelEditNoteBtn.setStyleName("btns");
		titleLabel.setStyleName("editNoteLabel");
		contentLabel.setStyleName("editNoteLabel");
		noteTitle.setStyleName("textbox");
		textArea.setStyleName("textbox");
		creDateLabel.setStyleName("dateLabel");
		creDate.setStyleName("date");
		modDateLabel.setStyleName("dateLabel");
		modDate.setStyleName("dateLabel");
		
		//adminService.getCurrentUser(getCurrentUserCallback());		
		
		/**
		public void createNote(User user){
				noteTitle.setText("Type in your note title");
				textArea.setText("Type in your note");
			}
		
		*/
		
		saveNoteBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				
				/*
				 * Speichern der eingegebenen Werte blockieren, um
				 * Mehrfach-Klicks und daraus entstehende, unnoetige Eintraege in
				 * der Datenbank zu verhindern.
				 */
				saveNoteBtn.setEnabled(false);
				
				Note newNote = new Note();
				newNote.setNoteID(note.getNoteID());
				newNote.setNoteTitle(noteTitle.getText());
				newNote.setNoteContent(textArea.getText());
				Date currentDate = new Date();
				newNote.setCreDate(currentDate);
				newNote.setModDate(currentDate);
				newNote.setUserID(user.getUserID());
				
				
			
				//Note objekt zum server senden via RPC
				noteAdministration.createNote(newNote, new AsyncCallback<Note>(){
					
						public void onFailure(Throwable errorMessage){
						}
						
						public void onSuccess(Note result){ //Wenn DB Connection hergestellt wurde und Notiz gespeichert wurde wird neue View geladen
							Update update = new NoteOverview();
							RootPanel.get("contentBox").clear();
							RootPanel.get("contentBox").add(update);
						}
					

			
				});
			}
			
		});
			
		cancelEditNoteBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				
				Update update = new NoteOverview();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
				
			}
		});
		
		
		
			}
			
		
		
		
				
	
		
	}


