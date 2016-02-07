/* simpele browser ... voor uitbreiding vatbaar
 * toont html-pagina / grafisch / Swing / 
 * nu ook met URL-ingave en doorklikken op links
 * de HyperlinkListener-klasse werkt zoals een vakHandler , 
 * maar nu voor hyperlinks
 */

import javax.swing.*;
import javax.swing.event.*;

import javax.swing.text.*;
import javax.swing.text.html.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ShowPage {
  
  static JTextField  jtf = new JTextField (120);
  static JEditorPane jep = new JEditorPane(); // een tekstarea voor output
     
  public static void main(String[] args) {
      new ShowPage();
  }  
  
  public ShowPage(){
     jep.setEditable(false); 
     jep.addHyperlinkListener(new Hyperactive()); // handler koppelen aan vak
     
     jtf.setText("http://www.google.be");
     jtf.addActionListener(new VakHandler());     // VakHandler koppelen

      
     JScrollPane scrollPane = new JScrollPane(jep);     
     
     JFrame f = new JFrame("Mini Browser");
     
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setLayout (new BorderLayout());
     f.getContentPane().add(jtf,BorderLayout.NORTH);
     f.getContentPane().add(scrollPane, BorderLayout.CENTER);
     
     f.setSize(512, 342);
     f.show();
    
  }
  
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent evt ) {
      String adres = jtf.getText();
      
      
       
      try {
       jep.setPage(adres); // ingetikte pagina laden
      }
      catch (IOException e) {
       jep.setContentType("text/html");
       jep.setText("<html>Could not load " + adres);
      }    
      
      jtf.setText("");
    }
  }
  
  class Hyperactive implements HyperlinkListener {
 
         public void hyperlinkUpdate(HyperlinkEvent e) {
 	          if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
 		      JEditorPane pane = (JEditorPane) e.getSource();
 		      if (e instanceof HTMLFrameHyperlinkEvent) {
 		          HTMLFrameHyperlinkEvent  evt = (HTMLFrameHyperlinkEvent) e;
 		          HTMLDocument doc = (HTMLDocument) pane.getDocument();
 		          doc.processHTMLFrameHyperlinkEvent(evt);
 		      } else {
 		          try {
 			        pane.setPage(e.getURL());   // gevolgde link laden
 			        jtf.setText(""+e.getURL()); // gevolgde link in TextField zetten
 		          } 
 		          catch (Throwable t) {
 			      t.printStackTrace();
 		          }
 		      }
 	          }
 	      }
     }


}

