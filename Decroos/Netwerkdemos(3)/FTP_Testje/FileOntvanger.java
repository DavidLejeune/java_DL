/**
 * @(#)FileOntvanger.java
 *
 *
 * @author 
 * @version 1.00 2009/11/10
 */
import java.io.*;
import java.net.*;

public class FileOntvanger {

    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out   = null;
        BufferedReader in = null;
        
        String host = "localhost"; // drie mogelijkheden
        //String host = "10.1.1.101";
        //String host = "pca01a.khbo.be";
    
        try {
            echoSocket = new Socket(host, 4444 ); // pc-naam of ip-adres
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in  = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host" + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + host);
            System.exit(1);
        }

    
	BufferedReader toetsenbord = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
	String serverReply;
    boolean gedaan  = false;

	while (((userInput = toetsenbord.readLine()) != null) && !gedaan ) {
	    out.println(userInput); // zend ingetikte tekst naar server
	    serverReply = in.readLine();
	    System.out.println("echo: " + serverReply );
	    if (serverReply.equals("EINDE")) gedaan = true;
	}

	out.close();
	in.close();
	toetsenbord.close();
	echoSocket.close();
    }
    
}