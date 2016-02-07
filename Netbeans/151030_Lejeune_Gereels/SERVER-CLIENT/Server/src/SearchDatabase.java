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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


    class SearchDatabase extends Thread{
    
    private Boolean gevonden=true;
    BufferedReader br;
    private String tab="\t";
    private String nl="\n";
    private int iCol=0;
    private int iCount = 0;
    private javax.swing.JTextArea txtDatabase;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtJaar;
    private ArrayList<Gegevens> lijst2;
    private String naam="";
    private String klas="";
    private String jaar="";
    
    
    public SearchDatabase(javax.swing.JTextArea txtDatabase,javax.swing.JLabel lblDatabase,javax.swing.JTextField txtNaam,javax.swing.JTextField txtKlas,javax.swing.JTextField txtJaar)
    {
        this.txtDatabase = txtDatabase;
        this.lblDatabase = lblDatabase;
        this.txtNaam = txtNaam;
        this.txtKlas = txtKlas;
        this.txtJaar = txtJaar;
    }

    
    
    
    public void run() {
        
        lijst2 = new ArrayList<>();
        
        while (gevonden)
            
        {
            
        
        
     
     	
            
            //de database binnenhalen in een arraylist
            try {
                br = new BufferedReader(new FileReader("Database.csv"));
            } catch (FileNotFoundException ex) {
                //txtDatabase.setText("FILE NOT FOUND");
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
        String line = null;
            try {
                //txtDatabase.setText("Naam" + "\t" + "Klas" + "\t" + "Jaar" + "\n" + "====" + "\t" + "====" + "\t" + "====\n");
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for (String str : values)
                    {
                        iCol++;
                        String whatJump="";
                        if (iCol==1)
                        {
                            whatJump=nl;
                            naam=str;
                        }
                        else
                        {
                            whatJump=tab;
                            klas=str;
                        }
                        if(iCol==3)
                        {
                            jaar=str;
                            iCount++;
                            iCol=0;
                            Gegevens  tempGegevens = new Gegevens (naam, klas, jaar); 
                            lijst2.add (tempGegevens);
                        }
                        
                        
                        
                        
                        //txtDatabase.setText(txtDatabase.getText()  + str + whatJump);
                        System.out.println(str);
                    }
                    //lblDatabase.setText("Database : " + iCount + " record(s) in total");
                }   } catch (IOException ex) {
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(MijnVenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            //zoeken in de array naar de zoekwaar(en)
            
          String resultaat;
        resultaat = "";
        boolean contains = false;
        
        int iCount=0;
        for(Gegevens tekst: lijst2) 
        {
                double percent = 0.0;
                if (tekst.getNaam().equalsIgnoreCase(txtNaam.getText()))
                {
                  percent = percent + 33.33; 
                  contains = true;
                } 
                if (tekst.getKlas().equalsIgnoreCase(txtKlas.getText()))
                {
                  percent = percent + 33.33; 
                  contains = true;
                } 
                if (tekst.getJaar().equalsIgnoreCase(txtJaar.getText()))
                {
                  percent = percent + 33.33; 
                  contains = true;
                } 
                if (percent==99.99)
                        {
                            percent = 100;
                        }
                if(contains)
                {
             
                    iCount++;
                    resultaat = resultaat + "\n" + tekst.getNaam() +"\t" + tekst.getKlas() + "\t"  + tekst.getJaar() +"\t" + "Match = " + percent + "%";
                    contains=false;
                }
	}
                txtDatabase.setForeground(Color.MAGENTA);
        txtDatabase.setText("Naam" + "\t" + "Klas" + "\t" + "Jaar" + "\n" + "====" + "\t" + "====" + "\t" + "====" + resultaat);   
        lblDatabase.setText("Database : " + iCount + " record(s) found with search");
        
        txtNaam.requestFocusInWindow();
            
            
            
            
            
            
            
        txtDatabase.setCaretPosition(txtDatabase.getDocument().getLength());
        gevonden=false;
        break;
        }
        
        
    }
    
    
}
