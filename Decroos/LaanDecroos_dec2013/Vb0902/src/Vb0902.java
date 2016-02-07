/**
 * AWT Sample application
 *
 * @author 
 * @version 1.00 07/01/27
 */
public class Vb0902 {
    
  public static void main(String[] args) {
  	// een gewone rechthoek
  	Rechthoek r = new Rechthoek(10,8);
    r.print();
  	
  	System.out.println();
  	 

//
//     // blz 251 : extra functionaliteit
//     // zo'n FlexRechthoek ook eens testen ... werkt niet ? >> print() override
    FlexRechthoek fr = new FlexRechthoek(2,2, "@"); // nu met symbool
	Rechthoek r2 = fr;
	fr.print();System.out.println();
	fr.breder();fr.breder();fr.breder();
	fr.hoger();fr.hoger();
    r2.print();
//
//  	 
   
  }
}
