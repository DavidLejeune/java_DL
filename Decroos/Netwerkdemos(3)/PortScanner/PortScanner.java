import java.io.*;
import java.net.*;

   // een externe computer onderzoeken
//public class PortScanner {
//    public static void main(String[] args) throws IOException {
//        Socket echoSocket = null;
//        
//        //adres zoeken ? http://www.nslookup.be/
//        //vb khbo.be=
//        //String host = "193.190.77.1"; // drie mogelijkheden
//        String host = "193.190.77.43";
//        
//        int poort = 0;
//        
//        for (poort = 80; poort < 5000; poort++){
//           try {
//        		echoSocket = new Socket(host, poort ); // pc-naam of ip-adres
//        		// als dit lukt is de poort in gebruik
//        	    System.out.println("poort " + poort + " is in gebruik");
//                echoSocket.close();
//           }
//        
//           catch (IOException e) {
//	         System.out.println("Verbinding mislukt met adres " + host + ":"  + poort); 
//           }
//        }
//   }
//}


// enkel eigen computer onderzoeken, geen hostadres nodig

public class PortScanner {
    
    public static void main(String[] args) throws IOException {
       
       ServerSocket serverSocket = null;
       for (int poort = 0; poort<1000; poort++){
       	 try {
            serverSocket = new ServerSocket( poort );
            serverSocket.close();
            
         } 
		 catch (IOException e) {
		 	System.out.println ("poort " + poort + " is in gebruik\n");
         }

   }
}
}