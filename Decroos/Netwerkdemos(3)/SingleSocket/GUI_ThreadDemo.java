/**
 * @(#)GUI_ThreadDemo.java
 *
 * tegelijk tekst uit vak en input vanuit een thread in een JTextArea zetten
 * (bvb. voor chat-toepassing)
 *
 * JFC Sample application
 *
 * @author  : Luc Decroos - KHBO - 10/10/2007 
 *            
 * @version 2.00 05/11/13
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

 
public class GUI_ThreadDemo {
    
    public static void main(String[] args) {
         // Create application frame.
        GUI_ThreadDemoFrame frame = new GUI_ThreadDemoFrame();
    }
}




class GUI_ThreadDemoFrame extends JFrame {
    
    JScrollPane sp;
    JTextArea ta ;
    JTextField vak;
    Tellertje t;  // een thread-object
   
    public GUI_ThreadDemoFrame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Container c = getContentPane();  // deze pointer vinden
        c.setLayout(new FlowLayout());
             
        ta = new JTextArea(24,60);
        ta.setEditable(false); // je mag er niet in schrijven
        sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        vak = new JTextField (60);
        vak.addActionListener(new VakHandler());
       
        c.add(ta);
        c.add(vak);     
       
        t = new Tellertje (); // thread maken en starten
        t.start();
        
        new Reminder(60);
        System.out.println("Task scheduled.");
    
               
        setTitle("GUI_ThreadDemoFrame");
        setSize(new Dimension(800, 500));
        setVisible (true);  
    }
    
  public static void slaap (int mSec){
                try {
                Thread.currentThread().sleep(mSec);
                } catch (InterruptedException e){ }
        }
  
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      ta.append (vak.getText() + "\n"); // eigen tekst naar ta
      vak.setText("");
      // hier : verzend naar andere pc
    }
  }
  
   
  class Tellertje extends Thread{  // deze thread genereert "vreemde" tekst (demo = de tijd)
	
	private int teller;
	//private TextArea ta;  
	
	public Tellertje (){ // ta als argument, werkt ook als deze klasse in andere file staat
	   	teller =0;
	   	//this.ta = ta;
	}
	
	public void run(){
	  do{
		teller++;
		slaap(3000);
		ta.append ("de tellerthread laat weten dat hij bij " + teller + " gekomen is " + "\n");
		vak.requestFocus();
      } while (teller < 10);
      ta.append ("thread is klaar - bb"+"\n");
	}
	}    
 
 class Reminder {
 
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
	}

    class RemindTask extends TimerTask {
        public void run() {
            ta.append("NU HEB JE GENOEG GECHAT HOOR  !!" +"\n");
            timer.cancel(); //Terminate the timer thread
        }
    }
    }
 
    
}



