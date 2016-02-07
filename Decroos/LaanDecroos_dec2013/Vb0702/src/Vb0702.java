// Voorbeeld 0702  Lesrooster met uitvoer in een JTextArea
// uitgebreid met kopie van tekst uit JTextArea

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
   
public class Vb0702 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0702();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0702 Lesrooster" );
    frame.setContentPane( new Roosterpaneel() );
    frame.setVisible( true );
  }
}

class Roosterpaneel extends JPanel {
  private Lesrooster rooster,r2; // *** een extra rooster voor een andere klasgroep
  private JTextArea tekstgebied; // *** NIEUW
  private JButton knop, copyknop;
  private JTextField vakje;
  private String tekst = "";
  
  public Roosterpaneel() {
    // GUI Design
    tekstgebied = new JTextArea( 10, 30 );
    //deze beter niet gebruiken, werkt slechter !
    //tekstgebied.setPreferredSize(new Dimension (300,200));
    
    // add (tekstgebied); 
    // het kan zo .... maar beter is van het nog eens
    // in een JScrollPane zetten, dan krijg je schuifbalken indien nodig
    add( new JScrollPane( tekstgebied ) ); 
    
    knop = new JButton( "Rooster" );
    knop.addActionListener( new KnopHandler() );
    add( knop );
    
    copyknop = new JButton( "Kopieer" );
    copyknop.addActionListener( new CopyKnopHandler());
    add( copyknop );
    
    vakje = new JTextField(30);
    add( vakje );
    
    //andere zaken
    rooster = new Lesrooster("1AI1EO"); // *** gewijzigde Constructor gebruiken
  
    Les les = new Les( "Wiskunde", new Tijdstip( "dinsdag", 3 ), "A01" );
    rooster.voegtoe( les );
    
    les = new Les( "Informatica 1", new Tijdstip( "dinsdag", 5 ), "B401" );
    rooster.voegtoe( les );
    
    les = new Les( "Informatica 1", new Tijdstip( "dinsdag", 6 ), "B401" );
    rooster.voegtoe( les );
    
    //lesrooster voor andere klas
    r2 = new Lesrooster("2AI1EI"); // *** gewijzigde Constructor gebruiken
  
    les = new Les( "Wiskunde 3", new Tijdstip( "dinsdag", 6 ), "A01" );
    r2.voegtoe( les );
    
    les = new Les( "Informatica 3", new Tijdstip( "dinsdag", 8 ), "B401" );
    r2.voegtoe( les );
    
    les = new Les( "Informatica 3", new Tijdstip( "dinsdag", 4 ), "B401" );
    r2.voegtoe( les );
    
  }
   
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      // dit vervangt ALLE tekst in de JTextArea	
      //tekstgebied.setText( rooster.toString()+ "\n" );
      
      // dit voegt de tekst toe bij wat er reeds in staat
      tekstgebied.append( rooster.toString() + "\n");
      tekstgebied.append( r2.toString() + "\n");
    }
  }
  
  // EXTRA : kopieer geselecteerde tekst uit de JTextArea naar een JTextField
  class CopyKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
    	
      //als er iets in het tekstgebied staat ...
      if (!( tekstgebied.getText().equals ("") )){
      	
      	  // haal enkel de geselecteerde tekst op
          tekst = tekstgebied.getSelectedText();
      	
      	  // niets geselecteerd => nullpointer
      	  if ( tekst == null) vakje.setText( "je hebt niets geselecteerd");
      	  else {
      	  	    //optie : grapje  : tekst omkeren
      	  	StringBuffer bf = new StringBuffer(tekst);
      	  	bf.reverse();
      	  	tekst = bf.toString();
      	  	
      	  	vakje.setText(tekst); // was geldige tekst, zet in 2e vakje
      	  	// indien nodig ... "ont-selecteer" de geselecteerde tekst
      	    // tekstgebied.setSelectionEnd(0);
      	  }
      	}
      else {
      	vakje.setText( 	"er is niets om te kopieren !");
      }
    }
  }
  
  
}


  
