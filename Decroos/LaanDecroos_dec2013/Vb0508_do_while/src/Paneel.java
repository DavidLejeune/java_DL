/* 
 * Naam : Luc Decroos - KHBO 
 * 
 * Beschrijving : do-while voorbeeld met slechte en goede code
 * 
 * probleem :
 * zet een random getal in een tekstvak met deze voorwaarden :
 *  - ligt tussen 1 en 100, 
 *  - moet oneven zijn, 
 *  - maar mag ook niet tussen 40 en 50 liggen (grenzen inbegrepen)
 *
 *
 */
 
import javax.swing.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Paneel extends JPanel {

  private JButton knop;
  private JTextField tekstvak;

  public Paneel() {
    knop = new JButton( "Knop" );
    knop.addActionListener( new KnopHandler() );
    tekstvak = new JTextField( 10 );
    add( knop );
    add( tekstvak );
  }
  
   class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       
       
       int getal=0;
       boolean ok = false;
       
       //verkeerde methode :
       
//       getal = (int) (1 + 100 * Math.random()); // heel zeker 1 .. 100
//       
//                                                       System.out.print(""+getal+" .. " );
//       ok = ( getal%2 != 0 ) && ((getal<40) || (getal > 50)); // de voorwaarden testen
//            //is oneven    én //ligt buiten bereik 40-50
//       if ( !ok ){ // als het niet goed is , bereken een ander getal = slechts 1 "herkansing"
//       	getal = (int) (1 + 100 * Math.random());
//       }
//                                                       System.out.println(""+getal);
//       tekstvak.setText(""+getal);
              
       //hoe moet het dan wel ?
       do{
       	  getal = (int) (1 + 100 * Math.random());
                                                         System.out.print(""+getal+" .. " );
       	  ok = (getal%2 !=0 ) && ((getal<40) || (getal > 50)); // de voorwaarden testen
       } while (!ok);
                                                         System.out.println("");
       tekstvak.setText(""+getal);
    }
    }
  }
