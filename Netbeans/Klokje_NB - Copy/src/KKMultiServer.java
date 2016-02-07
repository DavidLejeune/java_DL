import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KKMultiServer extends Thread{
	
    public void run(){
        
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
            try {
                clientSocket = serverSocket.accept(); // wacht op client
            } catch (IOException ex) {
                Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        	  
        	  // maak nieuwe thread
         	kms[aantal] = new KKMultiServerThread(clientSocket, aantal);
        	kms[aantal].start(); // start() roept de run() op van de thread 
	        aantal++;
	      
	        System.out.println("Client nr " + aantal + " heeft zich aangemeld" ) ;
	        
	        for(int i = 0; i<aantal; i++){
	        		kms[i].setBoodschap(" [INFO: je ben met " + aantal + " aangemeld]");
	        	}	            	
        }
	       

        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

}
