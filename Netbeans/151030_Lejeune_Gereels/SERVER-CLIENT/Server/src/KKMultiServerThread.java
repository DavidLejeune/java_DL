import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.net.*;
import java.io.*;

public class KKMultiServerThread extends Thread {
    
    private Socket socket = null;
    private int cnr;
    PrintWriter out;
    BufferedReader in;
    String boodschap;
    private javax.swing.JTextArea txtServer;
    private javax.swing.JTextArea txtDatabase;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtJaar;
    private String task;
    private javax.swing.JPanel jPanel1;
    
    

                         // Constructor
    public KKMultiServerThread(Socket socket,int cnr,javax.swing.JTextArea txtServer,javax.swing.JTextArea txtDatabase,javax.swing.JLabel lblDatabase,javax.swing.JTextField txtNaam,javax.swing.JTextField txtKlas,javax.swing.JTextField txtJaar,String task,javax.swing.JPanel jPanel1) {
	  super("KKMultiServerThread"); // roep de constructor van Thread aan 
	                                // en geef de thread meteen een naam 
	                                // (anders maakt systeem zelf een naam)
          
          
          this.txtServer = txtServer;
            this.txtDatabase=txtDatabase;
            this.lblDatabase = lblDatabase;
            this.txtNaam = txtNaam;
            this.txtKlas = txtKlas;
            this.txtJaar = txtJaar;
            this.task = task;
            this.jPanel1=jPanel1;
	                                
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

	  
   

	    String inputLine, outputLine ,outputLine2;
            
            

            
            
            
            
	    KnockKnockProtocol kkp = new KnockKnockProtocol(txtDatabase,lblDatabase,txtNaam,txtKlas,txtJaar,task,jPanel1);
            
            
            
            
//	    if (task.equals("SearchLog"))
//            {
                
//        if (txtNaam.getText().equals("") && txtKlas.getText().equals("") && txtJaar.getText().equals(""))
//        {
//            
//            int ii;
//            for (ii=0;ii<3900;ii++)
//            {
//                txtDatabase.setText("Alle vakken waren leeg");
//            Graphics2D g99 = (Graphics2D) jPanel1.getGraphics();
//            //g99.setColor(Color.RED);
//            g99.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
//            //g99.fillRect(124, 660, 300, 30);
//            g99.setColor(Color.RED);
//            g99.drawString("You haven't entered a search value", 300, 680);
//            g99.drawRect(190, 655,740,35);
//            
//            }
//        }
//        else
//        {
//           SearchDatabase sd = new SearchDatabase(txtDatabase,lblDatabase,txtNaam,txtKlas,txtJaar);
//            sd.start(); 
//        }   
                
                
            
                
                
//                    if (txtNaam.getText().equals("") && txtKlas.getText().equals("") && txtJaar.getText().equals(""))
//        {
//            
//            int ii;
//            for (ii=0;ii<3900;ii++)
//            {
//                txtDatabase.setText("Alle vakken waren leeg");
////            Graphics2D g99 = (Graphics2D) jPanel1.getGraphics();
////            //g99.setColor(Color.RED);
////            g99.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
////            //g99.fillRect(124, 660, 300, 30);
////            g99.setColor(Color.RED);
////            g99.drawString("You haven't entered a search value", 300, 680);
////            g99.drawRect(190, 655,740,35);
//            
//            }
//        }
//        else
//        {
//            
//        }
//            }
//	    
////	    outputLine = "[client " + cnr + "]: " + kkp.processInput(null);
////	    out.println(outputLine);
////
////	    while ((inputLine = in.readLine()) != null) {
////                    txtServer.setText(txtServer.getText() + "\n[" + cnr + "]:" +inputLine);
////		   outputLine = "[client " + cnr + "]: " + kkp.processInput(inputLine);
////                   outputLine2 = kkp.processInput(inputLine);
////                   txtServer.setText(txtServer.getText() + "\n[S]>[" + cnr + "]:" + outputLine2);
////                   txtServer.setCaretPosition(txtServer.getDocument().getLength());
////		   out.print(outputLine);
////		   if (!(boodschap.equals(""))){
////                             txtServer.setText(txtServer.getText() + "\n[S]:" +boodschap);
////			  out.println(boodschap);
////			  boodschap="";
////		   }
////		   else out.println();
////		   
////		   if (outputLine.equals("Bye"))
////		      break;
////	    }
//	    
//	    out.close();
//	    in.close();
//	    socket.close();
//
//	  } 
//	  catch (IOException e) {
//	    e.printStackTrace();
//	  }
//    }
            }
            
//    }
    public void setBoodschap(String boodschap){
      this.boodschap = boodschap;
    }
}
