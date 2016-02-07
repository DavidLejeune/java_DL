/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.frame1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author User1
 */
public class BigGrid extends javax.swing.JFrame {

    /**
     * Creates new form BigGrid
     */
    public BigGrid() {
        initComponents();
        // EIGEN INSTANTIERINGEN 
        // (behalve deze welke via "customize code" gedaan worden,
        //  en via initComponents() reeds gebeurd zijn)
        kh = new KnopHandler();
    }
    
    // EIGEN METHODEN & INTERNE KLASSEN (handlers)
    
    // factory method JButton
    public JButton maakKnop( JPanel p,  int rij, int kolom ) {
       JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
       knop.setBackground( Color.green );
       knop.addActionListener( kh );
       p.add( knop );
       return knop; // stuur ref terug om in array op te bergen
    }

    // speciaal : 1 knophandler voor ALLE knoppen, hoeveel er ook zijn !
    class KnopHandler implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            // zoek op welke knop er geklikt werd 
            for (int rij=0; rij<dim; rij++){
                   for (int kolom=0; kolom<dim; kolom++){
                        // dan was het die knop waarop je geklikt had
                        if (e.getSource() == knoppenGrid[rij][kolom] ){ 
                                // doe iets met de knop in kwestie
                                if (knoppenGrid[rij][kolom].getBackground().equals (Color.green)) 
                                    knoppenGrid[rij][kolom].setBackground (Color.red);
                                else knoppenGrid[rij][kolom].setBackground (Color.green);
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

        hoofdPaneel = new javax.swing.JPanel();
        centerPaneel = new javax.swing.JPanel();
        zuidPaneel = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        dimVak = new javax.swing.JTextField();
        knop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Big Grid Demo in NetBeans !");

        hoofdPaneel.setLayout(new java.awt.BorderLayout());

        centerPaneel.setLayout(new java.awt.GridLayout());
        hoofdPaneel.add(centerPaneel, java.awt.BorderLayout.CENTER);

        zuidPaneel.setBackground(new java.awt.Color(204, 255, 0));

        label1.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        label1.setText("Geef Dimensie :");
        zuidPaneel.add(label1);

        dimVak.setColumns(10);
        zuidPaneel.add(dimVak);

        knop.setBackground(new java.awt.Color(255, 51, 0));
        knop.setForeground(new java.awt.Color(0, 0, 102));
        knop.setText(" GO ! ");
        knop.setToolTipText("klik hier om de grid te maken");
        knop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knopActionPerformed(evt);
            }
        });
        zuidPaneel.add(knop);

        hoofdPaneel.add(zuidPaneel, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hoofdPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void knopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knopActionPerformed
        // TODO add your handling code here:
        dim = Integer.parseInt(dimVak.getText() ) ;// haal dimensie uit invoervak
        
        knoppenGrid = new JButton[dim][dim];//(her)maak de array

        centerPaneel.removeAll(); // anders worden knoppen bijgevoegd

        // nieuwe GridLayout anders bvb 9 knoppen in een 5x5 rooster ...
        centerPaneel.setLayout(new GridLayout(dim,dim,5,5));

        for (int rij=0; rij<dim; rij++)
		for (int kolom=0; kolom<dim; kolom++){
			knoppenGrid[rij][kolom] = maakKnop (centerPaneel, rij,kolom);
			                          // gebruik de factory method !
                                                  // juiste paneel meegeven als argument !
    	}
        // om de knoppen zichtbaar te krijgen
        centerPaneel.doLayout();    
    }//GEN-LAST:event_knopActionPerformed

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
            java.util.logging.Logger.getLogger(BigGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BigGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BigGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BigGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BigGrid().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centerPaneel;
    private javax.swing.JTextField dimVak;
    private javax.swing.JPanel hoofdPaneel;
    private javax.swing.JButton knop;
    private javax.swing.JLabel label1;
    private javax.swing.JPanel zuidPaneel;
    // End of variables declaration//GEN-END:variables
    int dim;
    private JButton[][] knoppenGrid; // 2D-array van knoppen !
    private KnopHandler kh;
}