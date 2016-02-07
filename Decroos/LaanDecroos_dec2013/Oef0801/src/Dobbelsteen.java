/**
 * @(#)Dobbelsteen.java
 *
 *
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/2/13
 */
import java.awt.*;

public class Dobbelsteen {
    private int waarde;
    
    public Dobbelsteen() {
       waarde = 0;
    }
    
    public int gooi(){
    	waarde = (int) ( 6 * Math.random() + 1 );
    	return waarde;
    }
    
    public void teken (int offset_x, Graphics gr){
      
      switch (waarde) {    	
      	case 1 : gr.fillOval(offset_x+215,215,20,20); break;
        
        case 2 : gr.fillOval(offset_x+191,191,20,20);
                 gr.fillOval(offset_x+239,239,20,20); break;
                 
        case 3 : gr.fillOval(offset_x+178,178,20,20);
        		 gr.fillOval(offset_x+215,215,20,20);
        		 gr.fillOval(offset_x+252,252,20,20); break;
        
        case 4 : gr.fillOval(offset_x+178,178,20,20);
        		 gr.fillOval(offset_x+178,252,20,20);
        		 gr.fillOval(offset_x+252,178,20,20);
        		 gr.fillOval(offset_x+252,252,20,20); break;
        		 
        case 5 : gr.fillOval(offset_x+178,178,20,20);
        		 gr.fillOval(offset_x+178,252,20,20);
        		 gr.fillOval(offset_x+252,178,20,20);
        		 gr.fillOval(offset_x+252,252,20,20);
        	 	 gr.fillOval(offset_x+215,215,20,20); break;
        	 	 
        case 6 : gr.fillOval(offset_x+178,178,20,20);
        		 gr.fillOval(offset_x+178,252,20,20);
        		 gr.fillOval(offset_x+252,178,20,20);
        		 gr.fillOval(offset_x+252,252,20,20);
        		 gr.fillOval(offset_x+178,215,20,20);
        		 gr.fillOval(offset_x+252,215,20,20); break;      		
      }
    }
    
}