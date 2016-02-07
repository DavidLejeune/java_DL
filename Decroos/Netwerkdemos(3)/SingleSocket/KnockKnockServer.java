import java.net.*;
import java.io.*;

public class KnockKnockServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        System.out.println("Server draait");
        
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        System.out.println("Client heeft verbinding gezocht ");
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine, outputLine;
        
        KnockKnockProtocol kkp = new KnockKnockProtocol(); // een "parser"

        outputLine = kkp.processInput(null);// met null krijg je een "startzin"
        out.println(outputLine); // stuur die naar de client (Knock Knock)
        
        

        while ((inputLine = in.readLine()) != null) {
             outputLine = kkp.processInput(inputLine);
             out.println(outputLine);
             if (outputLine.equals("Bye."))
                break;
        }
        
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
