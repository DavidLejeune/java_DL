import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KKMultiServer extends Thread{
	private javax.swing.JTextArea txtServer;
    private javax.swing.JTextArea txtDatabase;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtJaar;
    private String task;
    private javax.swing.JPanel jPanel1;
        
        
        
        
        
        public KKMultiServer(javax.swing.JTextArea txtServer,javax.swing.JTextArea txtDatabase,javax.swing.JLabel lblDatabase,javax.swing.JTextField txtNaam,javax.swing.JTextField txtKlas,javax.swing.JTextField txtJaar,String task,javax.swing.JPanel jPanel1)
                
                
                
                
                
                
        {
            this.txtServer = txtServer;
            txtServer.setFont(new java.awt.Font("OCR A Extended", 0, 14));
            this.txtDatabase=txtDatabase;
            this.lblDatabase = lblDatabase;
            this.txtNaam = txtNaam;
            this.txtKlas = txtKlas;
            this.txtJaar = txtJaar;
            this.task = task;
            this.jPanel1 = jPanel1;
        }
	
    public void run(){
        
        ServerSocket serverSocket = null;
        boolean listening = true;
        
         // een array voor referenties naar thread-objecten
        KKMultiServerThread[] kms = new KKMultiServerThread[100];
        int aantal = 0;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            txtServer.setText("Could not listen on port: 4444.");
           // System.exit(-1);
        }
        
        txtServer.setText("Server draait > listening on port : 4444");
        
        Socket clientSocket = null;
        while (listening){
            try {
                clientSocket = serverSocket.accept(); // wacht op client
            } catch (IOException ex) {
                Logger.getLogger(KKMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        	  
        	  // maak nieuwe thread
         	kms[aantal] = new KKMultiServerThread(clientSocket, aantal,txtServer,txtDatabase,lblDatabase,txtNaam,txtKlas,txtJaar,task,jPanel1);
        	kms[aantal].start(); // start() roept de run() op van de thread 
	        aantal++;
	      
	       txtServer.setText(txtServer.getText()+"\nClient nr " + aantal + " heeft zich aangemeld" ) ;
	        
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
