import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteServerThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public QuoteServerThread() throws IOException {
	  this("QuoteServerThread");
    }
                                          // "vuile truc" : sla alle IO-fouten over
    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4445); // luister naar clients op poort 4445

        try {
        	 // zet bestand met "spreuken" open
            in = new BufferedReader(new FileReader("one-liners.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open quote file. Serving time instead.");
        }
    }

    public void run() {

        while (moreQuotes) { // zolang er spreuken zijn ...
            try {
                byte[] buf = new byte[256]; // byte buffer voor "packet"

                    // maak de buffer klaar voor ontvangst
                    // constructor met 2 argumenten
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet); 
                	// verborgen wachtlus zoals de accept
                	// wacht tot een client een spreuk vraagt

                    // bepaal wat er moet geantwoord worden
                String dString = null;
                if (in == null) // mocht bestand niet bestaan, zend de datum
                    dString = new Date().toString();
                else
                    dString = getNextQuote(); // lees de volgende spreuk
                    
                buf = dString.getBytes(); // zet om in bytes (in buffer)

		             // zend terug naar de client (vereist adress en poort)
                InetAddress address = packet.getAddress();
                int port            = packet.getPort();
                         // nu andere constructor : 4 args nodig
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            } 
            catch (IOException e) {
                e.printStackTrace();
		        moreQuotes = false;
            }
        }
        socket.close();
    }

    protected String getNextQuote() { // lees de volgende spreuk (1 per 1)
        String returnValue = null;
        try {
        	   // waarom hier niet met while ??
            if ((returnValue = in.readLine()) == null) {
                in.close();
		        moreQuotes = false;
                returnValue = "No more quotes. Goodbye.";
            }
        } catch (IOException e) {
            returnValue = "IOException occurred in server.";
        }
        return returnValue;
    }
}
