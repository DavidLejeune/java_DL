import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.net.*;
import java.io.*;

public class KnockKnockProtocol {
//    private static final int WAITING = 0;
//    private static final int SENTKNOCKKNOCK = 1;
//    private static final int SENTCLUE = 2;
//    private static final int ANOTHER = 3;
//
//    private static final int NUMJOKES = 5;
//
//    private int state = WAITING;
//    private int currentJoke = 0;
//
//    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
//    private String[] answers = { "Turnip the heat, it's cold in here!",
//                                 "I didn't know you could yodel!",
//                                 "Bless you!",
//                                 "Is there an owl in here?",
//                                 "Is there an echo in here?" };
    
    
    
    private javax.swing.JTextArea txtDatabase;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtKlas;
    private javax.swing.JTextField txtJaar;
    private String task;
    private javax.swing.JPanel jPanel1;
    
    
    public KnockKnockProtocol(javax.swing.JTextArea txtDatabase,javax.swing.JLabel lblDatabase,javax.swing.JTextField txtNaam,javax.swing.JTextField txtKlas,javax.swing.JTextField txtJaar,String task,javax.swing.JPanel jPanel1)
    {
        this.txtDatabase=txtDatabase;
        this.lblDatabase = lblDatabase;
        this.txtNaam = txtNaam;
        this.txtKlas = txtKlas;
        this.txtJaar = txtJaar;
        this.task = task;
            this.jPanel1=jPanel1;
        
        
    }
    

    public String processInput(String task) {
        String theOutput = null;

       if (task.equals("AddToLog"))
       {
           
       }
        
        System.out.println(task);
      
       if (task.equals("SearchLog"))
       {
            if (txtNaam.getText().equals("") && txtKlas.getText().equals("") && txtJaar.getText().equals(""))
        {
            
            int ii;
            for (ii=0;ii<3900;ii++)
            {
            Graphics2D g99 = (Graphics2D) jPanel1.getGraphics();
            //g99.setColor(Color.RED);
            g99.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
            //g99.fillRect(124, 660, 300, 30);
            g99.setColor(Color.RED);
            g99.drawString("You haven't entered a search value", 300, 680);
            g99.drawRect(190, 655,740,35);
            
            }
        }
        else
        {
            
        }
           
       }
        
        
        
        return theOutput;
    }
}
