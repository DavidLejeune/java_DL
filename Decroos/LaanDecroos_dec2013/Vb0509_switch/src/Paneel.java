/* 
 * Naam : Luc Decroos - KHBO 2007
 * 
 * Beschrijving : Maanden : demo van switch statement (staat niet in boek)
 * 
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paneel extends JPanel {
  private JTextField tekstvak1, tekstvak2;
 
    // Constructor
  public Paneel() {
    tekstvak1 = new JTextField( 5 );
    tekstvak1.addActionListener( new VakHandler() );
    tekstvak2 = new JTextField( 30 );
    add( tekstvak1 );
    add( tekstvak2 );
  }
  
      // interne klasse voor event-handler
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // lees getal in 
       String invoer = tekstvak1.getText();
       String naam ="";
       int getal=0;
		    // als het invoervakje niet leeg was ...
       if (!invoer.equals("")) getal = Integer.parseInt( invoer );
                 // anders NumberFormatException met lege String !
       switch (getal) {    // de juiste maand kiezen
			    case 0:  naam = "";         break;  // lege maand
  				case 1:  naam = "januari";  break;
  				case 2:  naam = "februari"; break;
  				case 3:  naam = "maart"; 	break;
  				case 4:  naam = "april"; 	break;
  				case 5:  naam = "mei"; 		break;
  				case 6:  naam = "juni"; 	break;
  				case 7:  naam = "juli"; 	break;
 				case 8:  naam = "augustus"; break;				
 					//case 7: case 8: naam = "vakantie !!"; break;
				case 9:  naam = "september";break;
  				case 10: naam = "oktober";  break;
  				case 11: naam = "november"; break;
		  		case 12: naam = "december"; break;  
		  		default : naam = "is niet geldig, koop eens een kalender !";
		  		          tekstvak1.setBackground(Color.black);
		  		          // break hoeft niet, 't is toch gedaan ...
  		}                 // default moet er wel staan, laat het eens weg ...

  		if ( !naam.equals("")){      // enkel iets afdrukken indien geldig !
  			tekstvak2.setText("Maand " + getal + " , dat is " + naam);
  			tekstvak1.setText("");
  		}
    }
  }
  
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      g.drawString("Tik een getal tussen 1 en 12,gevolgd door <Enter>",10,50);
	  g.drawString("Ik zoek voor jou welke maand dat is.",10,80);
  }
}