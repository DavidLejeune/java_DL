// Voorbeeld 0505  Tafel van 13
// for statement 
import javax.swing.*;
import java.awt.*;
   
public class Vb0505 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0505();
    frame.setSize( 500, 300);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0505" );
    frame.setContentPane( new TafelPaneel() );
    frame.setVisible( true );
  }
}

// Het paneel met proportionele letter, zoals in boek
class TafelPaneel extends JPanel {
  
  public TafelPaneel() {
    setBackground( Color.WHITE );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    String regel="test";
    int y = 15;
                  // zet eens i>0 .... oo lus !
                  // + Swing hertekent niet meer
    for( int i = 1; i<=10  ; i++ ) {
      regel =  i + " * 13 = " + i*13;
      g.drawString( regel, 10, y  );
      y  += 15 ;
      System.out.println(""+i);
      
    }
    System.out.println("Gedaan !");
    
  }
}



//// 2. Het paneel met niet-proportionele letter

class TafelPaneel2 extends JPanel {
  
  public TafelPaneel2() {
    setBackground( Color.WHITE );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.setFont( new Font( "Courier", Font.BOLD, 48 ) );
    g.setColor(Color.RED);
    String regel;
    int y = 50;

    for( int i = 1; i <= 10; i++ ) {
      regel = i + " * 13 = " + i*13;
      regel =  String.format( "%2d", i ) + " * 13 = " + String.format( "%3d", i*13 ); // gesplitst
      //regel = String.format( "%2d * 13 = %3d", i , i*13 );	// boek
      // g.setColor(new Color ((int) ( 16777216 * Math.random())));
      g.drawString( regel, 10, y ); // ipv y += 15 zoals in boek
      y  += 50 ;
      
    }
  }
}





 // eens tonen .... met JTable (maar is geen examenleerstof)
 
class TafelPaneel3 extends JPanel {
	
  public TafelPaneel3() {

    setBackground( Color.WHITE );
      // array's nodig = H8
	String[] namen = { "Getal" , "Macht" };
	String[][] data = new String[10][2];
	
	for (int i=1; i<=10; i++){
	  data[i-1][0] = "" + i;
	  data[i-1][1] = "" + (i*13);
	}

    JTable table = new JTable(data, namen);
	
	JScrollPane scrollPane = new JScrollPane(table,
	              JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    add (scrollPane);
  }
}