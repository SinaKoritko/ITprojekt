package com.hdm.itprojekt.client.gui;

import java.util.Date;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.hdm.itprojekt.client.ITProjekt;
import com.hdm.itprojekt.shared.bo.Note;
import com.hdm.itprojekt.shared.bo.User;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusWidget;



public class NoteOverview extends Update{
	
	protected String getHeadlineText() {
		return "";
	}
	
	protected void run() {
		this.append("");

	
	final VerticalPanel contentPanel = new VerticalPanel();
	final VerticalPanel navigationPanel = new VerticalPanel();
	
	final Button createNoteBtn = new Button("new note");
	
	
	
	
	createNoteBtn.setStyleName("btns");
	
	//contentPanel.add(createNoteBtn);
	RootPanel.get("contentBox").add(contentPanel);
	
	
	
	createNoteBtn.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {
			//Showcase/update instantiieren
			Update update = new CreateNoteView();
			RootPanel.get("contentBox").clear();
			RootPanel.get("contentBox").add(update);
		}
	});
	
	}
}
