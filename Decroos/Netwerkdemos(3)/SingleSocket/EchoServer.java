import java.net.*;
import java.io.*;
import java.util.*;

//uit : de java tutorial
//http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.$html
// eenvoudigste server , zonder protocol klasse
// eenvoudige tekstafhandeling bijgevoegd door L. Decroos
public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;// locale variabele
        boolean server_ok = true, client_ok = true;

        try {
            serverSocket = new ServerSocket(4444);// probeer server te maken op poort 4444
        }
        catch (IOException e) {
            System.err.println("Kan geen server maken op poort 4444 !");
            // err is een aparte console op linux systemen, bij ons = out
            server_ok = false;
        }
        
        if (server_ok) {
            System.out.println("De server is gestart op poort 4444");
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept(); // accept is een verborgen wachtlus
            } catch (IOException e) {
                System.err.println("Verbinding met client is mislukt !");
                client_ok = false;
            }
            if (client_ok) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // true = autoflush ON
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        clientSocket.getInputStream()));

                String inputLine;
                Calendar nu;
                boolean gedaan = false;
                char ch1, ch2;

                while (((inputLine = in.readLine()) != null) && !gedaan) {
                    // controle aan de server-zijde
                    System.out.println("De client heeft " + inputLine + " getikt");

                    // tekstafhandeling
                    if (inputLine.length() >= 2) {
                        ch1 = inputLine.charAt(0);
                        ch2 = inputLine.charAt(1);

                        String temp = "";

                        if (ch1 == '#') {
                            nu = Calendar.getInstance(Locale.GERMANY);

                            switch (ch2) {

                                case 'D':
                                case 'd': // stuur datum terug
                                    temp = nu.get(Calendar.DAY_OF_MONTH) + "/"
                                            + (nu.get(Calendar.MONTH) + 1);
                                    out.println("De datum is : " + temp);
                                    break;

                                case 'T':
                                case 't': // stuur tijd terug
                                    temp = nu.get(Calendar.HOUR_OF_DAY) + ":" + nu.get(Calendar.MINUTE) + ":" + nu.get(Calendar.SECOND);
                                    out.println("De tijd is : " + temp);
                                    break;

                                case 'Q':
                                case 'q': // sluit af
                                    out.println("EINDE");
                                    gedaan = true;
                                    break;

                                default:
                                    out.println("invalid command (use #D, #T or #Q)");
                            }
                        } 
                        else {
                            out.println(inputLine);  // stuur gewoon dezelfde tekst(>=2) terug
                        }
                    } else {
                        out.println(inputLine);  // stuur gewoon dezelfde tekst(1 char) terug
                    }
                }

        
            out.close();
            in.close();
            }
            clientSocket.close();// verbreek de verbinding
            serverSocket.close();// stop de server
            
        }
    }
}


//oude versie
//import java.net.*;
//import java.io.*;
//import java.util.*;

//uit : de java tutorial
//http://java.sun.com/docs/books/tutorial/networking/sockets/readingWriting.html

// eenvoudigste server , zonder protocol klasse
// eenvoudige tekstafhandeling bijgevoegd door L. Decroos
//
//public class EchoServer {
//    public static void main(String[] args) throws IOException {
//
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(4444);
//        } catch (IOException e) {
//            System.err.println("Could not listen on port: 4444.");
//            System.exit(1);
//        }
//        System.out.println("De server is gestart op poort 4444");
//        
//        Socket clientSocket = null;
//        try {
//            clientSocket = serverSocket.accept(); // accept is een verborgen wachtlus
//        } catch (IOException e) {
//            System.err.println("Accept failed.");
//            System.exit(1);
//        }
//
//        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//        								// true = autoflush ON
//        BufferedReader in = new BufferedReader(	new InputStreamReader(
//				clientSocket.getInputStream()));
//        
//        String inputLine;
//        boolean gedaan = false;
//        char ch1, ch2;
//        
//        while (((inputLine = in.readLine()) != null) && !gedaan ) {
//               // controle aan de server-zijde
//             System.out.println("De client heeft " + inputLine + " getikt");
//             
//         		// tekstafhandeling
//             if (inputLine.length() >= 2 ){
//             	
//             	ch1 = inputLine.charAt(0);
//                ch2 = inputLine.charAt(1);
//                Date dd = new Date();
//                String temp = ""; 
//
//             	if (ch1 == '#'){
//             	
//             	  switch (ch2){
//
//             		case 'D' : case 'd' : // stuur datum terug
//             		   temp = ""+ dd.getDate() + "/" + (dd.getMonth()+1);
//             		   out.println("De datum is : "+ temp); break;
//
//             		case 'T' : case 't' : // stuur tijd terug
//             		   temp = dd.getHours()+ ":" + dd.getMinutes()+ ":" + dd.getSeconds();
//             		   out.println("De tijd is : "+ temp);break;
//             		   
//             		case 'Q' : case 'q' :
//             		   out.println("EINDE");
//             		   gedaan = true; break;
//             		   
//             		default : out.println("invalid command (use #D, #T or #Q)");
//             	  }
//                }
//                
//                else {
//                   out.println(inputLine);  // stuur gewoon dezelfde tekst(>=2) terug
//              }}
//              else {
//                   out.println(inputLine);  // stuur gewoon dezelfde tekst(1 char) terug
//              }
//             
//             
//        }
//        
//        // dit werkt niet goed, je moet eerst nog een Enter tikken ...
//        if (gedaan){
//             	out.println("Tot later - Ik sluit de verbinding, je moet dus niets meer tikken !");
//                out.flush();
//               }
//               
//        out.close();
//        in.close();
//        clientSocket.close();// verbreek de verbinding
//        serverSocket.close();// stop de server
//    }
//}
