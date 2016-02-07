/**
 * @(#)Vb1005_BigGrid.java
 *
 * Vb1005_BigGrid application
  * @author Luc Decroos - KHBO
 * @version 1.00 2008/3/19
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Vb1005_BigGrid extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1005_BigGrid();
       frame.setSize(400,400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1005_BigGrid");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       //frame.setContentPane( new JScrollPane (paneel) );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
       
    // referenties naar objecten 
  
  int dim = 5; // indien niet vierkant : gebruik dimv en dimh
  private JButton[][] knoppenGrid; // 2D-array van knoppen !
  private KnopHandler kh; 
  
    // Constructor
  public Paneel() {
	
	setLayout( new GridLayout( dim , dim , 5,5) ); 
	
	knoppenGrid = new JButton[dim][dim];
	kh = new KnopHandler(); // 1 knophandler ipv een hele hoop ...
	
	for (int rij=0; rij<dim; rij++)
		for (int kolom=0; kolom<dim; kolom++){
			// bevat de POINTERS
			// naar alle knoppen      
			knoppenGrid[rij][kolom] = maakKnop (rij,kolom);
			                          //gebruik de factory method !
    	}
  }

   // factory method
  public JButton maakKnop( int rij, int kolom ) {
    JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
    knop.setBackground( Color.green );
    knop.addActionListener( kh ); // alle knoppen dezelfde knophandler
      // zet hier NIET ...( new KnopHandler()) ==> 25 instanties !
    add( knop );
    return knop; // stuur ref terug om in array op te bergen
  }
      
  
      // speciaal : 1 knophandler voor ALLE knoppen, hoeveel er ook zijn !
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       
       // doe iets met de knoppen (andere kleur + delay) 
       
//       	for (int rij=0; rij<dim; rij++)
//       		for (int kolom=0; kolom<dim; kolom++){ 
//       			if (e.getSource() == knoppenGrid[rij][kolom] ){ // dan was het die knop waarop je geklikt had
//       			    // doe dan iets leuks ....
//       			    knoppenGrid[rij][kolom].setBackground (Color.red);validate();
//       			    slaap(1000);
//       			    knoppenGrid[rij][kolom].setBackground (Color.green);
//       			}
//       		}
       		
       		
        // of iets anders (ON/OFF = toggle functie)
        // overloop al je knoppen ....
        for (int rij=0; rij<dim; rij++)
       		for (int kolom=0; kolom<dim; kolom++){ 
       			if (e.getSource() == knoppenGrid[rij][kolom] ){ // dan was het die knop waarop je geklikt had
       			    // doe dan iets leuks ....
       			    if (knoppenGrid[rij][kolom].getBackground().equals (Color.green)) 
       			    	knoppenGrid[rij][kolom].setBackground (Color.red);
       			    else knoppenGrid[rij][kolom].setBackground (Color.green);
       			}
       		} 		
      		
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}