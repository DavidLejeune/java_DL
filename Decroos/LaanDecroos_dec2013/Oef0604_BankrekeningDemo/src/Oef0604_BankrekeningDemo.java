/**
 * @(#)Oef0604_BankrekeningDemo.java
 *
 * Oef0604_BankrekeningDemo application
 *
 * Testen van de eenvoudigste Bankrekening klasse
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Oef0604_BankrekeningDemo extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0604_BankrekeningDemo();
       frame.setSize(500,300);
       frame.setLocation (200,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0604_BankrekeningDemo");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {

  private JLabel label;    
  private JButton stortKnop, opneemKnop;
  private JTextField tekstvak;
  
  private Bankrekening mijnRekening;
  private String boodschap = "";
   
  
    // Constructor
  public Paneel() {
  	
  	setFont (new Font ("SansSerif", Font.BOLD, 16));
  	
	label = new JLabel (" Bedrag voor storten/opnemen : ");	  
	  
    stortKnop = new JButton( " Storten " );
    stortKnop.addActionListener( new StortKnopHandler() );
    
    opneemKnop = new JButton( " Opnemen " );
    opneemKnop.addActionListener( new OpneemKnopHandler() );
    
    tekstvak = new JTextField( 20 );
      
    add( label);
    add( tekstvak );
    add( stortKnop );
    add( opneemKnop);
    
    mijnRekening = new Bankrekening("123", 1000.0);
    //mijnRekening = new Bankrekening( );
  }
     
      
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      g.drawString ("Je hebt €    " + mijnRekening.getSaldo() +
      	 "  op rekening " + mijnRekening.getRekeningnummer(), 50,200);
      g.drawString (boodschap, 50, 230);
      
  }
  
      
  class StortKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {

       double bedrag = Double.parseDouble ( tekstvak.getText());
       mijnRekening.stort(bedrag);
       boodschap = "Bedrag werd gestort";
       repaint();
    }
  }
  
  class OpneemKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       
       double bedrag = Double.parseDouble ( tekstvak.getText());
       int resultaat = mijnRekening.neemOp(bedrag);
       
       if (resultaat == 1) boodschap = "Opnemen is gelukt";
       else  boodschap = "Opnemen is mislukt";
       
       repaint();
    }
  }
}



class Bankrekening {
	
	private String rekeningnummer;
	private double saldo, percent;
	
	// paragraaf 6.6 : een Constructor :
	public Bankrekening ( String nr){
		rekeningnummer = nr;  // ipv this.rekeningnummer = rekeningnummer;
		saldo = 0; 
	}
	
	// paragraaf 6.6.2 : een tweede Constructor :
	public Bankrekening ( String nr, double startBedrag ){
		rekeningnummer = nr ;  
		saldo = startBedrag ;        
	}
	
	// paragraaf 6.7.2 : een default Constructor :
	public Bankrekening ( ){ // GEEN argumenten
		rekeningnummer = "123456" ;  // beetje zinloos : alle rekeningen zelfde nr ?
		saldo = 0.0 ;        
	}
	
	// een methode met een returnwaarde, maar zonder argumenten
	public String getRekeningnummer(){ 
		return rekeningnummer ;
	}

	
	// een methode met een returnwaarde, maar zonder argumenten
	public double getSaldo(){ 
		return saldo;
	}
	
	// een methode zonder returnwaarde, maar met een argument
	public void stort ( double bedrag ){ 
		saldo = saldo + bedrag;
	}
	
	
	
	public int neemOp (double bedrag){  // een methode met beide, verschilt wel van boek !
		int gelukt = 0;  // voor controle
			
		if (saldo >= bedrag){ // lichtjes beveiligd ... ;-)
			saldo = saldo - bedrag;
			gelukt  = 1;
		}
		return gelukt; // controlegetal
		 // opm : is beter dan return saldo, want dit ondergraaft de getSaldo() methode
		 // en return bedrag is helemaal zinloos
	}
}