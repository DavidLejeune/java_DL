
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
public class Klokje extends Thread {
    
        public Klokje p 
      
      private boolean doorgaan;
      Calendar cd; 
      private int uren, minuten, seconden;
    
      public Klokje (int uren, int minuten, int seconden)
      {
          this.uren = uren;
          this.minuten = minuten;
          this.seconden = seconden;
      }
        
      
      public int getUren()
      {
          return uren;
      }
          
      public int getMinuten()
      {
          return minuten;
      }
          
      public int getSeconden()
      {
          return seconden;
      }
    
@Override
public void run() 
{
    while (doorgaan)
    { // blijft hier altijd draaien, geen middel om te stoppen !
        
        cd = Calendar.getInstance(); 
        uren = cd.get(Calendar.HOUR_OF_DAY); 
        minuten = cd.get(Calendar.MINUTE); 
        seconden = cd.get(Calendar.SECOND);
        lblUren.setText(""+ uren);
        slaap(100);
        
    }

}


  public void slaap( int millisec ) {
    try { Thread.sleep( millisec ); }
    catch( InterruptedException e ) {}
  }


}






