// Voorbeeld 0201
// Opstartklasse voor een applicatie

import javax.swing.*;
             
public class Vb0201 extends JFrame
{ // deze klasse heeft geen (extra) attributen
  // ... en telt slechts 1 methode : main()
  
  public static void main( String[] commandLineArguments ) // kop van een methode
  
  { // body van een methode = de opdrachten ervan
  
    // Maak een venster
    Vb0201 venster;  		// stap 1 : declareer een referentie
    
    venster = new Vb0201(); // stap 2 : een instantie maken (de Constructor oproepen)
    
    						// stap 3 : allerlei initialisaties
    venster.setSize( 400, 200 );
    venster.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    venster.setTitle( "Mooi hee !" );
    		// extra opdrachten --> zoeken via de index in klasse JFrame
    venster.setResizable(false); // vaste grootte
    venster.setAlwaysOnTop(true); // venster steeds zichtbaar
    
    //venster.setLocation(200,150); // zet positie hoek linksboven
    venster.setLocationRelativeTo(null); // zet in het midden v/h scherm
    
    venster.setVisible( true );
  }  // einde van de body = ook einde van de methode
  
}
