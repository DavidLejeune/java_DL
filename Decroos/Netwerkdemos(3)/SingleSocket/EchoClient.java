
import java.io.*;
import java.net.*;
//uit : de java turorial
//http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html

public class EchoClient {

    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        String host = "localhost"; // drie mogelijkheden
        //String host = "127.0.0.1";
        //String host = "pca01a.khbo.be";

        //of nog : de ftp server van khbo/vives:
        //String host = "193.190.77.43"; //extern
        //String host = "10.1.14.10";// intern

        try {
            echoSocket = new Socket(host, 4444); // pc-naam of ip-adres + poort
            	// of de ftp server gebruiken:
            	// echoSocket = new Socket(host, 8081 ); // pc-naam of ip-adres
            
            // twee verbindingskanalen openen
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in  = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } 
        catch (UnknownHostException e) {
            System.err.println("Don't know about host" + host);
            System.exit(1); // kan beter met booleans ...enz
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + host);
            System.exit(1);
        }


        BufferedReader toetsenbord = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;
        String serverReply;
        boolean gedaan = false;

        while (((userInput = toetsenbord.readLine()) != null) && !gedaan) {
            out.println(userInput); // zend ingetikte tekst naar server
            serverReply = in.readLine();
            System.out.println("echo: " + serverReply);
            if (serverReply.equals("EINDE")) {
                gedaan = true;
            }
        }

        out.close();
        in.close();
        toetsenbord.close();
        echoSocket.close();
    }
}