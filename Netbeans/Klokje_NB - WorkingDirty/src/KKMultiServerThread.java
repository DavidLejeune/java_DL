import java.net.*;
import java.io.*;

public class KKMultiServerThread extends Thread {
    
    private Socket socket = null;
    private int cnr;
    PrintWriter out;
    BufferedReader in;
    String boodschap;
    private javax.swing.JTextArea txtServer;

                         // Constructor
    public KKMultiServerThread(Socket socket,int cnr,javax.swing.JTextArea txtServer) {
	  super("KKMultiServerThread"); // roep de constructor van Thread aan 
	                                // en geef de thread meteen een naam 
	                                // (anders maakt systeem zelf een naam)
            this.txtServer = txtServer;
	                                
	  this.socket = socket;         // koppel onze socket aan de opgegeven socket 
	  this.cnr = cnr + 1;           // verhoog het connectie-nummer
	  try {  // zelfde code als voor de KnockKnockServer voor 1 client
	    out = new PrintWriter(socket.getOutputStream(), true);
	    in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));
	  }
	  catch (IOException e) {
	    e.printStackTrace();
	  }
	  
    }

    
         // iedere thread klasse moet een run() methode hebben (naast evt. andere methoden)
    public void run() {

	  
      try{

	    String inputLine, outputLine;
	    KnockKnockProtocol kkp = new KnockKnockProtocol();
	    
	    
	    outputLine = "SERVER > [client " + cnr + "] :\n" + kkp.processInput(null);
	    out.println(outputLine);

	    while ((inputLine = in.readLine()) != null) {
	       
	       txtServer.setText(txtServer.getText()+ "\n" +  "[client " + cnr + "] > SERVER : " + inputLine);
		   outputLine = "SERVER > [client " + cnr + "] : \n" + kkp.processInput(inputLine);
                    txtServer.setText(txtServer.getText()+ "\n\n" + outputLine);
		   out.print(outputLine);
		   if (!(boodschap.equals(""))){
			  out.println(boodschap);
			  boodschap="";
		   }
		   else out.println();
		   
		   if (outputLine.equals("Bye"))
		      break;
	    }
	    
	    out.close();
	    in.close();
	    socket.close();

	  } 
	  catch (IOException e) {
	    e.printStackTrace();
	  }
    }
    
    public void setBoodschap(String boodschap){
      this.boodschap = boodschap;
    }
}
