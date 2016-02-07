import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastClient {

    public static void main(String[] args) throws IOException {

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress address = InetAddress.getByName("230.0.0.1");
	    socket.joinGroup(address); // sluit aan bij die groep

        DatagramPacket packet;
    
            // get a few quotes
	for (int i = 0; i < 5; i++) {

	    byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet); // wacht hier tot de server iets gestuurd heeft

				// bepaal de tekst van de boodschap
            String received = new String(packet.getData());
                // en druk hem af
            System.out.println("Quote of the Moment: " + received);
	}
            // verlaat de groep
	socket.leaveGroup(address);
	socket.close();
    }

}
