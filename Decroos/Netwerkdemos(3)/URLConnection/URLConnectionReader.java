import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
    	
        URL adres = new URL("http://www.vives.be"); 
        
        URLConnection verbinding = adres.openConnection();
        // zou moeten maar lukt ook zonder
        // verbinding.connect();
        
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                verbinding.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) System.out.println(inputLine);
            
        System.out.println("\n>> LAATSTE WIJZIGING :        " + verbinding.getLastModified());    
        System.out.println("\n>> User interactie toegelaten :"+ verbinding.getAllowUserInteraction());
        System.out.println();
           
        in.close();
    }
}