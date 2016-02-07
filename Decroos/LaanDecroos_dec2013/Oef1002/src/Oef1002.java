/**
 * @(#)Oef1002.java
 *
 * Oef1002 application
 *                  
 * @author Gertjan Laan, zie http://gertjanlaan.com/
 * @version 1.00 2011/3/13
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oef1002 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef1002();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef1002");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Tafelpaneel paneel = new Tafelpaneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Tafelpaneel extends JPanel {
  private Invoerpaneel invoerpaneel;
  private Tafelview tafelview;
  
  public Tafelpaneel() {
    setLayout( new BorderLayout( 2, 5 ) );
    tafelview = new Tafelview();
    invoerpaneel = new Invoerpaneel( tafelview );
    
    add( invoerpaneel, BorderLayout.NORTH );
    add( tafelview, BorderLayout.CENTER );
  }
}

class Invoerpaneel extends JPanel {
  private Tafelview tafelview;
  private JTextField tekstvak;
  private JLabel label;
  private Opgave opgave;
  
  public Invoerpaneel( Tafelview tafelview ) {
    this.tafelview = tafelview;
    opgave = tafelview.bepaalOpgave();
    
    setFont( new Font( "SansSerif", Font.BOLD, 14 ) );
    setLayout( new BoxLayout( this, BoxLayout.X_AXIS) );

    tekstvak = new JTextField( 8 );
    tekstvak.addActionListener( new VakHandler() );
    label = new JLabel();
    add( tekstvak );
    add( label );
  }


 class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      label.setText( "" );
      int antwoord = Integer.parseInt( tekstvak.getText() );
      if( antwoord == opgave.getUitkomst() ) {
        label.setForeground( Color.BLUE ) ;
        label.setText( "Prima!" );
      }
      else {
        label.setForeground( Color.BLUE ) ;
        label.setText( "Fout! " + 
                        opgave.getTweedeGetal() + "x" + 
                        opgave.getEersteGetal() + " = " + 
                        opgave.getUitkomst() );
      }
      
      tafelview.reset();
      tekstvak.setText( "" );
      opgave = tafelview.bepaalOpgave();
    }
  }
}
class Tafelknop extends JButton {
  public Tafelknop( int r, int k ) {
    super( " " + (k+1) + " x " + (r+1) + " " );
  }
}

class Opgave {
  private int eersteGetal, tweedeGetal;
  
  public Opgave( int eersteGetal, int tweedeGetal ) {
    this.eersteGetal = eersteGetal;
    this.tweedeGetal = tweedeGetal;
  }
  
  public int getEersteGetal() {
    return eersteGetal;
  }
  
  public int getTweedeGetal() {
    return tweedeGetal;
  }
  
  public int getUitkomst() {
    return eersteGetal * tweedeGetal;
  }
}


class Tafelview extends JPanel {
  private Tafelknop[][] knopTabel;
  private Color knopkleur, letterkleur;
  private int rij, kolom;
   
  public Tafelview() {
    setLayout( new GridLayout( 10, 10, 1, 1 ) );
    knopTabel = new Tafelknop[ 10 ][ 10 ];
    
    for( int r = 0; r < 10; r++ ) {
      for( int k = 0; k < 10; k++ ) {
        knopTabel[ r ][ k ] = new Tafelknop( r, k );
        add( knopTabel[ r ][ k ] );
      }
    }
    knopkleur = Color.LIGHT_GRAY;
    letterkleur = knopTabel[ 0 ][ 0].getForeground();
  }

  public Opgave bepaalOpgave() {
    rij = (int) ( 10 * Math.random() );
    kolom = (int) ( 10 * Math.random() );
    knopTabel[ rij ][ kolom ].setBackground( Color.RED );
    knopTabel[ rij ][ kolom ].setForeground( Color.WHITE );
    int eersteGetal = rij + 1;
    int tweedeGetal = kolom + 1;
    return new Opgave( eersteGetal, tweedeGetal );
  }    
  
 public void reset() {
    knopTabel[ rij ][ kolom ].setBackground( knopkleur );
    knopTabel[ rij ][ kolom ].setForeground( letterkleur );
  }
}
