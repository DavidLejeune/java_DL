/**
 * @(#)GUI_ThreadDemo.java
 *
 * GUI_ThreadDemo application
 *                  <vul hier steeds je voornaam - naam - klas in> !!!
 * @author Voornaam Naam - Klas
 * @version 1.00 2009/10/9
 *
 * Beschrijving : (vervang door je eigen beschrijving) !!!
 * Een standaard-programma met een paneel met een knop, 
 * tekstvak en event-afhandeling, aan te passen naargelang
 * wat je nodig hebt ...
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI_ThreadDemo extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new GUI_ThreadDemo();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("GUI_ThreadDemo");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    private JTextArea ta ;
    private JTextField vak;
    private Tellertje t;  // een thread-object
    private boolean chat = true;
    private Timer timer;
    
    // Constructor
    public Paneel() {
		ta = new JTextArea(24,60);
        ta.setEditable(false); // je mag er niet in typen
              
        vak = new JTextField (60);
        vak.addActionListener(new VakHandler());
       
        add(new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        add(vak);     
       
        t = new Tellertje (ta); // thread maken en starten
        t.start();
        
        
        timer = new Timer (60000, new TimerHandler() ); // max 1 minuut chatten
        timer.start();
        System.out.println("Timer loopt");
    
  }
     
 
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String input = vak.getText();
      if (chat) ta.append (input + "\n"); // eigen tekst naar ta
      else ta.append ("IK ZEI TOCH DAT HET GEDAAN IS !!!\n");
      ta.selectAll(); // doet autoscroll naar beneden
      vak.setText("");
      // hier : code voor verzenden naar andere pc, vb out.writeln(input); 
    }
  }
  
   
  class Tellertje extends Thread{  // deze thread genereert "dummy tekst" (demo = de tijd)
	
	private int teller;
	private JTextArea ta;  
	
	
	public Tellertje (JTextArea ta){ 
		        // met ta als argument, werkt dan ook als deze klasse in andere file staat
		        // en nodig voor de ta.append's in de run methode
	           
	   	teller =0;
	   	this.ta = ta; // lokale kopie van de referentie naar de ta
	}
	
	public void run(){
		// hier zou dus een (bijna) oneindige lus kunnen 
		// staan die de tekst van de andere computer 
		// ontvangt en in de ta weergeeft
		// nu is het een "eindige" demo
	  do{
		teller++;
		slaap(3000);
		ta.append ("de tellerthread laat weten dat hij bij " + teller + " gekomen is " + "\n");
		ta.selectAll(); // doet autoscroll naar beneden
		
      } while (teller < 10);
      ta.append ("thread is klaar - bb"+"\n");
	}
	}    
 
   class TimerHandler implements ActionListener {
   	public void actionPerformed( ActionEvent e ) {
   	  	ta.append("NU HEB JE GENOEG GECHAT HOOR  !!" +"\n");
   	  	ta.selectAll(); // doet autoscroll naar beneden
        chat = false;
        timer.stop();
   	}
   }
     
     
     // slaap routine
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}