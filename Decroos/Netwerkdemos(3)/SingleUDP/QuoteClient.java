import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteClient {
    public static void main(String[] args) throws IOException {

            // get a datagram socket
        DatagramSocket socket = new DatagramSocket();

            // send request
        byte[] buf = new byte[256];

        InetAddress address = InetAddress.getByName("localhost");
           // pakket voor server klaarmaken, adres en poort nodig
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
    
            // get response
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet); //verborgen wachtlus

	    // display response
        String received = new String(packet.getData());
        System.out.println("Quote of the Moment: " + received);
    
        socket.close();
        
        
    }
}
