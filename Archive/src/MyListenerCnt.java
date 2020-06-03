import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class MyListenerCnt implements ActionListener {
    private final JMenuItem JExit;
    private final JMenuItem JAbout;
    private final JMenuItem JHelp;
   private JTextArea jta;


    public MyListenerCnt(JTextArea jtaMain,JMenuItem Jexit,JMenuItem jhelp,JMenuItem jabout) {

        jta = jtaMain;
        JExit = Jexit;
        JAbout = jabout;
        JHelp = jhelp;



    }

    public void actionPerformed(ActionEvent ae) {


        if(ae.getActionCommand().equals("Exit")){
            //System.out.println("hi");
            System.exit(0);

        } else if (ae.getActionCommand().equals("About")) {
            JOptionPane.showMessageDialog(null,"this is a gui hell assignment. It contains the Audio clip as well");

        } else if (ae.getActionCommand().equals("Help")) {
           JOptionPane.showMessageDialog(null,"you are welcomed in the trap");
        }
    }

}