package com.hdm.itprojekt.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel header; 
	private VerticalPanel contentPanel;
	private HorizontalPanel footer;
	
	public MainView(){
		initWidget (this.vPanel);
		
		this.header = new HorizontalPanel();
		this.vPanel.add(header);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
		
		this.footer = new HorizontalPanel();
		this.vPanel.add(footer);
	}
	
	
}
