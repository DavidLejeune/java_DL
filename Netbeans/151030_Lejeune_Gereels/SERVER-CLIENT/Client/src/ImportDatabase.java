/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */



import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


    class ImportDatabase extends Thread{
    
    private Boolean gevonden=true;
    BufferedReader br;
    private String tab="\t";
    private String nl="\n";
    private int iCol=0;
    private int iCount = 0;
    private javax.swing.JTextArea txtDatabase;
    private javax.swing.JLabel lblDatabase;
    public ImportDatabase(javax.swing.JTextArea txtDatabase,javax.swing.JLabel lblDatabase)
    {
        this.txtDatabase = txtDatabase;
        this.lblDatabase = lblDatabase;
        txtDatabase.setForeground(Color.GREEN);
    }

    
    
    
    public void run() {
        
        
        while (gevonden)
            
        {
            
        
            
            
            try {
                br = new BufferedReader(new FileReader("Database.csv"));
            } catch (FileNotFoundException ex) {
                txtDatabase.setText("FILE NOT FOUND");
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
        String line = null;
            try {
                txtDatabase.setText("Naam" + "\t" + "Klas" + "\t" + "Jaar" + "\n" + "====" + "\t" + "====" + "\t" + "====\n");
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for (String str : values)
                    {
                        iCol++;
                        String whatJump="";
                        if (iCol==3)
                        {
                            whatJump=nl;
                        }
                        else
                        {
                            whatJump=tab;
                        }
                        if(iCol==3)
                        {
                            iCount++;
                            iCol=0;
                        }
                        
                        txtDatabase.setText(txtDatabase.getText()  + str + whatJump);
                        System.out.println(str);
                    }
                    lblDatabase.setText("Database : " + iCount + " record(s) in total");
                }   } catch (IOException ex) {
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        txtDatabase.setCaretPosition(txtDatabase.getDocument().getLength());
        gevonden=false;
        
        }
        
        
    }
    
    
}