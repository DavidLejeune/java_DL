
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.applet.*;
import java.awt.Font;
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
public class MijnVenster1 extends javax.swing.JFrame {

    /**
     * Creates new form MijnVenster1
     */
    public MijnVenster1() {
        initComponents();
        
        
        
        buttonArray = new String[] {"0","1","2","3","4","5","6","7","8","9","#","0","*"};
        soundArray = new String[] {"s1.wav","s2.wav","s3.wav","s4.wav","s5.wav","s6.wav","s7.wav","s8.wav","s9.wav","s10.wav","s11.wav","s12.wav"};
        kh = new KnopHandler();
        
        

        knoppenGrid = new JButton[4][3];//(her)maak de array

        CenterPaneel.removeAll(); // anders worden knoppen bijgevoegd

        // nieuwe GridLayout anders bvb 9 knoppen in een 5x5 rooster ...
        CenterPaneel.setLayout(new GridLayout(4,3,5,5));
        knopId = 0;
        for (int rij=0; rij<4; rij++)
		for (int kolom=0; kolom<3; kolom++){
                        knopId++;
			knoppenGrid[rij][kolom] = maakKnop (CenterPaneel, rij,kolom);
			                          // gebruik de factory method !
                                                  // juiste paneel meegeven als argument !
    	}
        // om de knoppen zichtbaar te krijgen
        CenterPaneel.doLayout(); 
        
    }
    
        public JButton maakKnop( JPanel p,  int rij, int kolom ) {
            
       // JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
            String iValue1 = buttonArray[knopId];
            JButton knop = new JButton( "" + iValue1 + "");
       knop.setBackground( Color.gray );
       knop.addActionListener( kh );
       knop.setFont(new Font("Courier New", Font.BOLD, 44));
       p.add( knop );
       return knop; // stuur ref terug om in array op te bergen
    }
     
    class KnopHandler implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            // zoek op welke knop er geklikt werd 
            int knopId2 = 0;
            for (int rij=0; rij<4; rij++){
                   for (int kolom=0; kolom<3; kolom++){
                        // dan was het die knop waarop je geklikt had
                       
                       //String iValue2 = soundArray[knopId2];
                       //DialedNr.setText(""+ e.getSource().toString());
                        if (e.getSource() == knoppenGrid[rij][kolom] ){ 
                                // doe iets met de knop in kwestie
                            String buttonText = knoppenGrid[rij][kolom].getText();
                            
                            DialedNr.setText(DialedNr.getText() + knoppenGrid[rij][kolom].getText());
                            
                            int index = kolom + ((rij )*3);
                            System.out.println("rij" + rij);
                            System.out.println("kolom" + kolom);
                            
                            System.out.println("geluid : "+ index);
                            
                            String iValue2 = soundArray[index];
                            System.out.println("" + iValue2);
                            AudioClip clip = java.applet.Applet.newAudioClip(getClass().getResource(iValue2));
                            //clip = java.applet.Applet.newAudioClip(getClass().getResource("geluidje.wav")); 
                            clip.play();
                            
                            
                            
                            
                            
                            
                            
                            
                         //      if (knoppenGrid[rij][kolom].getBackground().equals (Color.green)) 
                                   
                         //          knoppenGrid[rij][kolom].setBackground (Color.red);
                               
                         //       else knoppenGrid[rij][kolom].setBackground (Color.green);
                        }
                    }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ZuidPaneel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        DialedNr = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        CenterPaneel = new javax.swing.JPanel();
        NoordPaneel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        ZuidPaneel.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        DialedNr.setBackground(new java.awt.Color(0, 204, 204));
        DialedNr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton2.setText("Dial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ZuidPaneelLayout = new javax.swing.GroupLayout(ZuidPaneel);
        ZuidPaneel.setLayout(ZuidPaneelLayout);
        ZuidPaneelLayout.setHorizontalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZuidPaneelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(DialedNr, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ZuidPaneelLayout.setVerticalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZuidPaneelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZuidPaneelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30))
                    .addGroup(ZuidPaneelLayout.createSequentialGroup()
                        .addComponent(DialedNr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.add(ZuidPaneel, java.awt.BorderLayout.SOUTH);

        CenterPaneel.setBackground(new java.awt.Color(0, 0, 0));
        CenterPaneel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        javax.swing.GroupLayout CenterPaneelLayout = new javax.swing.GroupLayout(CenterPaneel);
        CenterPaneel.setLayout(CenterPaneelLayout);
        CenterPaneelLayout.setHorizontalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        CenterPaneelLayout.setVerticalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jPanel1.add(CenterPaneel, java.awt.BorderLayout.CENTER);

        NoordPaneel.setBackground(new java.awt.Color(0, 0, 0));
        NoordPaneel.setPreferredSize(new java.awt.Dimension(437, 70));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 51));
        jLabel1.setText("D-phone");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("because iPhone sucks");

        javax.swing.GroupLayout NoordPaneelLayout = new javax.swing.GroupLayout(NoordPaneel);
        NoordPaneel.setLayout(NoordPaneelLayout);
        NoordPaneelLayout.setHorizontalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NoordPaneelLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(153, 153, 153))
        );
        NoordPaneelLayout.setVerticalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoordPaneelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        jPanel1.add(NoordPaneel, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DialedNr.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nr2dial = DialedNr.getText();
        
        int index2 = 0 ;
        
        
        for (int i = 0;i < nr2dial.length(); i++){
            System.out.println(nr2dial.charAt(i));
            
            
            switch(nr2dial.charAt(i))
            {
                case '1':
                    index2 = 1;
                    break;
                case '2':
                    index2 = 2;
                    break;
                case '3':
                    index2 = 3;
                    break;
                case '4':
                    index2 = 4;
                    break;
                case '5':
                    index2 = 5;
                    break;
                case '6':
                    index2 = 6;
                    break;
                case '7':
                    index2 = 7;
                    break;
                case '8':
                    index2 = 8;
                    break;
                case '9':
                    index2 = 9;
                    break;
                case '#':
                    index2 = 10;
                    break;
                case '0':
                    index2 = 11;
                    break;
                case '*':
                    index2 = 12;
                    break;
                    
                
            }
            
                            String iValue2 = soundArray[index2];
                            System.out.println("" + iValue2);
                            AudioClip clip = java.applet.Applet.newAudioClip(getClass().getResource(iValue2));
                            //clip = java.applet.Applet.newAudioClip(getClass().getResource("geluidje.wav")); 
                            clip.play();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(MijnVenster1.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
                            
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MijnVenster1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MijnVenster1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MijnVenster1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MijnVenster1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MijnVenster1().setVisible(true);
            }
        });
    }

    
    private int knopId,knopId2;
    private JButton[][] knoppenGrid;
    private KnopHandler kh;
    private int buttonID;
    private String[] buttonArray;
    private String[] soundArray;
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPaneel;
    private javax.swing.JTextField DialedNr;
    private javax.swing.JPanel NoordPaneel;
    private javax.swing.JPanel ZuidPaneel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}