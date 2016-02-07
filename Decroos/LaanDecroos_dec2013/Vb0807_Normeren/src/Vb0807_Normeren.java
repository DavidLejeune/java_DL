/**
 * @(#)Vb0807_Normeren.java
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Vb0807_Normeren extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0807_Normeren();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0807_Normeren");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel label,label2;
  private JTextField vak,vak2;      // invoer , cumulatief gemiddelde
  private JButton knop, clearknop;  // normeer
  private JTextArea ta;             // uitvoer genormeerde getallen 
    
    // primitieve variabelen
  double getal,normgetal,som=0,gemiddelde;
    
  int aantal=0;
             
    
  double[] tabel; // array voor getallen, gevuld met nullen
 
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" NORMEREN : voer getallen in en druk telkens enter ");	  
	label2 = new JLabel (" Cumulatief gemiddelde = ");	  
	vak = new JTextField( 12 );
    vak.addActionListener (new EnterHandler());
      
    vak2 = new JTextField( 12 );
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Normeer" );
    knop.addActionListener( new KnopHandler() );
    
    clearknop = new JButton( "Reset" );
    clearknop.addActionListener( new ClearKnopHandler() );
    
    ta = new JTextArea(20,40);
    ta.setBounds(50,150,650,450);
    
    add(label);
    add(vak);
    add(label2);
    add(vak2);
    add(knop);
    add(new JScrollPane(ta));
    add(clearknop);
    
    tabel = new double[1000];
	
  }
  
      // interne klassen voor event-handlers
      
	                          // invoer & opslag in een array
	class EnterHandler implements ActionListener {  
      public void actionPerformed( ActionEvent e ) {
      	
      	getal = Double.parseDouble(vak.getText());     
      	
      	tabel [aantal] = getal;
      	aantal++;
      	
      	som += getal;
      	
      	gemiddelde = som/aantal;
      	vak2.setText("" + gemiddelde);
      	
      	vak.setText("");
      }
    }      
 							// waarden normeren en weergeven
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
     	for (int i = 0 ; i<aantal ; i++) {
      	      getal = tabel[i];
      	      ta.append ("" + getal + " = " + getal/gemiddelde + " maal het gemiddelde\n");
      	    } 
    }
  }
  
  class ClearKnopHandler implements ActionListener {
      public void actionPerformed( ActionEvent e ) { 
      som = 0; aantal = 0;
      ta.setText("");
      vak2.setText("");
      vak.setText("");
      
      }}
}