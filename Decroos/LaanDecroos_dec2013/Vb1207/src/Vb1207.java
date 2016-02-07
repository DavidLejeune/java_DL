// Voorbeeld 1207 Laten zien van de call-stack met printStackTrace()
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1207 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1207();
    frame.setSize( 400, 150 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1207  De call stack met printStackTrace()" );
    frame.setContentPane( new CallStackpaneel() );
    frame.setVisible( true );
  }
}


class CallStackpaneel extends JPanel {  
  public CallStackpaneel() {
    try {
      test1();
    }
    catch( RuntimeException re ) {
      System.out.println( "Dit is de stack-trace:" );
      re.printStackTrace();
    }
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "Call-stack staat in console-venster.", 20, 20 );
  }
  
  public void test1() {
    test2();
  }   

  public void test2() {
    throw new RuntimeException();
  }
}
