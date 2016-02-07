/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Gegevens {
        // attributen
	private String naam ;
	private String klas ;
	private String jaar ;    // enz voor méér gegevens .... zelf uitbreiden
	
	// Constructor
	public Gegevens ( String naam, String klas, String jaar ){
		this.naam = naam;
		this.klas = klas;
		this.jaar = jaar;
	}
	

	public void setNaam (String naam){
		this.naam = naam;
	}
	public String getNaam(){
		return naam;
	}

	public void setKlas (String klas){
		this.klas = klas;
	}
	public String getKlas(){
		return klas;
	}

	public void setJaar (String jaar){
		this.jaar = jaar;
	}
	public String getJaar(){
		return jaar;
	}	
	// toString() methode, volstaat voorlopig om de gegevens zichtbaar te maken
	public String toString(){
		//String tekst = String.format ("" , naam, klas, jaar);
		String tekst = ("" + naam + "," + klas + "," + jaar);
		return tekst;
	}
        }



