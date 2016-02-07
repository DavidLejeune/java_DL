// Voorbeeld 1007  Zes panelen met verschillende lay-out
import java.awt.*;
import javax.swing.*;

public class Vb1007 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1007();
    frame.setSize( 380, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1007  Panelen met verschillende lay-out" );
    frame.setContentPane( new LayoutDemopaneel() );
    frame.setVisible( true );
  }
}

class LayoutDemopaneel extends JPanel {
  JPanel paneelNoord, paneelZuid, paneelWest, paneelOost, paneelCentrum;

  public LayoutDemopaneel() {
    // Geef dit paneel een BorderLayout
    setLayout( new BorderLayout() );

    // Maak vijf panelen
    paneelNoord   = new JPanel();
    paneelZuid    = new JPanel();
    paneelWest    = new JPanel();
    paneelOost    = new JPanel();
    paneelCentrum = new JPanel();
    
    // Geef elk paneel een andere layout
    paneelNoord.setLayout( new GridLayout( 1, 3 ) );
    paneelZuid.setLayout(  new BoxLayout( paneelZuid, BoxLayout.X_AXIS ) );
    paneelWest.setLayout(  new GridLayout( 3,1 ) );
    paneelOost.setLayout(  new BoxLayout( paneelOost, BoxLayout.Y_AXIS ) );
    
    // Vul de panelen met componenten
    paneelNoord.add( new JButton( "noord1" ) );
    paneelNoord.add( new JButton( "noord2" ) );
    paneelNoord.add( new JButton( "noord3" ) );

    
    Component hGlue = Box.createHorizontalGlue(); // geen afmeting nodig, duwt ze zelf uit elkaar
    paneelZuid.add( new JButton( "zuid1" ) );
    //paneelZuid.add( hGlue ); //twee glue werkt niet
    paneelZuid.add( new JButton( "zuid2" ) );
    paneelZuid.add( hGlue );//*** extra : een Glue ertussen
    paneelZuid.add( new JButton( "zuid3" ) );
    
    paneelWest.add( new JButton( "west1" ) );
    paneelWest.add( new JButton( "west2" ) );
    paneelWest.add( new JButton( "west3" ) );
    
    paneelOost.add( new JButton( "oost1" ) );
    paneelOost.add( new JButton( "oost2" ) );
    paneelOost.add( new JButton( "oost3" ) );
    
    paneelCentrum.add( new JButton( "centrum1" ) );
    paneelCentrum.add( new JButton( "centrum2" ) );
    paneelCentrum.add( new JButton( "centrum3" ) );

    add( paneelNoord,   BorderLayout.NORTH );
    add( paneelZuid,    BorderLayout.SOUTH );
    add( paneelWest,    BorderLayout.WEST );
    add( paneelOost,    BorderLayout.EAST );
    add( paneelCentrum, BorderLayout.CENTER );
  }
}
