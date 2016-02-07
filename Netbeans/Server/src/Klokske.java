
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Klokske  extends Thread {
  	
    private javax.swing.JLabel lblUur;
    private javax.swing.JLabel lblUur1;
    private javax.swing.JLabel lblUur2;
    private javax.swing.JPanel jPanel1;
    
    public Klokske(javax.swing.JLabel lblUur,javax.swing.JLabel lblUur1,javax.swing.JLabel lblUur2,javax.swing.JPanel jPanel1)
    {
        this.lblUur = lblUur;
        this.lblUur1 = lblUur1;
        this.lblUur2 = lblUur2;
        this.jPanel1 = jPanel1;
    }
    
    
    
    // geen constructor nodig --> automatic default constructor
  	
  	public void run(){
            
            
  	  while (true){
       
		Calendar cd; 
		cd = Calendar.getInstance();
                //local time
                int uren = cd.get(Calendar.HOUR_OF_DAY); 
                int minuten = cd.get(Calendar.MINUTE); 
                int seconden = cd.get(Calendar.SECOND);
		lblUur.setText("" + String.format("%02d", uren) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
                //Washington time
                int urenW = uren -6;
                if(urenW < 0) 
                {
                    urenW = urenW+ 24;
                }
                //ArRaqqah time
                  int urenR = uren + 1;
                if(urenR > 23) 
                {
                    urenR = urenR -  24;
                }
                              
                lblUur1.setText("" + String.format("%02d", urenW) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
                
                lblUur2.setText("" + String.format("%02d", urenR) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
    
             Graphics2D g1 = (Graphics2D) jPanel1.getGraphics();
             //poging om flikkeren tegen te gaan : niet echt gelukt
            jPanel1.setDoubleBuffered(true);
            
            
            
            g1.setColor(Color.BLACK);
            //g1.fillRect(180, 720,800,150)  ;
            g1.fillArc(510, 690, 100, 100,90 - (30 * uren),360)  ;
            g1.fillArc(190, 690, 100, 100,90 - (30*(urenW)),360)  ;
            g1.fillArc(810, 690, 100, 100,90 - (6*minuten),360)  ;  
            
            
            
            
            g1.setColor(Color.DARK_GRAY); 
            g1.drawOval(510, 690, 100, 100); 
            g1.setColor(Color.DARK_GRAY);
            g1.drawOval(190, 690, 100, 100); 
            g1.setColor(Color.DARK_GRAY);
            g1.drawOval(810, 690, 100, 100);             
            g1.setColor(Color.MAGENTA);
            g1.drawRect(250, 28,718,60);
            g1.setColor(Color.blue);
            g1.drawRect(252, 30,714,56);
            g1.setColor(Color.lightGray);
            g1.drawRect(254, 32,710,52);  
                
//            g1.setColor(Color.RED);
//            g1.drawRect(250, 57,740,60);
//            g1.setColor(Color.ORANGE);
//            g1.drawRect(252, 59,736,56);
//            g1.setColor(Color.PINK);
//            g1.drawRect(254, 61,732,52);
                
            g1.setColor(Color.WHITE);
            g1.fillArc(510, 690, 100, 100,90 - (30 * uren),3)  ;
            g1.setColor(Color.BLUE);
            g1.fillArc(510, 690, 100, 100,90 - (6*minuten),3)  ;
            g1.setColor(Color.YELLOW);
            g1.fillArc(510, 690, 100, 100,90 - (6*seconden),3)  ;  
            g1.setColor(Color.WHITE);
            g1.fillArc(190, 690, 100, 100,90 - (30*(urenW)),3)  ; 
            g1.setColor(Color.BLUE);
            g1.fillArc(190, 690, 100, 100,90 - (6*minuten),3)  ; 
            g1.setColor(Color.YELLOW);
            g1.fillArc(190, 690, 100, 100,90 - (6*seconden),3)  ; 
            g1.setColor(Color.WHITE);
            g1.fillArc(810, 690, 100, 100,90 - (30*(urenR)),3)  ;
            g1.setColor(Color.BLUE);
            g1.fillArc(810, 690, 100, 100,90 - (6*minuten),3)  ; 
            g1.setColor(Color.YELLOW);
            g1.fillArc(810, 690, 100, 100,90 - (6*seconden),3)  ;                  
                
                
                
                                       
        //repaint();
  	  }
  	  
  	}

}
    
    
    
    

