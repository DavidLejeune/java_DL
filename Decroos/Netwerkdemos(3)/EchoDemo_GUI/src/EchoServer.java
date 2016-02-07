import java.net.*;
import java.io.*;
import java.util.*;

//uit : de java turorial
//http://java.sun.com/docs/books/tutorial/networking/sockets/readingWriting.html

// eenvoudigste server , zonder protocol klasse
// eenvoudige tekstafhandeling bijgevoegd door L. Decroos

public class EchoServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        System.out.println("De server is gestart op poort 4444");
        
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
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
        
        while (((inputLine = in.readLine()) != null) && !gedaan ) {
               // controle aan de server-zijde
             System.out.println("De client heeft " + inputLine + " getikt");
             
         		// tekstafhandeling
             if (inputLine.length() >= 2 ){
             	
             	ch1 = inputLine.charAt(0);
                ch2 = inputLine.charAt(1);
                Date dd = new Date();
                String temp = ""; 

             	if (ch1 == '#'){
             	
             	  switch (ch2){

             		case 'D' : case 'd' : // stuur datum terug
             		   temp = ""+ dd.getDate() + "/" + (dd.getMonth()+1);
             		   out.println("De datum is : "+ temp); break;

             		case 'T' : case 't' : // stuur tijd terug
             		   temp = dd.getHours()+ ":" + dd.getMinutes()+ ":" + dd.getSeconds();
             		   out.println("De tijd is : "+ temp);break;
             		   
             		case 'Q' : case 'q' :
             		   out.println("EINDE");
             		   gedaan = true; break;
             		   
             		default : out.println("invalid command (use #D, #T or #Q)");
             	  }
                }
                
                else {
                   out.println(inputLine);  // stuur gewoon dezelfde tekst(>=2) terug
              }}
              else {
                   out.println(inputLine);  // stuur gewoon dezelfde tekst(1 char) terug
              }
             
             
        }
        
        // dit werkt niet goed, je moet eerst nog een Enter tikken ...
        if (gedaan){
             	out.println("Tot later - Ik sluit de verbinding, je moet dus niets meer tikken !");
                
               }
               
        out.close();
        in.close();
        clientSocket.close();// verbreek de verbinding
        serverSocket.close();// stop de server
    }
}
