package com.hdm.itprojekt.client.gui;

import com.google.gwt.user.client.ui.*;


/**
 * Basis Klasse aller Showcases.Jeder Showcase ist ein VerticalPanel.
 * @author sinakoritko
 *
 */

public abstract class Update extends VerticalPanel {

	/**
	 * Jedes GWT Widget muss diese Methode implementieren. 
	 * Sie gibt an, was geschehen osll, wenn Widget Instanz zur Anzeige gebracht wird.
	 */
	
	public void onLoad(){
		
		/**
		 * Bevor wir unsere eigene Formatierung veranslassen, überlassen wir es
		 * der Superklasse eine Initialisierung vorzunehmen.
		 */
		super.onLoad();

		/**
		 * Als erstes geben wir stets die Headline des Showcase aus. Da
		 * getHeadlineText() als abstrakte Methode bzw. als Einschubmethode
		 * realisiert wird, obliegt es den Subklassen, für eine Ausgestaltung
		 * also Implementierung zu sorgen.
		 */
		this.add(this.createHeadline(this.getHeadlineText()));
		
		/**
		 * Wenn alles vorbereitet ist, stoßen wir die run()-Methode an. Auch
		 * run() ist als abstrakte Methode bzw. als Einschubmethode realisiert.
		 * Auch hier ist es Aufgabe der Subklassen, für deren Implementierung
		 * zu sorgen.
		 */
		this.run();
		
	}
	
	/**
	 * Mit Hilfe dieser Methode erstellen wir aus einem String ein mittels CSS
	 * formatierbares HTML-Element. Unter CSS lässt sich das Ergebnis über
	 * <code>.notebee-headline</code> referenzieren bzw. formatieren.
	 */
	protected HTML createHeadline(String text) {
		HTML content = new HTML(text);
		content.setStylePrimaryName("notebee-headline");
		return content;
	}
	
	/**
	 * Mit Hilfe dieser Methode erstellen wir aus einem Strinng ein mittels CSS
	 * formatierbares HTML-Element, das an das Ende der bisherigen Ausgabe
	 * dieses Showcase angehängt wird. Unter CSS lässt sich das Ergebnis über
	 * <code>.notebee-simpletext</code> referenzieren bzw. formatieren.
	 */
	protected void append(String text) {
		HTML content = new HTML(text);
		content.setStylePrimaryName("notebee-simpletext");
		this.add(content);
	}
	
	/**
	 * Abstrakte Einschubmethode, die in den Subklassen zu realisieren ist.
	 * 
	 * @return der Text, den wir als Headline setzen wollen.
	 */
	protected abstract String getHeadlineText();

	
	/**
	 * Abstrakte Einschubmethode, die in den Subklassen zu realisieren ist.
	 */
	protected abstract void run();
}


