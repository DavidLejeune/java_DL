
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class MijnVenster extends javax.swing.JFrame {

    /**
     * Creates new form MijnVenster
     */
    public MijnVenster() {
        initComponents();
        
        klokje = new Klokske();
	klokje.start();                   

	lblSearch.hide();
        txtZoekVeld.hide();
        btnZoek.hide();
        
        
        txtTerminal.setEditable(false);
        
        String username = System.getProperty("user.name");
        lblUsername.setText(""+username);
        
        
        
//        KnockKnockClient kkc = new KnockKnockClient(txtTerminal, txtZoekVeld);      
//        kkc.start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hoofdPaneel = new javax.swing.JPanel();
        centerPaneel = new javax.swing.JPanel();
        txtZoekVeld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTerminal = new javax.swing.JTextArea();
        btnZoek = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        lblUur = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        hoofdPaneel.setLayout(new java.awt.BorderLayout());

        centerPaneel.setBackground(new java.awt.Color(0, 0, 0));

        txtZoekVeld.setBackground(new java.awt.Color(51, 51, 51));
        txtZoekVeld.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        txtZoekVeld.setForeground(new java.awt.Color(255, 255, 255));

        txtTerminal.setBackground(new java.awt.Color(0, 0, 0));
        txtTerminal.setColumns(20);
        txtTerminal.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        txtTerminal.setForeground(new java.awt.Color(255, 204, 0));
        txtTerminal.setRows(5);
        jScrollPane1.setViewportView(txtTerminal);

        btnZoek.setBackground(new java.awt.Color(0, 0, 204));
        btnZoek.setFont(new java.awt.Font("OCR A Extended", 0, 13)); // NOI18N
        btnZoek.setForeground(new java.awt.Color(255, 255, 255));
        btnZoek.setText("Search Database");
        btnZoek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoekActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(204, 204, 255));
        lblSearch.setText("Search : ");

        lblUur.setBackground(new java.awt.Color(0, 0, 204));
        lblUur.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        lblUur.setForeground(new java.awt.Color(0, 0, 204));
        lblUur.setText("jLabel1");

        jLabel15.setBackground(new java.awt.Color(0, 0, 204));
        jLabel15.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Client of the MultiServer");

        btnStart.setBackground(new java.awt.Color(0, 0, 204));
        btnStart.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Start Client");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 204));
        jLabel10.setText("Welcome,");

        lblUsername.setBackground(new java.awt.Color(0, 0, 204));
        lblUsername.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(51, 51, 255));
        lblUsername.setText("Welcome,");

        javax.swing.GroupLayout centerPaneelLayout = new javax.swing.GroupLayout(centerPaneel);
        centerPaneel.setLayout(centerPaneelLayout);
        centerPaneelLayout.setHorizontalGroup(
            centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPaneelLayout.createSequentialGroup()
                .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(centerPaneelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(centerPaneelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(centerPaneelLayout.createSequentialGroup()
                                .addComponent(txtZoekVeld, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnZoek)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUur, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(32, 46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPaneelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPaneelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPaneelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername)
                        .addGap(15, 15, 15))))
        );
        centerPaneelLayout.setVerticalGroup(
            centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPaneelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblUsername))
                .addGap(12, 12, 12)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtZoekVeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZoek)
                    .addComponent(lblUur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addContainerGap())
        );

        hoofdPaneel.add(centerPaneel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZoekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoekActionPerformed
    String zin = txtZoekVeld.getText();
      txtTerminal.append ( "Client request : " + zin + "\n"); // eigen tekst naar ta
      try{
      	out.println(zin);
        zin = in.readLine();
      }
      catch (IOException foutje){
      	 txtTerminal.append("ERROR 404... \n");
      }

      String zin2 ;
      zin2 = zin.replaceAll("xxxx", "\n");
      
      txtTerminal.append ( "Server response : " + zin2 + "\n"); // tekst van server (echo)
      txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
      txtZoekVeld.setText("");
    }//GEN-LAST:event_btnZoekActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        maakVerbinding();

    }//GEN-LAST:event_btnStartActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MijnVenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MijnVenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MijnVenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MijnVenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MijnVenster().setVisible(true);
            }
        });
    }

    public void maakVerbinding()
    {
         try {
            echoSocket = new Socket(host, 4444 ); // pc-naam of ip-adres
            
            txtTerminal.append("[OK] Connection with the server has been established\n");
            btnStart.hide();           
            lblSearch.show();
            txtZoekVeld.show();
            btnZoek.show();
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in  = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            txtTerminal.append("Don't know about host" + host + "\n");
            System.err.println("Don't know about host" + host);
            //System.exit(1);
        } catch (IOException e) {
            txtTerminal.append("Couldn't get I/O for "
                               + "the connection to: " + host + "\n");
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + host);
            //System.exit(1);
        }

    }
    
   // netwerk objecten
  private Socket         echoSocket = null;
  private PrintWriter    out = null;
  private BufferedReader in = null;
  private String host = "localhost";
    private Klokske klokje;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnZoek;
    private javax.swing.JPanel centerPaneel;
    private javax.swing.JPanel hoofdPaneel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUur;
    private javax.swing.JTextArea txtTerminal;
    private javax.swing.JTextField txtZoekVeld;
    // End of variables declaration//GEN-END:variables

