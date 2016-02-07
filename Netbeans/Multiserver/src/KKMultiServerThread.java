
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class KKMultiServerThread extends Thread {
    
    private Socket socket = null;
    private int cnr;
    PrintWriter out;
    BufferedReader in;
    String boodschap;
    private javax.swing.JTextArea txtTerminal;
    private javax.swing.JTextField txtZoekVeld;
    private ArrayList<Gegevens> lijst;
    
    

                         // Constructor
    public KKMultiServerThread(Socket socket,int cnr,javax.swing.JTextArea txtTerminal,ArrayList<Gegevens> lijst) {
	  super("KKMultiServerThread"); // roep de constructor van Thread aan 
	                                // en geef de thread meteen een naam 
	                                // (anders maakt systeem zelf een naam)
          
          

            this.txtTerminal = txtTerminal;
            //txtServer.setFont(new java.awt.Font("OCR A Extended", 0, 14));
            this.txtZoekVeld = txtZoekVeld;
            this.lijst = lijst;
            txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
            
            
            
            
            
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
String inputLine;
        boolean gedaan = false;
        char ch1, ch2;
        
        while (((inputLine = in.readLine()) != null) && !gedaan ) {
               // controle aan de server-zijde
             txtTerminal.append("Client [" + cnr + "] request : " + inputLine + "\n");
             txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
             
	    txtTerminal.setForeground(new Color ((int) ( 16777216 * Math.random())));
             String resultaat = "";
             Boolean contains = false;
             if(!inputLine.equals("")){
                 int iCount = 0;
                for(Gegevens tekst: lijst) 
                {
                    
                    System.out.println(tekst);
                 
                    if (tekst.toString().contains(inputLine))
                    {
                        resultaat = resultaat + "xxxx\t\t" + tekst.getNaam() +"\t" + tekst.getKlas() + "\t"  + tekst.getJaar() +"\t";
                        //out.println("" + tekst.getNaam() +"\t" + tekst.getKlas() + "\t"  + tekst.getJaar() +"\t");
                        //out.println(tekst);
                        contains = true;
                        iCount++;
                    } 
                
                
                }   
                
                
                
                
                if(!contains)
                {
                    txtTerminal.append("Server response : No result found" +"\n");
                    out.println("No result found");
                }
                else
                {
                    
                    resultaat = "Found " + iCount + " record(s)." + resultaat ;
                    out.println(resultaat);
                    
                    String zin2 = "";
                    zin2 =  resultaat.replaceAll("xxxx", "\n");
                    txtTerminal.append("Server response : " + zin2 +"\n");
                    //txtTerminal.append(boodschap + "\n");
                    txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
                }
                
             }
             else
             {
                 //out.println("Geen zoekwaarde ingegeven"); 
                 
                 
                 int iCount = 0;
                for(Gegevens tekst: lijst) 
                {
                    

                        resultaat = resultaat + "xxxx\t\t" + tekst.getNaam() +"\t" + tekst.getKlas() + "\t"  + tekst.getJaar() +"\t";
                        //out.println("" + tekst.getNaam() +"\t" + tekst.getKlas() + "\t"  + tekst.getJaar() +"\t");
                        //out.println(tekst);
                        contains = true;
                        iCount++;

                
                
                }   
                
                
                
                
                if(!contains)
                {
                    out.println("No result found");
                }
                else
                {
                    
                    resultaat = "Found " + iCount + " record(s)." + resultaat ;
                    out.println(resultaat);
                    
                    String zin2 = "";
                    zin2 =  resultaat.replaceAll("xxxx", "\n");
                    txtTerminal.append("Server response : " + zin2 +"\n");
                    txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
                }                 
                 
                 
                 
                 
             }
             
             
             
             
             
             
             
        }
        
        // dit werkt niet goed, je moet eerst nog een Enter tikken ...
        if (gedaan){
             	out.println("Tot later - Ik sluit de verbinding, je moet dus niets meer tikken !");
                
               }
               
        out.close();
        in.close();
        socket.close();// verbreek de verbinding
        //serverSocket.close();// stop de server
        txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
	  } 
	  catch (IOException e) {
	    e.printStackTrace();
	  }
    }
    
    public void setBoodschap(String boodschap){
      this.boodschap = boodschap;
    }
}






