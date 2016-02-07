import java.net.*;
import java.io.*;

public class KKMultiServer {
	
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = null;
        boolean listening = true;
        
         // een array voor referenties naar thread-objecten
        KKMultiServerThread[] kms = new KKMultiServerThread[100];
        int aantal = 0;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
        
        System.out.println("Server draait");
        
        Socket clientSocket = null;
        while (listening){
        	clientSocket = serverSocket.accept(); // wacht op client
        	  
        	  // maak nieuwe thread
         	kms[aantal] = new KKMultiServerThread(clientSocket, aantal);
        	kms[aantal].start(); // start() roept de run() op van de thread 
	        aantal++;
	      
	        System.out.println("Client nr " + aantal + " heeft zich aangemeld" ) ;
	        
	        for(int i = 0; i<aantal; i++){
	        		kms[i].setBoodschap(" [INFO: je ben met " + aantal + " aangemeld]");
	        	}	            	
        }
	       

        serverSocket.close();
    }
}
