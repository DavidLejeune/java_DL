// Voorbeeld 0401 Extra
// een groot en een klein double getal optellen : afrondingsfouten
// bij het converteren van/naar binaire voorstelling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
   
public class Vb0401_Extra extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0401_Extra();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0401 Extra" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

class Paneel extends JPanel{

  public Paneel(){
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );

    double getal1 = 1.2345e15;  // een groot getal (probeer ook met e15 : wel correct !)
    double getal2 = 1.0;          // een klein getal (t.o.v. groot getal)
    
    g.drawString("groot (getal1) = " + getal1 , 10, 20);
    g.drawString("klein (getal2) = " + getal2 , 10, 40);
    
    double som = getal1 + getal2;
    g.drawString("de som van beide =" + som, 10,60);
    
    som = som - getal1; // groot getal er terug af
    
    g.drawString("origineel getal2 (= som - getal1) = " + som, 10,80);
    
  }
  
}
