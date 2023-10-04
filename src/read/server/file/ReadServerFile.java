/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package read.server.file;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author OscarFabianHP
 */
public class ReadServerFile extends JFrame{

    /**
     * @param args the command line arguments
     */
    private JTextField enterField; // JTextField to enter site name
    private JEditorPane contentsArea; // JEditorPane to display website

    //set up GUI
    public ReadServerFile() {
        super("Simple Web Browser");
        
        //create enterField and register its listener
        enterField = new JTextField("Enter file URL here");
        enterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getThePage(e.getActionCommand());
            }

          
        });
        
        add(enterField, BorderLayout.NORTH);
        
        contentsArea = new JEditorPane(); //create contest area
        contentsArea.setEditable(false);
        contentsArea.addHyperlinkListener(new HyperlinkListener() {
            
            //if user clicked hyperlink, go to specified page
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType()== 
                        HyperlinkEvent.EventType.ACTIVATED)
                    getThePage(e.getURL().toString());
            }
        });
        
        add(new JScrollPane(contentsArea), BorderLayout.CENTER);
        setSize(400, 300); //set size of window
        setVisible(true); //show window
    }
    
    //load document
    private void getThePage(String location) {
        try //load document and display location
        {
           contentsArea.setPage(location); //set the page
           enterField.setText(location); //set the text
        }
        catch(IOException exception){
            JOptionPane.showMessageDialog(this, "Error retrieving specified URL",
                    "Bad URL", JOptionPane.ERROR_MESSAGE);
        }
    }    
}
