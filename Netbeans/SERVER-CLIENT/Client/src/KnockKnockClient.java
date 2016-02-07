import java.io.*; 
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnockKnockClient extends Thread{
    
    
    private javax.swing.JTextArea txtServer;
    
    public KnockKnockClient (javax.swing.JTextArea txtServer)
    {
        this.txtServer = txtServer;
        txtServer.setFont(new java.awt.Font("OCR A Extended", 0, 14));
    }
    
    
    public void run() {
        
         Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress addr;
		String host;
		
        try {
        	//terloops een demo van een statische methode uit InetAddress
        	addr = InetAddress.getByName("localhost");
        	//addr = InetAddress.getByName("pcb401a.khbo.be");
            txtServer.setText(txtServer.getText() + "\nComputer heeft IP adres " + addr.toString());
        	System.out.println("Computer heeft IP adres " + addr.toString());
            
            host = "localhost";
            kkSocket = new Socket(host, 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } 
        catch (UnknownHostException e) {
            txtServer.setText(txtServer.getText() + "\nDon't know about host");
            System.err.println("Don't know about host");
            System.exit(1);
        }
        catch (IOException e) {
            txtServer.setText(txtServer.getText() + "\nCouldn't get I/O for the connection");
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        try {
            while ((fromServer = in.readLine()) != null) {
            txtServer.setText(txtServer.getText() + "\nServer: " + fromServer);
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) break;
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
            txtServer.setText(txtServer.getText() + "\nClient: " + fromUser);
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.close();
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stdIn.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kkSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    

