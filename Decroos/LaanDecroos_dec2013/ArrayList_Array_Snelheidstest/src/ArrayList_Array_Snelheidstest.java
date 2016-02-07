/**
 * @(#)ArrayList_Array_Snelheidstest.java
 *
 * ArrayList_Array_Snelheidstest application
 *                  <vul hier steeds je voornaam - naam - klas in> !!!
 * @author Voornaam Naam - Klas
 * @version 1.00 2012/10/10
 *
 * Welk is het snelste, array of ArrayList ?
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
// eventueel extra imports hier

public class ArrayList_Array_Snelheidstest extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new ArrayList_Array_Snelheidstest();
       frame.setSize(800,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("ArrayList_Array_Snelheidstest");
       frame.setLocationRelativeTo(null);
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private ArrayList<String> lijst;
  private String[] tabel;
    
  int     aantal = 374;
  long t1,t2,t3,t4,delta1,delta2;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel ("Zijn ArrayList en array even snel ? Kom het hier te weten >> ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Start" );
    knop.addActionListener( new KnopHandler() );
    
    lijst = new ArrayList();
    tabel = new String[aantal];
    // lijst en tabel opvullen met afkortingen
    doe_ze_maar_eens_vol();
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    //add( tekstvak );
  }
  
  public void doe_ze_maar_eens_vol(){
  	 try{
        int aantal = 0;
        String regel = "";
        BufferedReader bestand= new BufferedReader (new FileReader("afkortingen.txt"));           
        
            // alle Strings binnenlezen, afkorting afsplitsen 
            // en opbergen in lijst én tabel 
        while ((regel = bestand.readLine()) != null){
                // verwerking van 1 regel  
                String[] temp = regel.split("\\*"); 
                lijst.add( temp[0] );
                tabel[aantal] = temp[0];
                aantal++;
        }
        System.out.println ("Aantal gelezen afkortingen : " + aantal);
        bestand.close(); 
     }
     catch (EOFException e){
         System.out.println ("Onverwacht einde van bestand !");   
     }
     catch (IOException e) {
          System.out.println ("FOUT - Kon bestand niet openen !"); 
     }
   }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      g.setFont(new Font("Monospaced", Font.BOLD, 14));
      g.drawString("ArrayList had " + delta1 + " ms nodig",50,50);
      
      g.drawString("array     had " + delta2 + " ms nodig",50,100);
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       int r = 0;
       String afkorting = "";
       
       t1 = System.currentTimeMillis();
       for (int i = 0;i<10000000;i++){
       	  r = (int) ( 374 * Math.random());
       	  afkorting = lijst.get(r);
       }
       t2 = System.currentTimeMillis();
       delta1 = t2 - t1;
       System.out.println ("ArrayList getest");
       
       t3 = System.currentTimeMillis();
       for (int i = 0;i<10000000;i++){
       	  r = (int) ( 374 * Math.random());
       	  afkorting = tabel[r];
       }
       t4 = System.currentTimeMillis();
       delta2 = t4 - t3;
       
       System.out.println ("array ook getest");
       

       repaint();
    }
  }
 
  
}