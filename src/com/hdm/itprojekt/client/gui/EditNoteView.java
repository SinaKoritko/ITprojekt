package com.hdm.itprojekt.client.gui;

import java.util.Date;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hdm.itprojekt.client.ITProjekt;
import com.hdm.itprojekt.shared.NoteAdministration;
import com.hdm.itprojekt.shared.NoteAdministrationAsync;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.view.client.ListDataProvider;
import com.google.appengine.api.xmpp.Error;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusWidget;






public class EditNoteView extends Update{

	
	private final NoteAdministrationAsync noteAdministration = GWT.create(NoteAdministration.class);
	
	
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
	final Button deleteNoteBtn = new Button("Loeschen");
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
		buttonPanel.add(deleteNoteBtn);
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
		deleteNoteBtn.setStyleName("btns");
		cancelEditNoteBtn.setStyleName("btns");
		titleLabel.setStyleName("editNoteLabel");
		contentLabel.setStyleName("editNoteLabel");
		noteTitle.setStyleName("textbox");
		textArea.setStyleName("textbox");
		creDateLabel.setStyleName("dateLabel");
		creDate.setStyleName("date");
		modDateLabel.setStyleName("dateLabel");
		modDate.setStyleName("dateLabel");
		

		
		
		
		
		
		/**
	     * Erstellung der Clickhandler
	     **/
		
		
		
		
		saveNoteBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				
				/*
				 * Speichern der eingegebenen Werte blockieren, um
				 * Mehrfach-Klicks und daraus entstehende, unnoetige Eintraege in
				 * der Datenbank zu verhindern.
				 */
				
				
				currentNote.setNoteTitle(noteTitle.getText());
				currentNote.setNoteContent(textArea.getText());
				Date currentDate = new Date();
				currentNote.setModDate(currentDate);
				
				
					
				// bestehende Notiz wird anhand von currentUser ID editiert
				noteAdministration.editNote(currentNote, new AsyncCallback<Note>(){
					public void onFailure(Throwable errorMessage){
					}
					
					public void onSuccess(Note result){
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
		
		
		deleteNoteBtn.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				
				noteAdministration.deleteNote(currentNote, deleteNoteCallback());
				
				
			}
			
		});
		
		
		
			}
		
	
	private AsyncCallback<Void> deleteNoteCallback(){
		AsyncCallback<Void> asyncCallback = new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Notiz konnte nicht geloescht werden");
				
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Notiz wurde geloescht");
				
				Update update = new NoteOverview();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
				
			}
			
		};
		return asyncCallback;
	}
	
	
			
	
	

}
	

