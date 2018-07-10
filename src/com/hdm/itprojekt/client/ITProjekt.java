package com.hdm.itprojekt.client;

import com.hdm.itprojekt.shared.bo.Note;
//import com.hdm.itprojekt.client.ClientsideSettings;
//import com.hdm.itprojekt.client.gui.LoginService;
//import com.hdm.itprojekt.client.gui.LoginServiceAsync;
//import com.hdm.itprojekt.shared.LoginInfo;
//import com.hdm.itprojekt.shared.NoteAdministrationAsync;
import com.hdm.itprojekt.shared.bo.User;
import com.hdm.itprojekt.client.gui.Update;
import com.hdm.itprojekt.shared.FieldVerifier;
import com.hdm.itprojekt.shared.NoteAdministration;
import com.hdm.itprojekt.shared.NoteAdministrationAsync;
import com.hdm.itprojekt.shared.bo.User;
import com.hdm.itprojekt.client.gui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.core.java.util.Arrays;
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
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel.NodeInfo;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ITProjekt implements EntryPoint {
	
	
	
	LoginServiceAsync loginService = GWT.create(LoginService.class);
	private LoginInfo loginInfo = null;
	
	private static NoteAdministrationAsync administrationService = GWT.create(NoteAdministration.class);
	
	private User currentUser = null;
	private Note selectedNote = null;
	
	
	NoteCell noteCell = new NoteCell();
	CellList<Note> cellList = new CellList<Note>(noteCell, keyProvider);
	
	
	public static ListDataProvider<Note> dataProvider = new ListDataProvider<Note>();
	
	private ArrayList<Note> notes = null;
	
	
	static ProvidesKey<Note> keyProvider = new ProvidesKey<Note>(){
		public Object getKey(Note item){
			//null check
			return(item==null) ? null : item.getNoteID();
		}
	};
	
	private SingleSelectionModel<Note> selectionModel = new SingleSelectionModel<Note>(keyProvider);
	
	
	//DataProvider erstellen
	
	
	public static List<Note> noteList = dataProvider.getList();
	
	
	
	
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel header = new HorizontalPanel();
	private VerticalPanel contentPanel = new VerticalPanel();
	private VerticalPanel navigationPanel = new VerticalPanel();
	private VerticalPanel navXtraPanel = new VerticalPanel();
	private HorizontalPanel footer = new HorizontalPanel();
	
	private Label logo = new Label("Notebee");
	private Label usernameLabel = new Label ();
	private Button createNoteBtn = new Button("new note");
	private Anchor loginLink = new Anchor("login");
	private Anchor logoutLink = new Anchor("logout");
	private Label copyright = new Label("(c) Hochschule der Medien, Sina Koritko");
	//final CellList<String> noteCellList = new CellList<String>(noteCell);
	//final CellList<Note> nCellList = new CellList<Note>(nCell, keyProvider);
	final Label noteLabel = new Label();
	
	
	
	
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
//	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	
		
		
		//Login Status abfragen mit Hilfe des Login Service
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {
				Window.alert("Login Fehler");
			}
			
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				ClientsideSettings.setLoginInfo(result);
				if(loginInfo.isLoggedIn()) {
					loadView();	
				}
				else {
					loadLogin();
				}
			}

		
		});
		
	}
	
	public void loadLogin(){
		loginLink.setHref(loginInfo.getLoginUrl());
		
		loginLink.setStyleName("loginLink");
		logo.setStyleName("logo");
		header.setStyleName("header");
		footer.setStyleName("footer");
		copyright.setStyleName("copyright");
		
		header.add(logo);
		header.add(loginLink);
		footer.add(copyright);
		
		RootPanel.get("header").add(header);
		RootPanel.get("contentBox").add(contentPanel);			
		RootPanel.get("navigation").add(navigationPanel);
		RootPanel.get("footer").add(footer);
		
		
		}
		


		
	
		
	
	
	
	
		
		public void loadView(){
			
			//Auslesen aktuelles Benutzerprofil aus Datenbank
			
			administrationService.getUserByMail(ClientsideSettings.getLoginInfo().getMail(), getCurrentUserCallback());
			
			
			
			
			/**noteCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);*/
		
			//Add selection model to handle user selection
			
			/**noteCellList.setSelectionModel(noteSelectionModel); */

			//Connect list to data provider
			
			/**noteDataProvider.addDataDisplay(noteCellList);*/
			
		//	nCellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		//	nCellList.setSelectionModel(nSelectionModel);
		
			//Conenct list to data provider
		//	noteDataProvider.addDataDisplay(nCellList);	
			
			
		createNoteBtn.addStyleName("createNoteBtn");
		logoutLink.setStyleName("loginLink");
		logo.setStyleName("logo");
		usernameLabel.setStyleName("displayUsername");
		header.setStyleName("header");
		footer.setStyleName("footer");
		copyright.setStyleName("copyright");
		createNoteBtn.setStyleName("btns");
		noteLabel.setStyleName("noteLabel");
		cellList.setStyleName("cellList");
		
		/**Zuteilung der Widgets zum jeweiligen Panel
		 * */
	
		
		

		
		header.add(logo);
		header.add(usernameLabel);
		header.add(logoutLink);
		logoutLink.setHref(loginInfo.getLogoutUrl());
		
		navigationPanel.add(createNoteBtn);
		navigationPanel.add(noteLabel);
		noteLabel.setText("Waehle eine Notiz aus:");
		navigationPanel.add(cellList);
		dataProvider.addDataDisplay(cellList);
		
		footer.add(copyright);
		


		/**
		 * Associate main panel with HTML host page
		 */
		
		
		RootPanel.get("header").add(header);
		RootPanel.get("contentBox").add(contentPanel);			
		RootPanel.get("navigation").add(navigationPanel);
		//RootPanel.get("navigation").add(navPanel);
		RootPanel.get("footer").add(footer);
		
		
		  /**
	     * Implementierung der jeweiligen ClickHandler fuer die einzelnen Widgets
	     */
		
		/**
		noteSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){
			public void onSelectionChange(SelectionChangeEvent event){
				Update update = new EditNoteView();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
			}
		});
		*/
		
		//List<Note> list = dataProvider.getList();
	//	list.add(note);
		
		
			administrationService.getNotesOfUser(currentUser, new AsyncCallback<ArrayList<Note>>(){

			@Override
			public void onFailure(Throwable caught) {
				
				
			}

			@Override
			public void onSuccess(ArrayList<Note> result) {
				for (Note n : result) {
					dataProvider.getList().add(n);
				}
				
			}
			
		});
		
		
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){
			public void onSelectionChange(SelectionChangeEvent event) {
				
				Note selection = selectionModel.getSelectedObject();
				if(selection instanceof Note){
					setSelectedNote((Note) selection);
				}
						
				/**
				Update update = new EditNoteView();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
				*/
			}
		});
		
		
		
		createNoteBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Showcase/update instantiieren
				Update update = new CreateNoteView();
				RootPanel.get("contentBox").clear();
				RootPanel.get("contentBox").add(update);
			}
		});

		
		
	

	
	
	}
	
	
	
	
	
	
	private AsyncCallback<User> getCurrentUserCallback(){
		AsyncCallback<User> asyncCallback = new AsyncCallback<User>(){

			@Override
			public void onFailure(Throwable caught) {
				ClientsideSettings.getLogger().severe("Error: " + caught.getMessage());
			}

			@Override
			public void onSuccess(User result) {
				ClientsideSettings.getLogger().severe("Success GetCurrentUserCallback: " + result.getClass().getSimpleName());
				currentUser = result;
				
				usernameLabel.setText(currentUser.getMail());
				Update update = new NoteOverview();
				RootPanel.get("contentBox").add(update);
				
				administrationService.getNotesOfUser(currentUser, new GetNotesOfUserCallback());		
			}
		};
		return asyncCallback;
	}

	public Note getSelectedNote() {
		return selectedNote;
	}

	public void setSelectedNote(Note selectedNote) {
		this.selectedNote = selectedNote;
	}
	
	
	
	private  class GetNotesOfUserCallback implements AsyncCallback<ArrayList<Note>>{

			@Override
			public void onFailure(Throwable caught) {
				ClientsideSettings.getLogger().severe("Error: " + caught.getMessage());
			}

			@Override
			public void onSuccess(ArrayList<Note> result) {
				ClientsideSettings.getLogger().severe("Success GetNotesOfUserCallback: " + result.getClass().getSimpleName());
				notes = result;
				dataProvider.getList().clear();
				for(int i = 0; i < notes.size(); i++){
					dataProvider.getList().add(notes.get(i));
				}
		};

	}
	
	
}
