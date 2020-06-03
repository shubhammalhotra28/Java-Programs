/*
LAB 3
PART 1
NAME SHUBHAM MALHOTRA
*/
import java.util.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import java.lang.NullPointerException;
import java.awt.Color;

import static javax.swing.text.DefaultHighlighter.*;

class Lab03 extends JFrame implements ActionListener
{

    private JTextArea jta;
    private String str2;
    private JButton j_button;
    private JTextField jtfEntry;
    private JButton j_button1;
    public static void main(String args[])
    {
        new Lab03();
    }
    public Lab03()
    {
        setTitle("Find");

        JPanel jpPanel = new JPanel(new FlowLayout());
        jta = new JTextArea(20,20);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.append("For this exercise, you will create a Find application that will locate a word in a block of text that is displayed in a text area. You will create inner classes to handle events. At startup the GUI appears as follows");
        jta.append("\n\nTo use this application enter a sentence or copy/paste the code into the text area. Then in the text field labeled Find: enter some short text to find within the upper text. The program only needs to identify the first occurrence of the text.");
        jta.append("\n\nThe program is to use inner classes for some of the controls, and you are required to look up method(s) you donít know in JavaDocs only.");
        //jta.requestFocus();
        JScrollPane jscroll = new JScrollPane(jta);
        jpPanel.add(jscroll);
        add(jpPanel,BorderLayout.NORTH);

        JPanel jp = new JPanel(new GridLayout(2,0));
        JPanel jp1 = new JPanel(new FlowLayout());
        JLabel j_label = new JLabel("Find:");
        jp1.add(j_label);
        jtfEntry = new JTextField(10);
        jtfEntry.setText("find");
        str2 = jtfEntry.getText();
        
        jp1.add(jtfEntry);
        jp.add(jp1);
        add(jp,BorderLayout.SOUTH);
        JPanel jp2 = new JPanel(new FlowLayout());

        j_button = new JButton("Find");
        jp2.add(j_button);
        j_button.addActionListener(this);
        jp.add(jp2);
        j_button1 = new JButton("Clear");
        jp2.add(j_button1);
        j_button1.addActionListener(this);
        jp.add(jp2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,"Do you want to exit the program?", "Exit Program",JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    {
                        dispose();
                    }
                }
            }
        });

        add(jp,BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        Object choice = ae.getSource();
        if(choice== j_button)
        {
            Find fw = new Find();
            fw.find();
        }
        else if(choice==j_button1)
        {
            Find fw = new Find();
            //System.out.println("working");
            fw.clear();
           
         }
    }

    class Find {


        public void find(){

            String text = jta.getText();
            String word = jtfEntry.getText();

            int position = text.indexOf(word);
            if(position==-1)
            {
                JOptionPane.showMessageDialog(null,"word not exist");
            }
            else if(position==0)
            {
                JOptionPane.showMessageDialog(null,"enter the input in find");
            }
            else
            {
                jta.select(position, position + word.length());
                Color color = Color.BLUE;
               // textArea.setBackground(color);
               jta.setSelectedTextColor(color);
            }
            addWindowFocusListener(new WindowAdapter()
            {
               public void WindowGainedFocus(WindowEvent e)
               {
                  jta.requestFocusInWindow();
               }
            });
            


        }
        public void clear()
        {
            String word = jtfEntry.getText();
            //find();
          
            jtfEntry.setText(null);
jtfEntry.requestFocusInWindow();
                   
         }


        }

    }

