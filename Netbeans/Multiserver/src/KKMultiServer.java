
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class KKMultiServer extends Thread{
    private javax.swing.JTextArea txtTerminal;
    private ArrayList<Gegevens> lijst;
    private javax.swing.JButton btnStart;    
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtJaar;    
    private javax.swing.JButton btnAddToDatabase;    
        
        public KKMultiServer(javax.swing.JTextArea txtTerminal,ArrayList<Gegevens> lijst, javax.swing.JButton btnStart
     ,javax.swing.JLabel jLabel2 ,javax.swing.JLabel jLabel3 ,javax.swing.JLabel jLabel4 ,javax.swing.JTextField txtNaam
    ,javax.swing.JTextField txtKlas ,javax.swing.JTextField txtJaar  ,javax.swing.JButton btnAddToDatabase )     
        {
            this.txtTerminal = txtTerminal;
            //txtServer.setFont(new java.awt.Font("OCR A Extended", 0, 14));
            this.lijst = lijst;   
            this.btnStart = btnStart;
            this.jLabel2 =jLabel2;
            this.jLabel3 =jLabel3;
            this.jLabel4 =jLabel4;
            this.txtNaam =txtNaam;
            this.txtKlas =txtKlas;
            this.txtJaar =txtJaar;
            this.btnAddToDatabase = btnAddToDatabase;
        }
        
        
        
        
        
	
    public void run(){
        
        ServerSocket serverSocket = null;
        boolean listening = true;

        
         // een array voor referenties naar thread-objecten
        KKMultiServerThread[] kms = new KKMultiServerThread[100];
        int aantal = 0;

        try {
            serverSocket = new ServerSocket(4444);
            
            txtTerminal.append("[OK] Server is running > listening on port : 4444\n");
            btnStart.hide();
            jLabel2.show();
            jLabel3.show();
            jLabel4.show();
            txtNaam.show();
            txtKlas.show();
            txtJaar.show();
            btnAddToDatabase.show();
            
            
        } catch (IOException e) {
            txtTerminal.setText("Could not listen on port: 4444.");
           // System.exit(-1);
        }
        
        
        
        Socket clientSocket = null;
        while (listening){
            try {
                clientSocket = serverSocket.accept(); // wacht op client
            } catch (IOException ex) {
                Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        	  
        	  // maak nieuwe thread
         	kms[aantal] = new KKMultiServerThread(clientSocket, aantal,txtTerminal,lijst);
        	kms[aantal].start(); // start() roept de run() op van de thread 
	        aantal++;
	      
	       txtTerminal.append("Client [" + aantal + "] has logged in\n" ) ;
	       txtTerminal.setForeground(new Color ((int) ( 16777216 * Math.random())));  
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



















