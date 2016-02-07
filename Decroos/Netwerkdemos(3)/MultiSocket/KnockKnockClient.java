import java.io.*; 
import java.net.*;

public class KnockKnockClient {
    public static void main(String[] args) throws IOException {

        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress addr;
		String host;
		
        try {
        	//terloops een demo van een statische methode uit InetAddress
        	addr = InetAddress.getByName("localhost");
        	//addr = InetAddress.getByName("pcb401a.khbo.be");
        	System.out.println("Computer heeft IP adres " + addr.toString());
            
            host = "localhost";
            kkSocket = new Socket(host, 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } 
        catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if (fromServer.equals("Bye.")) break;
		    
            fromUser = stdIn.readLine();
	        if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
	        }
        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}
