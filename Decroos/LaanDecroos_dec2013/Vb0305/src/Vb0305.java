// Voorbeeld 0305
// Applicatie die een driehoek tekent
import javax.swing.*;
import java.awt.*;   
   
public class Vb0305 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0305();
    frame.setSize( 500, 300 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0305" );
    frame.setContentPane( new Tekenpaneel2() );
    frame.setVisible( true );
  }
}


// ORIGINEEL uit BOEK
class Tekenpaneel extends JPanel {
 
  public Tekenpaneel() {
    setBackground( Color.WHITE );
  }

  public void paintComponent( Graphics g ) {
    // paneel wordt gewist
    super.paintComponent( g );
    // vanaf hier begint het eigenlijke tekenen
    g.drawLine( 140, 40, 220, 220 );
    g.drawLine( 220, 220, 270, 70 );
    g.drawLine( 270, 70, 140, 40 );
  }
}

// met uitbreidingen ...

class Tekenpaneel2 extends JPanel {
 
  public Tekenpaneel2() {
    setBackground( Color.YELLOW );
  }

  public void paintComponent( Graphics g ) {
    // paneel wordt gewist
    super.paintComponent( g );
    
    // mag ook hier nog :
    setBackground ( Color.CYAN );
    
    // vanaf hier begint het eigenlijke tekenen
    g.setColor( Color.BLUE );
    g.drawLine( 140, 40, 220, 220 );
    g.setColor( Color.RED );
    g.drawLine( 220, 220, 270, 70 );
    g.setColor( Color.GREEN );
    g.drawLine( 270, 70, 140, 40 );
    // optie : een x-as erbij
    g.setColor( Color.black );
    g.drawLine( 10,140, 390,140 );
    g.drawString ( "X" , 385 ,  155);
    // enz ...
  }
}


 //met nog meer uitbreidingen ...

class Tekenpaneel3 extends JPanel {
  private Color mijnkleur;
  
  public Tekenpaneel3() {
    //setBackground( Color.YELLOW );
    setBackground( new Color (100,20,30) );
    mijnkleur = new Color( 162,201,44 );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.setColor( mijnkleur );
    g.drawLine( 20, 20, 200, 100 );
    g.setColor( Color.BLUE );
    g.drawLine( 40, 40, 220, 120 );
  }
}

