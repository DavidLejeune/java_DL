
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Klikspel extends javax.swing.JFrame {

    /**
     * Creates new form Klikspel
     */
    public Klikspel() {
        initComponents();
        
        
                dim = 3;
        
        knoppenGrid = new JButton[dim][dim];//(her)maak de array
            
        CenterPaneel.removeAll(); // anders worden knoppen bijgevoegd

        // nieuwe GridLayout anders bvb 9 knoppen in een 5x5 rooster ...
        CenterPaneel.setLayout(new GridLayout(dim,dim,5,5));

        for (int rij=0; rij<dim; rij++)
		for (int kolom=0; kolom<dim; kolom++){
			knoppenGrid[rij][kolom] = maakKnop1 (CenterPaneel, rij,kolom);
			                          // gebruik de factory method !
                                                  // juiste paneel meegeven als argument !
    	}
        // om de knoppen zichtbaar te krijgen
        CenterPaneel.doLayout(); 
        
        
        
    }

      public JButton maakKnop1( JPanel p,  int rij, int kolom ) {
       //JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
          JButton knop = new JButton( "" ); 
       knop.setBackground( Color.blue );
       kh = new KnopHandler();
       
       knop.addActionListener( kh );
       p.add( knop );
       return knop; // stuur ref terug om in array op te bergen
       
       
    }
    
      
            public JButton maakKnop2( JPanel p,  int rij, int kolom ) {
       //JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
                ImageIcon figuur; 
                figuur= new ImageIcon(getClass().getResource("get_photo_inv.jpg")); 
                JButton knop = new JButton (figuur); 
                  //JButton knop = new JButton();
                  //JButton knop = new JButton(new ImageIcon("resources/get_photo_inv.jpg"));
//                try 
//                {
//                  Image img = ImageIO.read(getClass().getResource("src/get_photo_inv.jpg"));
//                  knop.setIcon(new ImageIcon(img));
//                } 
//                catch (IOException ex) 
//                {
//                }
  
  
//                ImageIcon figuur; 
//                figuur= new ImageIcon(getClass().getResource("src/get_photo_inv.jpg")); 
//                JButton knop = new JButton (figuur); 
                
          //JButton knop = new JButton( "" ); 
       knop.setBackground( Color.black );
                  //knop.setIcon(new ImageIcon("resources/get_photo_inv.jpg"));
       kh = new KnopHandler();
       
       knop.addActionListener( kh );
       p.add( knop );
       return knop; // stuur ref terug om in array op te bergen
       
       
    }

      
      
          class KnopHandler implements ActionListener {
        
        public void actionPerformed( ActionEvent e ) {
            // zoek op welke knop er geklikt werd 
            
            if (start)
            {
            Boolean found= false;
            
            for (int rij=0; rij<dim; rij++){
                   for (int kolom=0; kolom<dim; kolom++){
                        // dan was het die knop waarop je geklikt had
                        if (e.getSource() == knoppenGrid[rij][kolom] ){ 
                                // doe iets met de knop in kwestie
                            System.out.println(rij + " " + " " + kolom);
                            
                            if(rij==0)
                            {
                                if(kolom==2)
                                {
                                    found =true;
                                    System.out.println("clicked");    
                                }
                            }
                             if(rij==1)
                            {
                                if(kolom==1)
                                {
                                    found =true;
                                }
                            }                            
                             if(rij==2)
                            {
                                if(kolom==0)
                                {
                                    found =true;
                                }
                            }                           
                                
                            if (found)
                            {
                                if (!knoppenGrid[rij][kolom].getBackground().equals (Color.blue)) {
                                ImageIcon figuur; 
                                figuur= new ImageIcon(getClass().getResource("get_photo.jpg")); 
                                knoppenGrid[rij][kolom].setIcon(figuur); 
                              iCorrect++;
                                knoppenGrid[rij][kolom].setBackground (Color.blue);
                                iCount++;
                                }
                                
                            }
                            else
                            {
                                if (!knoppenGrid[rij][kolom].getBackground().equals (Color.red)) {
                                knoppenGrid[rij][kolom].setBackground (Color.red);
                                iCount++;
                                }
                            }
                            
                            
                            
                            lblTicker.setText("Attempt nr " + iCount + " and " + iCorrect +" correct");
                            if(iCount==6)
                            {
                                lblTicker.setForeground(Color.red);
                                lblTicker.setText("Game is over, you lose!!");
                            }

                            if(iCorrect==3)
                            {
                                lblTicker.setForeground(Color.green);
                                lblTicker.setText("Winner winner chicken dinner!! Terrorist located");
                            }

                             if(iCount>6)
                            {
                                lblTicker.setForeground(Color.pink);
                                lblTicker.setText("You should restart the game");
                            }

                                                       
                            
//                                if (knoppenGrid[rij][kolom].getBackground().equals (Color.blue)) 
//                                    knoppenGrid[rij][kolom].setBackground (Color.red);
//                                else knoppenGrid[rij][kolom].setBackground (Color.black);
                            
                            
                            
                            
                            
                        }
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

        NoordPaneel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ZuidPaneel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTicker = new javax.swing.JLabel();
        CenterPaneel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NoordPaneel.setBackground(new java.awt.Color(0, 0, 0));
        NoordPaneel.setForeground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("<html><marquee direction=left>Click me</marquee></html>");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("The number 1 game no-where");

        javax.swing.GroupLayout NoordPaneelLayout = new javax.swing.GroupLayout(NoordPaneel);
        NoordPaneel.setLayout(NoordPaneelLayout);
        NoordPaneelLayout.setHorizontalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoordPaneelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NoordPaneelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        NoordPaneelLayout.setVerticalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoordPaneelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        getContentPane().add(NoordPaneel, java.awt.BorderLayout.PAGE_START);

        ZuidPaneel.setBackground(new java.awt.Color(0, 0, 0));
        ZuidPaneel.setForeground(new java.awt.Color(255, 255, 0));

        jLabel3.setForeground(new java.awt.Color(255, 153, 102));
        jLabel3.setText("Step right up , ladies and gentlemen ...");

        jLabel4.setForeground(new java.awt.Color(255, 153, 102));
        jLabel4.setText("6 tries to find 3 identical pictures");

        jButton1.setText("Start game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTicker.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTicker.setForeground(new java.awt.Color(255, 153, 102));
        lblTicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ZuidPaneelLayout = new javax.swing.GroupLayout(ZuidPaneel);
        ZuidPaneel.setLayout(ZuidPaneelLayout);
        ZuidPaneelLayout.setHorizontalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZuidPaneelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZuidPaneelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZuidPaneelLayout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(162, 162, 162))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZuidPaneelLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)))))
            .addGroup(ZuidPaneelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ZuidPaneelLayout.setVerticalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZuidPaneelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTicker, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(ZuidPaneel, java.awt.BorderLayout.PAGE_END);

        CenterPaneel.setBackground(new java.awt.Color(0, 0, 0));
        CenterPaneel.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout CenterPaneelLayout = new javax.swing.GroupLayout(CenterPaneel);
        CenterPaneel.setLayout(CenterPaneelLayout);
        CenterPaneelLayout.setHorizontalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        CenterPaneelLayout.setVerticalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        getContentPane().add(CenterPaneel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        start = true;
        lblTicker.setText("");
        lblTicker.setForeground(Color.white);
        iCount = 0;
        iCorrect = 0;
        dim = 3;
        
        knoppenGrid = new JButton[dim][dim];//(her)maak de array
            
        CenterPaneel.removeAll(); // anders worden knoppen bijgevoegd

        // nieuwe GridLayout anders bvb 9 knoppen in een 5x5 rooster ...
        CenterPaneel.setLayout(new GridLayout(dim,dim,5,5));

        for (int rij=0; rij<dim; rij++)
		for (int kolom=0; kolom<dim; kolom++){
			knoppenGrid[rij][kolom] = maakKnop2 (CenterPaneel, rij,kolom);
			                          // gebruik de factory method !
                                                  // juiste paneel meegeven als argument !
    	}
        // om de knoppen zichtbaar te krijgen
        CenterPaneel.doLayout(); 
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Klikspel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Klikspel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Klikspel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Klikspel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Klikspel().setVisible(true);
            }
        });
    }
    
    private Boolean start=false;
    private int iCount;
    private int iCorrect;
    int dim;
    private JButton[][] knoppenGrid; // 2D-array van knoppen !
    private KnopHandler kh;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPaneel;
    private javax.swing.JPanel NoordPaneel;
    private javax.swing.JPanel ZuidPaneel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTicker;
    // End of variables declaration//GEN-END:variables
}
