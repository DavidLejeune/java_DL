// Voorbeeld 1005  GridLayout
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Vb1005 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1005();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1005" );
    frame.setContentPane( new GridLayoutpaneel() );
    frame.setVisible( true );
  }
}


class GridLayoutpaneel extends JPanel {
  private JButton knop1, knop2, knop3,
                  knop4, knop5, knop6;
                  private JTextArea ta;
  
  public GridLayoutpaneel() {
    setLayout( new GridLayout( 2, 3, 15,15 ) );
    setBackground(Color.pink);
    
    // (optie)
    Border border = BorderFactory.createEmptyBorder( 5, 5, 5, 5 );
    setBorder( border );

    knop1= new JButton( "Component 1" );
    knop2= new JButton( "Component 2" );
    knop3= new JButton( "Component 3" );
    knop4= new JButton( "Component 4" );
    knop5= new JButton( "Component 5" );
    knop6= new JButton( "Component 6" );
    ta = new JTextArea (20,30);
    
    add( knop1 );
    add( knop2 );
    add( knop3 ); // je kan er eigenlijk meer toevoegen dan gedeclareerd, bvb
    				add (new JLabel("(c) Luc 2012"));
    				add( new JScrollPane(ta) );
    add( knop4 );
    add( knop5 );
    add (new JLabel("(c) Luc 2013"));
    add( knop6 );
    //add (new JLabel("(c) Luc 2013"));add (new JLabel("(c) Luc 2012"));add (new JLabel("(c) Luc 2012"));add (new JLabel("(c) Luc 2012"));
  }
} 
