import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServerThread extends QuoteServerThread {

    private final long FIVE_SECONDS = 5000;

    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }

    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];

                    // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();

		    // send it                                   //de group identifier 
                InetAddress group = InetAddress.getByName("230.0.0.1");
                     // 230 is enkel voor "documentation", de echte Multicast adressen = 224...)
                     // zie http://en.wikipedia.org/wiki/IPv4#Allocation
                     // en http://en.wikipedia.org/wiki/IP_multicast
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                
                socket.send(packet); // gewoon zenden, niet wachten op client !

		    // sleep for a while
		try {
		    // omdat we in een Thread subklasse zitten, kunnen we direct sleep() oproepen
		    sleep((long)( FIVE_SECONDS));
		} catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
				moreQuotes = false;
            }
        }
	  socket.close();
    }
}