class Klokske extends Thread {
  	
    // geen constructor nodig --> automatic default constructor
  	
  	public void run(){
          Calendar cd;   
          Graphics2D g1 = (Graphics2D) getGraphics();  
  	  while (true){
       
		
		cd = Calendar.getInstance();
                //local time
                int uren = cd.get(Calendar.HOUR_OF_DAY); 
                int minuten = cd.get(Calendar.MINUTE); 
                int seconden = cd.get(Calendar.SECOND);
		lblUur.setText("" + String.format("%02d", uren) + ":"+ String.format("%02d", minuten) + ":"+ String.format("%02d", seconden)) ;
                //Washington time
                int urenW = uren -6;
                if(urenW < 0) 
                {
                    urenW = urenW+ 24;
                }
                //ArRaqqah time
                  int urenR = uren + 1;
                if(urenR > 23) 
                {
                    urenR = urenR -  24;
                }

            // teken het analoge klokje 
            g1.setColor(Color.BLUE);
            g1.drawOval(50, 50, 100, 100); 
                
            g1.setColor(Color.WHITE);
            g1.fillArc(50, 50, 100, 100,90 - (30 * uren),3)  ;
            g1.setColor(Color.BLUE);
            g1.fillArc(50, 50, 100, 100,90 - (6*minuten),3)  ;
            g1.setColor(Color.YELLOW);
            g1.fillArc(50, 50, 100, 100,90 - (6*seconden),3)  ;  
                
                
                                       
        repaint();
  	  }
  	  
  	}

}

}








class KnockKnockClient extends Thread{
    
    
    private javax.swing.JTextArea txtTerminal;
    private javax.swing.JTextField txtZoekVeld;
    
    public KnockKnockClient (javax.swing.JTextArea txtTerminal,javax.swing.JTextField txtZoekVeld)
    {
        this.txtTerminal = txtTerminal;
        this.txtZoekVeld = txtZoekVeld;
    }
    
    
    public void run() {
        
         Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress addr;
		String host;
		
        try {
        	//terloops een demo van een statische methode uit InetAddress
        	addr = InetAddress.getByName("localhost");
        	//addr = InetAddress.getByName("pcb401a.khbo.be");
            txtTerminal.append("\nComputer has IP address " + addr.toString());
        	System.out.println("Computer has IP address " + addr.toString());
            
            host = "localhost";
            kkSocket = new Socket(host, 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } 
        catch (UnknownHostException e) {
            txtTerminal.append("\nDon't know about host");
            System.err.println("Don't know about host");
            //System.exit(1);
        }
        catch (IOException e) {
            txtTerminal.append("\nCouldn't get I/O for the connection");
            System.err.println("Couldn't get I/O for the connection");
            //System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        try {
            while ((fromServer = in.readLine()) != null) {
            txtTerminal.append("\nServer: " + fromServer);
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye.")) break;
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
            txtTerminal.append("\nClient: " + fromUser);
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.close();
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stdIn.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kkSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(KnockKnockClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    

