package com.hdm.itprojekt.client.gui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;



public class HeaderView extends Composite {
	
	private HorizontalPanel hPanel = new HorizontalPanel();
	
	public HeaderView(){
		initWidget(this.hPanel);
		
		Label logo = new Label("Notebee");
		this.hPanel.add(logo);
		
		Label displayUsername = new Label("Benutzername anzeigen");
		this.hPanel.add(displayUsername);
		
		Button editUserBtn = new Button("edit User");
		this.hPanel.add(editUserBtn);
		
		Button logoutBtn = new Button("logout");
		this.hPanel.add(logoutBtn);
	}

}
