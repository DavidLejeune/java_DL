/**
 * @(#)Dobbelsteen.java
 *
 *
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/2/13
 */


public class Dobbelsteen {
    private int waarde;
    
    
    
    public Dobbelsteen() {
       waarde = 0;
    }
    
    public int gooi(){
    	waarde = (int) ( 6 * Math.random() + 1 );
    	return waarde;
    }
    
    
    public long telAantalZessen (long aantalWorpen){
    	int worp;
    	long aantalZessen=0;
    	
    	for (long i= 0; i < aantalWorpen ; i++){
    		worp = gooi();
    		if ( worp == 6) aantalZessen++;
    	}
    	return aantalZessen;
    }
    
}