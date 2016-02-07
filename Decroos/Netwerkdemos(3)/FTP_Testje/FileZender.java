/**
 * @(#)FileZender.java
 *
 *
 * @author 
 * @version 1.00 2009/11/10
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class FileZender {

    public static void main(String[] args) throws IOException {
    	ServerSocket serverSocket = null;
        BufferedReader toetsenbord = new BufferedReader(new InputStreamReader(System.in));
        boolean gevonden = true;
        BufferedReader invoer = null;
        
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        System.out.println("De server is gestart op poort 4444, welk bestand moet ik verzenden :");
        do{
            String bestand = toetsenbord.readLine();
        	try{
               invoer = new BufferedReader(new FileReader(bestand)); 	
               gevonden = true;
            }
            catch (IOException e){
        	   System.out.println("Dat bestand bestaat niet hoor, probeer opnieuw :");
        	   gevonden = false;
            }
        }
        while (!gevonden );    
        
        if (gevonden){
        	
           System.out.println ("OK, ik wacht op de eerste client die het wil hebben ...");
           Socket clientSocket = null;
           try {
               clientSocket = serverSocket.accept(); // accept is een verborgen wachtlus
           } 
           catch (IOException e) {
              System.err.println("Accept failed.");
              System.exit(1);
           }

           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        								// true = autoflush ON
           BufferedReader in = new BufferedReader(	new InputStreamReader(
				clientSocket.getInputStream()));
        
           String inputLine;
           boolean gedaan = false;
           char ch1, ch2;
        
           while (((inputLine = invoer.readLine()) != null)) {
               // controle aan de server-zijde
             System.out.println("lijn gelezen uit bestand : " + inputLine );
               // stuur naar client :
             out.println(inputLine);
            
           }  
            
            
           out.close();
           in.close();
           invoer.close();
        
           clientSocket.close();// verbreek de verbinding
           serverSocket.close();// stop de server 
        }
        
       
    
    }
    
    
}