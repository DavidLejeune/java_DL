// Voorbeeld 0506  Cirkels
// for statement
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class Vb0506 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0506();
    frame.setSize( 600, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0506 Cirkels" );
    frame.setContentPane( new CirkelPaneel() );
    frame.setVisible( true );
  }
}

 
class CirkelPaneel extends JPanel {
  private JTextField invoerVak;
  private int aantal;
  
  public CirkelPaneel() {
    setBackground( Color.WHITE );
    invoerVak = new JTextField( 10 );
    invoerVak.addActionListener( new InvoerVakHandler() );
    
    add( new JLabel( "Voer aantal in" ) );
    add( invoerVak );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    int i_kopie = 0;
    g.setColor( Color.red );
    
    for(int i = 1; i <= aantal; i+=1 ) {
      g.drawOval( 50, 50, 20 + 5*i, 20 + 5*i );
      i_kopie = i;
    }
    
    System.out.println("teller i = " + i_kopie);   
  }
  
  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      aantal = Integer.parseInt( invoer );
      repaint();
    }
  }
}

