
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        
        //center screen
        this.setLocationRelativeTo(null);
        txtTerminal.setEditable(false);
        

        //toon de username in een label 
        String username = System.getProperty("user.name");
        lblUsername.setText(""+username);
        
        
        
        
        //verbergen addtolog interface
        jLabel2.hide();
        jLabel3.hide();
        jLabel4.hide();
        txtNaam.hide();
        txtKlas.hide();
        txtJaar.hide();
        btnAddToDatabase.hide();
        
        
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
        topPaneel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        centerPaneel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTerminal = new javax.swing.JTextArea();
        zuidPaneel = new javax.swing.JPanel();
        lblUur = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNaam = new javax.swing.JTextField();
        txtKlas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJaar = new javax.swing.JTextField();
        btnAddToDatabase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        hoofdPaneel.setLayout(new java.awt.BorderLayout());

        topPaneel.setBackground(new java.awt.Color(0, 0, 0));
        topPaneel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 0));
        jLabel15.setText("Master of the MultiServer");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 204));
        jLabel10.setText("Welcome,");

        lblUsername.setBackground(new java.awt.Color(255, 0, 0));
        lblUsername.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 51, 0));
        lblUsername.setText("Welcome,");

        javax.swing.GroupLayout topPaneelLayout = new javax.swing.GroupLayout(topPaneel);
        topPaneel.setLayout(topPaneelLayout);
        topPaneelLayout.setHorizontalGroup(
            topPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPaneelLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addGroup(topPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPaneelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPaneelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername)
                        .addGap(15, 15, 15))))
        );
        topPaneelLayout.setVerticalGroup(
            topPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPaneelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(topPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        hoofdPaneel.add(topPaneel, java.awt.BorderLayout.PAGE_START);

        centerPaneel.setBackground(new java.awt.Color(0, 0, 0));
        centerPaneel.setForeground(new java.awt.Color(255, 255, 255));

        txtTerminal.setBackground(new java.awt.Color(0, 0, 0));
        txtTerminal.setColumns(20);
        txtTerminal.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        txtTerminal.setForeground(new java.awt.Color(255, 255, 153));
        txtTerminal.setRows(5);
        jScrollPane1.setViewportView(txtTerminal);

        javax.swing.GroupLayout centerPaneelLayout = new javax.swing.GroupLayout(centerPaneel);
        centerPaneel.setLayout(centerPaneelLayout);
        centerPaneelLayout.setHorizontalGroup(
            centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPaneelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        centerPaneelLayout.setVerticalGroup(
            centerPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPaneelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        hoofdPaneel.add(centerPaneel, java.awt.BorderLayout.CENTER);

        zuidPaneel.setBackground(new java.awt.Color(0, 0, 0));
        zuidPaneel.setForeground(new java.awt.Color(255, 255, 255));

        lblUur.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        lblUur.setForeground(new java.awt.Color(255, 0, 0));
        lblUur.setText("jLabel1");

        btnStart.setBackground(new java.awt.Color(255, 0, 0));
        btnStart.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Name:");

        txtNaam.setBackground(new java.awt.Color(51, 51, 51));
        txtNaam.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        txtNaam.setForeground(new java.awt.Color(255, 255, 255));
        txtNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNaamActionPerformed(evt);
            }
        });

        txtKlas.setBackground(new java.awt.Color(51, 51, 51));
        txtKlas.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        txtKlas.setForeground(new java.awt.Color(255, 255, 255));
        txtKlas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKlasActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Class :");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Year :");

        txtJaar.setBackground(new java.awt.Color(51, 51, 51));
        txtJaar.setFont(new java.awt.Font("OCR A Extended", 0, 16)); // NOI18N
        txtJaar.setForeground(new java.awt.Color(255, 255, 255));
        txtJaar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJaarActionPerformed(evt);
            }
        });

        btnAddToDatabase.setBackground(new java.awt.Color(255, 0, 0));
        btnAddToDatabase.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        btnAddToDatabase.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToDatabase.setText("Add to Database");
        btnAddToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout zuidPaneelLayout = new javax.swing.GroupLayout(zuidPaneel);
        zuidPaneel.setLayout(zuidPaneelLayout);
        zuidPaneelLayout.setHorizontalGroup(
            zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zuidPaneelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zuidPaneelLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2)
                    .addGroup(zuidPaneelLayout.createSequentialGroup()
                        .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtKlas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(zuidPaneelLayout.createSequentialGroup()
                        .addComponent(txtJaar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddToDatabase)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart)
                    .addComponent(lblUur))
                .addGap(36, 36, 36))
        );
        zuidPaneelLayout.setVerticalGroup(
            zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zuidPaneelLayout.createSequentialGroup()
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKlas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJaar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(zuidPaneelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(zuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zuidPaneelLayout.createSequentialGroup()
                        .addComponent(lblUur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnStart)
                        .addGap(18, 18, 18))
                    .addGroup(zuidPaneelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnAddToDatabase)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(zuidPaneel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(zuidPaneel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        StartServer();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void txtNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNaamActionPerformed

    private void txtKlasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKlasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKlasActionPerformed

    private void txtJaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJaarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJaarActionPerformed

    private void btnAddToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToDatabaseActionPerformed

        naam =  txtNaam.getText();
        //textveld naam is verplicht anders krijgt mijn lege records in de database
        if(!naam.equals(""))
        {
            klas =  txtKlas.getText();
            jaar = txtJaar.getText();
            Gegevens  tempGegevens = new Gegevens (naam, klas, jaar);

            // voeg dit object toe aan de lijst
            lijst.add (tempGegevens);
            txtTerminal.append("[OK] Database has been updated\n");
            ShowDatabase();
            txtKlas.setText("");
            txtJaar.setText("");
            //naam als laatste=>focus
            txtNaam.setText("");
            txtNaam.requestFocusInWindow();
        }
        else
        {
            txtTerminal.append("Error : no name entered.\n");
            txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
        }
        txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
    }//GEN-LAST:event_btnAddToDatabaseActionPerformed

  
         // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  


    
    public void StartServer()
    {
        //de database aanmaken   
        lijst = new ArrayList<>();
        txtTerminal.append("Creating the database.\n");
        //slaap(200);
        naam= "David";
        klas="1PB-ICT";
        jaar = "1977";
        Gegevens  tempGegevens = new Gegevens (naam, klas, jaar); 
        lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Bert", "2PB-EO", "1996"); 
     	lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Milan", "2PB-ICT", "1993"); 
     	lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Jonas", "2PB-ICT", "1994"); 
     	lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Charlie", "2PB-EO", "1997"); 
     	lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Nicolas", "2PB-ICT", "1998"); 
     	lijst.add (tempGegevens);
        tempGegevens = new Gegevens ("Mathias", "2PB-ICT", "1997"); 
     	lijst.add (tempGegevens);
        txtTerminal.append("Database created.\n");
        
        ShowDatabase();
        
        
            
           //starting the server
            txtTerminal.append("Starting the server" + "\n");
            //slaap(200);
            KKMultiServer kms = new KKMultiServer(txtTerminal,lijst,btnStart, jLabel2 , jLabel3 ,jLabel4, txtNaam ,txtKlas, txtJaar, btnAddToDatabase);      
            kms.start();
            
            
            
            
    }
    
    
    public void ShowDatabase()
    {
        
        
        //display the database
        txtTerminal.append("Showing Database.\n");
        //slaap(200);
        int iCount = 0;
        //database header
        txtTerminal.append("Name\tClass\tYear\n" + "====\t====\t====" + "\n");
        // importing the dtabase arraylist       
        for (Gegevens str : lijst)
                    {
                        //replace the , with a tab special character    
                        String resultaat = "" + str;
                        resultaat = resultaat.replaceAll(",", "\t");
                        iCount++;
                        //show the line in the database
                        txtTerminal.append(resultaat + "\n");
                    }
        txtTerminal.append("Database contains " + iCount + " records." + "\n");
        txtTerminal.setCaretPosition(txtTerminal.getDocument().getLength());
     
        
    }
    
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

    
    private Klokske klokje;
    String naam,klas,jaar;
    private ArrayList<Gegevens> lijst;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToDatabase;
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel centerPaneel;
    private javax.swing.JPanel hoofdPaneel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUur;
    private javax.swing.JPanel topPaneel;
    private javax.swing.JTextField txtJaar;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextArea txtTerminal;
    private javax.swing.JPanel zuidPaneel;
    // End of variables declaration//GEN-END:variables

class Klokske extends Thread {
  	
    // geen constructor nodig --> automatic default constructor
  	
  	public void run(){
            
          Graphics2D g1 = (Graphics2D) getGraphics();  
  	  while (true){
       
		Calendar cd; 
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
                              
             
           g1.setColor(Color.RED);
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




















  	









































