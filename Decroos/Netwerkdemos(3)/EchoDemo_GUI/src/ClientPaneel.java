/* 
 * Naam : Luc Decroos - KHBO - 2007
 * 
 * Beschrijving : EchoServer (console) + EchoClient GUI versie
 * datum gestart : 071024
 * datum gestopt : 071024
 *
 *
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ClientPaneel extends JPanel {
    // declaraties van de variabelen
    
    // referenties naar objecten 
  private JPanel controlepaneel;
  private JButton knop;
  private JTextField adresvak, invoervak;
  private JLabel l1;
  
  private JScrollPane sp;
  private JTextArea ta;
  
   // netwerk objecten
  private Socket         echoSocket = null;
  private PrintWriter    out = null;
  private BufferedReader in = null;
    
  private String host = "";
  
    // Constructor
  public ClientPaneel() {
  	
  	setLayout (new BorderLayout());
  	
  	controlepaneel = new JPanel();
  	controlepaneel.setLayout(new FlowLayout());
  	
    adresvak = new JTextField( 10 );
    adresvak.setText("localhost");
    
    knop = new JButton( "Connect" );
    knop.addActionListener( new ConnectKnopHandler() );
    
    controlepaneel.add( adresvak );
    controlepaneel.add( knop );
    
    
    
    ta = new JTextArea(24,60);
    ta.setEditable(false); // je mag er niet in schrijven
    sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    invoervak = new JTextField(60);
    invoervak.addActionListener(new VakHandler());
    
    add( controlepaneel, BorderLayout.NORTH);                        
    add (sp , BorderLayout.CENTER);
    add (invoervak, BorderLayout.SOUTH );
    
       
    
  }
  
      // interne klasse voor event-handler
  class ConnectKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
      host = adresvak.getText(); 
      maakVerbinding();
    }
  }
  
  
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String zin = invoervak.getText();
      ta.append ( "Client stuurde " + zin + " naar de server\n"); // eigen tekst naar ta
      try{
      	out.println(zin);
        zin = in.readLine();
      	
      }
      catch (IOException foutje){
      	 ta.append("Er is ergens iets mis hoor .... \n");
      }
      
      
      
      ta.append ( "Server zegt : " + zin + "\n"); // tekst van server (echo)
      invoervak.setText("");
      
    }
  }
  
  
  public void maakVerbinding(){

    
        try {
            echoSocket = new Socket(host, 4444 ); // pc-naam of ip-adres
            
            ta.append("Er is verbinding met de server ...\n");
            
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

  }
  
}