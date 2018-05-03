package com.hdm.itprojekt.client;

//import com.hdm.itprojekt.client.ClientsideSettings;
//import com.hdm.itprojekt.client.gui.LoginService;
//import com.hdm.itprojekt.client.gui.LoginServiceAsync;
//import com.hdm.itprojekt.shared.LoginInfo;
//import com.hdm.itprojekt.shared.NoteAdministrationAsync;
import com.hdm.itprojekt.shared.bo.User;
import com.hdm.itprojekt.client.gui.Update;
import com.hdm.itprojekt.shared.FieldVerifier;
import com.hdm.itprojekt.shared.bo.User;
import com.hdm.itprojekt.client.gui.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ITProjekt implements EntryPoint {
	
/**	LoginServiceAsync loginService = GWT.create(LoginService.class);
	private LoginInfo loginInfo = null;
	*/
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel header = new HorizontalPanel();
	private VerticalPanel contentPanel = new VerticalPanel();
	private VerticalPanel navigationPanel = new VerticalPanel();
	private HorizontalPanel footer = new HorizontalPanel();
	private Label logo = new Label("Notebee");
	private Label displayUsername = new Label ("username anzeigen");
	//private Button editUserBtn = new Button("edit User");
	private Anchor loginLink = new Anchor("login");
	private Label copyright = new Label("(c) Hochschule der Medien, Sina Koritko");
	
	
	
	
	final static Button createNoteBtn = new Button("new note");
	
	
	
	
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	
	/**private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";
*/
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
//	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/**
		
		//Login Status abfragen mit Hilfe des Login Service
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {
			}
			
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if(loginInfo.isLoggedIn()) {
					//loadAnfangsbildschirm()
				}
				else {
					loadLogin();
				}
			}

		
		});
		
		*/
	
	
		/**Add style names
		 */
		
		createNoteBtn.addStyleName("createNoteBtn");
		//noteViewPanel.setStyleName("noteViewPanel");
		loginLink.setStyleName("loginLink");
		logo.setStyleName("logo");
		displayUsername.setStyleName("displayUsername");
		header.setStyleName("header");
		footer.setStyleName("footer");
		
		
		
		/**Zuteilung der Widgets zum jeweiligen Panel
		 * */
	
		//mainPanel.add(header);
		//mainPanel.add(navigationPanel);
		//mainPanel.add(contentPanel);
		//mainPanel.add(footer);
		
		contentPanel.add(createNoteBtn);

		
		header.add(logo);
		header.add(displayUsername);
		//header.add(editUserBtn);
		header.add(loginLink);
		
		footer.add(copyright);
		
		

		/**
		 * Associate main panel with HTML host page
		 */
		
		//RootPanel.get("mainBox").add(mainPanel);
		RootPanel.get("header").add(header);
		RootPanel.get("contentBox").add(contentPanel);			
		RootPanel.get("navigation").add(navigationPanel);
		RootPanel.get("footer").add(footer);
		
		
		
		
		createNoteBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Showcase/update instantiieren
				Update update = new EditNoteView();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
			}
		});

		
		
	
		/**
		class LoginClickhandler implements ClickHandler{
			public void onClick(ClickEvent event){
				//action
			}
		}
		
		loginLink.addClickHandler(new LoginClickhandler());
		
		
		
	*/
	

	
	
	}
	
	
	
	/**private void loadLogin(){
		loginLink.setHref(loginInfo.getLoginUrl());
	}
	*/
}
