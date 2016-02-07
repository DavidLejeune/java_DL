//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.util.Calendar;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author David
// */
//public class Klokske  extends Thread {
//  	
//    private javax.swing.JLabel lblUur;
//    private javax.swing.JLabel lblUur1;
//    private javax.swing.JLabel lblUur2;
//    
//    public Klokske(javax.swing.JLabel lblUur,javax.swing.JLabel lblUur1,javax.swing.JLabel lblUur2)
//    {
//        this.lblUur = lblUur;
//        this.lblUur1 = lblUur1;
//        this.lblUur2 = lblUur2;
//    }
//    
//    
//    
//    // geen constructor nodig --> automatic default constructor
//  	
//  	public void run(){
//            
//            
//  	  while (true){
//       
//		Calendar cd; 
//		cd = Calendar.getInstance();
//                //local time
//                int uren = cd.get(Calendar.HOUR_OF_DAY); 
//                int minuten = cd.get(Calendar.MINUTE); 
//                int seconden = cd.get(Calendar.SECOND);
//		lblUur.setText("" + String.format("%02d", uren) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
//                //Washington time
//                int urenW = uren -6;
//                if(urenW < 0) 
//                {
//                    urenW = urenW+ 24;
//                }
//                //ArRaqqah time
//                  int urenR = uren + 1;
//                if(urenR > 23) 
//                {
//                    urenR = urenR -  24;
//                }
//                              
//                lblUur1.setText("" + String.format("%02d", urenW) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
//                
//                lblUur2.setText("" + String.format("%02d", urenR) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
//    
//             Graphics2D g1 = (Graphics2D) getGraphics();
//            g1.setColor(Color.DARK_GRAY);
//            g1.drawOval(510, 723, 100, 100); 
//            g1.setColor(Color.DARK_GRAY);
//            g1.drawOval(190, 723, 100, 100); 
//            g1.setColor(Color.DARK_GRAY);
//            g1.drawOval(810, 723, 100, 100);             
//            g1.setColor(Color.MAGENTA);
//            g1.drawRect(250, 57,718,60);
//            g1.setColor(Color.blue);
//            g1.drawRect(252, 59,714,56);
//            g1.setColor(Color.lightGray);
//            g1.drawRect(254, 61,710,52);   
//                
////            g1.setColor(Color.RED);
////            g1.drawRect(250, 57,740,60);
////            g1.setColor(Color.ORANGE);
////            g1.drawRect(252, 59,736,56);
////            g1.setColor(Color.PINK);
////            g1.drawRect(254, 61,732,52);
//                
//            g1.setColor(Color.WHITE);
//            g1.fillArc(510, 723, 100, 100,90 - (30 * uren),3)  ;
//            g1.setColor(Color.BLUE);
//            g1.fillArc(510, 723, 100, 100,90 - (6*minuten),3)  ;
//            g1.setColor(Color.YELLOW);
//            g1.fillArc(510, 723, 100, 100,90 - (6*seconden),3)  ;  
//            g1.setColor(Color.WHITE);
//            g1.fillArc(190, 723, 100, 100,90 - (30*(urenW)),3)  ; 
//            g1.setColor(Color.BLUE);
//            g1.fillArc(190, 723, 100, 100,90 - (6*minuten),3)  ; 
//            g1.setColor(Color.YELLOW);
//            g1.fillArc(190, 723, 100, 100,90 - (6*seconden),3)  ; 
//            g1.setColor(Color.WHITE);
//            g1.fillArc(810, 723, 100, 100,90 - (30*(urenR)),3)  ;
//            g1.setColor(Color.BLUE);
//            g1.fillArc(810, 723, 100, 100,90 - (6*minuten),3)  ; 
//            g1.setColor(Color.YELLOW);
//            g1.fillArc(810, 723, 100, 100,90 - (6*seconden),3)  ;                  
//                
//                
//                
//                                       
//        //repaint();
//  	  }
//  	  
//  	}
//
//}
//    
    
    
    

