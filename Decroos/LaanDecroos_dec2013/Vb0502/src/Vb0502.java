// Voorbeeld 0502
// Hybride programma : invoer op paneel, uitvoer in DOS-venster
import javax.swing.*;
import java.awt.event.*;
   
public class Vb0502 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0502();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0502" );
    frame.setContentPane( new CijferPaneel() );
    frame.setVisible( true );
  }
}


// Het paneel 
class CijferPaneel extends JPanel {
  private JLabel label;
  private JTextField tekstvak;
  private double cijfer;
  
  public CijferPaneel() {
    label = new JLabel( "Voer een cijfer in" );
    tekstvak = new JTextField( 10 );
    tekstvak.addActionListener( new TekstvakHandler() );
    add( label );
    add( tekstvak );
  }
  
  class TekstvakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      
      cijfer = Double.parseDouble(tekstvak.getText() );
      
      System.out.println( "Het ingevoerde cijfer is: " + cijfer );
      
      if( cijfer >= 5 ){
      	 System.out.println( "Dat is een voldoende" );       
         // EXTRA TEST (p 107)
         if (cijfer >= 8 ){
         	System.out.println( "Dat is zelfs uitstekend" );
         	System.out.println( "Je krijgt een bonus" );
         	
         }
        	
         
      }
      
      
      
      
      
      System.out.println(); //lege lijn
      
      System.out.println( "Dank u!" );
      tekstvak.setText("");
      
    }
  }
}

/*
 *        if (cijfer >= 8 ) {
        	System.out.println( "Dat is zelfs uitstekend" );
        	System.out.println( "Je krijgt een bonus" );
        }*/