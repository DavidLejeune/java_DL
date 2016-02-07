// Schrijven en lezen van een object
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Vb1408 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1408();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setBounds( 100, 100, 350, 200 );
    frame.setTitle( "Object schrijven en lezen met een stream" );
    frame.setContentPane( new Persoonpaneel() );
    frame.setVisible( true );
  }
}

class Persoonpaneel extends JPanel {
  private Persoon kind;
  private Persoon ingelezenKind;

  public Persoonpaneel() {
    // Schrijven van object
    try {
      ObjectOutputStream uit =
        new ObjectOutputStream( 
          new FileOutputStream( "c:/temp/persoon.dat" )
        );

      kind = new Persoon( "Charlotte", new Datum( 1,11,1994 ), 3.1 );
      uit.writeObject( kind );
      uit.close();
    }
    catch( IOException e ) {
      System.out.println( "IO-exceptie" );
    }
    

    // Lezen van object
    try {
      ObjectInputStream in = 
        new ObjectInputStream(
          new FileInputStream( "c:/temp/persoon.dat" )
      );
      // nu object inlezen, maar ... je MOET TYPECASTEN :
      ingelezenKind = (Persoon) in.readObject();
      in.close();
    }
    catch( ClassNotFoundException e ) {
      System.out.println( "Onbekende klasse" );
    }
    catch( IOException e ) {
      System.out.println( "IO-exceptie" );
    }
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "Object is geschreven en teruggelezen :", 50, 50 );
    g.drawString( ingelezenKind.toString(), 50, 80 );
  }
}
