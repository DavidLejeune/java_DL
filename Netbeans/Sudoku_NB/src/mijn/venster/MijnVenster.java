/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mijn.venster;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
       checkArray2 = new int[9];
       veldGrid = new JTextField[dim][dim];//(her)maak de array

        CenterPaneel.removeAll(); // anders worden knoppen bijgevoegd

        // nieuwe GridLayout anders bvb 9 knoppen in een 5x5 rooster ...
        CenterPaneel.setLayout(new GridLayout(dim,dim,5,5));
        veldId = 0;
        for (int rij=0; rij<dim; rij++)
		for (int kolom=0; kolom<dim; kolom++){
                        veldId++;
			veldGrid[rij][kolom] = maakVeld (CenterPaneel, rij,kolom);
			                          // gebruik de factory method !
                                                  // juiste paneel meegeven als argument !
    	}
        // om de knoppen zichtbaar te krijgen
        CenterPaneel.doLayout(); 
        
        
        
    }
    
    
    
            public JTextField maakVeld( JPanel p,  int rij, int kolom ) {
                    
            
       // JButton knop = new JButton( "(" + rij + "," + kolom + ")" ); // als demo : zet er de rij & kolom op
            int iValue1 = getalMatrix[rij][kolom];
            JTextField veld = new JTextField( "" + iValue1 + "");
       veld.setBackground( Color.BLUE );
       veld.setForeground(Color.WHITE);
       veld.setFont(new Font("Consolas", Font.BOLD, 16));
       
       
       veld.setHorizontalAlignment(JTextField.CENTER);
       
       p.add( veld );
       return veld; // stuur ref terug om in array op te bergen
    }
    

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        CenterPaneel = new javax.swing.JPanel();
        ZuidPaneel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        NoordPaneel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(204, 255, 0));

        CenterPaneel.setBackground(new java.awt.Color(0, 0, 0));
        CenterPaneel.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout CenterPaneelLayout = new javax.swing.GroupLayout(CenterPaneel);
        CenterPaneel.setLayout(CenterPaneelLayout);
        CenterPaneelLayout.setHorizontalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CenterPaneelLayout.setVerticalGroup(
            CenterPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        ZuidPaneel.setBackground(new java.awt.Color(0, 0, 0));
        ZuidPaneel.setForeground(new java.awt.Color(255, 255, 0));

        jButton1.setText("Check Sudoku");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Create New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout ZuidPaneelLayout = new javax.swing.GroupLayout(ZuidPaneel);
        ZuidPaneel.setLayout(ZuidPaneelLayout);
        ZuidPaneelLayout.setHorizontalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZuidPaneelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addGap(82, 82, 82))
        );
        ZuidPaneelLayout.setVerticalGroup(
            ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZuidPaneelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZuidPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CenterPaneel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ZuidPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(CenterPaneel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ZuidPaneel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        NoordPaneel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Yu Mincho Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("SUDOKU");

        javax.swing.GroupLayout NoordPaneelLayout = new javax.swing.GroupLayout(NoordPaneel);
        NoordPaneel.setLayout(NoordPaneelLayout);
        NoordPaneelLayout.setHorizontalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoordPaneelLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NoordPaneelLayout.setVerticalGroup(
            NoordPaneelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoordPaneelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(NoordPaneel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        
        //Arrays.fill(checkArray2, 0);
        
        Boolean booleanOK = true;
        checkArray2 = new int[9]; 
           
           
        int iCount = 0;
        
        
        // rijen controleren
        for (int rij=0; rij<dim; rij++)
        {
            for (int kolom=0; kolom<dim; kolom++)
            {   
                checkArray2[kolom] = Integer.valueOf(veldGrid[rij][kolom].getText());     
                //System.out.println("" + veldGrid[rij][kolom].getText());
            }           
            Arrays.sort(checkArray2);
                  
            if (Arrays.equals(checkArray, checkArray2)) 
            {
                iCount++;
             } 
            else 
            {
            }     
        }
        
        
        //kolomen controleren
        for (int kolom=0; kolom<dim; kolom++)
        { 
            for (int rij=0; rij<dim; rij++)
            {  
                checkArray2[rij] = Integer.valueOf(veldGrid[rij][kolom].getText());     
            }         
            Arrays.sort(checkArray2); 
            if (Arrays.equals(checkArray, checkArray2)) 
            {
                iCount++;
            }
            else
            {
            }      
        }    
         
         
        int iCycle =0;
        int iCount2=0;
        // for (int i=0;i<9;i=i+3) 
        for (int ii=0;ii<9;ii=ii+3)
        {
            for (int i = 0 ; i<9; i=i+3)
            {
                for (int rij=0; rij<3; rij++)
                {
                    for (int kolom=0; kolom<3; kolom++)
                    {   
                        iCycle++;
                        checkArray2[iCount2] = Integer.valueOf(veldGrid[rij+i][kolom+ii].getText());   
                        iCount2++;
                    }           
                }
                System.out.println("" + iCount2);
                iCount2 = 0;
                System.out.println("" + Arrays.toString(checkArray2));
                Arrays.sort(checkArray2); 
                System.out.println("" + Arrays.toString(checkArray2));
                System.out.println("" + Arrays.toString(checkArray));
                System.out.println("");
                if (Arrays.equals(checkArray, checkArray2)) 
                {
    //                System.out.println("EQUALS");
                    iCount++;
                }
                else
                {
                }     
            }
            
        }           
              
        
        if (iCount==27)
        {
            System.out.println("OKIDOKI");
            //lblResult.setBackground(Color.BLACK);
            lblResult.setForeground(Color.WHITE);
            lblResult.setText("The Sudoku simple check is OK");
        }
        else
        {
            System.out.println("NOT OKIDOKI");
            //lblResult.setBackground(Color.RED);
            lblResult.setForeground(Color.RED);
            lblResult.setText("The Sudoku simple check is NOK");
        }
        System.out.println("" + iCount);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
//    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lblResult.setText("Not yet finished");
//        
//
//        // TODO add your handling code here:
//        int getal=0;
//         //tijdStart = System.currentTimeMillis(); 
//      		int i0 = 0;
//      		int i1 = 0;
//      		int i2 = 0;
//      		int i3 = 0;
//      		int i4 = 0;
//      		int i5 = 0;
//      		int i6 = 0;
//      		int i7 = 0;
//      		int i8 = 0;
//      		int i9 = 0;
//      		//do
//      		//	{ 
//                
//                for (int i =0; i<10;i++){
//                  int iCount = 0;
//     		int iCycle = 0;
//      				do
////      					{
//      						getal = (int) (10*Math.random());
//      							
//      						if (getal == 0) 
//      							{
//      								i0++;
//      								iCount = 2;
//      							} 
//      						else if (getal == 1) 
//      							{
//      								i1++;
//      								iCount = i1;
//      							}
//      						else if (getal == 2) 
//      							{
//      								i2++;
//      								iCount = i2;
//      							}
//      						else if (getal == 3) 
//      							{
//      								i3++;
//      								iCount = i3;
//      							}
//      						else if (getal == 4) 
//      							{
//      								i4++;
//      								iCount = i4;
//      							}
//      						else if (getal == 5) 
//      							{
//      								i5++;
//      								iCount = i5;
//      							}
//      						else if (getal == 6) 
//      							{
//      								i6++;
//      								iCount = i6;
//      							}
//      						else if (getal == 7) 
//      							{
//      								i7++;
//      								iCount = i7;
//      							}
//      						else if (getal == 8) 
//      							{
//      								i8++;
//      								iCount = i8;
//      							}
//      						else if (getal == 9) 
//      							{
//      								i9++;
//      								iCount = i9;
//      							}
//						
//      					} while(iCount > 1);
//     				
//                                                {
//     		                    System.out.println("" + getal + "\n " + iCycle);
//      				getalMatrix[iCycle][i] = getal;
//                                veldGrid[iCycle][i].setBackground(Color.BLACK);
//                                veldGrid[iCycle][i].setText("" + getal);
//                                iCycle++;
                                 
              
     					
//                  repaint();
//                }
      			//} while (iCycle < 9);
                
                                    
    }//GEN-LAST:event_jButton3ActionPerformed

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

    
    private int dim=9;
    
   private int veldId;
    private JTextField[][] veldGrid;
   
    private int buttonID;
    private String[] veldArray;
    private String[] soundArray;
    
    private int[][] getalMatrix =  
    {  
        {3,1,9,4,5,8,7,6,2}, {7,6,8,3,2,1,9,4,5}, {5,4,2,9,7,6,3,1,8},   
        {9,8,5,7,3,4,6,2,1}, {6,3,4,2,1,9,8,5,7}, {2,7,1,8,6,5,4,3,9},  
        {1,5,7,6,9,3,2,8,4}, {8,2,6,1,4,7,5,9,3}, {4,9,3,5,8,2,1,7,6} 
    };
    
    private int[] checkArray={1,2,3,4,5,6,7,8,9};
    private int[] checkArray2;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPaneel;
    private javax.swing.JPanel NoordPaneel;
    private javax.swing.JPanel ZuidPaneel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblResult;
    // End of variables declaration//GEN-END:variables
}
