/* html van een website in een DOS-venster afdrukken
 * (dan kan je dit ook in een String of een tekst-bestand opslaan
 *  daarin dan zoeken, enz ...
 */

import java.net.*;
import java.io.*;

public class URLReader {
	
    public static void main(String[] args) throws Exception {
	  
	  URL adres = new URL("http://www.khbo.be");
	
	  BufferedReader in = new BufferedReader(
		new InputStreamReader(adres.openStream()));
		
	  String inputLine;
	  
          // lezen zoals een tekstfile
	  while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);

	  in.close();
    }
}