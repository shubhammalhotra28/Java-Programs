/* 
 * Client.java
 * 
 * Version: 
 *     Id$ 1.0
 * 
 */
/** 
 * A description of what the class does. 
 * 
 * @author      Shubham Malhotra
 * Home work 7(Assignment)
 * Class ISTE 121
 */


import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



class client extends JFrame implements ActionListener
{
   // global variables
   private JTextField jtf;
   private JButton jb1;
   private JTextArea jta;
   private Socket s;
   private PrintWriter pr;
   private BufferedReader br;
   
   public client()
   {
      super("Client window");
      JPanel jp = new JPanel(new GridLayout(0,2));
      jtf = new JTextField();
      jb1 = new JButton("SEND");
      jb1.addActionListener(this);
      JPanel jp1 = new JPanel(new FlowLayout());
      
      jta = new JTextArea(25,25);
      jp.add(jtf);
      jp.add(jb1);
      jp1.add(jta);
      add(jp,BorderLayout.NORTH);
      add(jp1,BorderLayout.SOUTH);
      
      
      pack();
      setVisible(true);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      try
      {
         s = new Socket("localhost",16789);
         br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pr = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

      }
      catch(Exception uhe) {
			jta.setText("Unable to connect to host.");
			return;
		}
		

   }
   public void actionPerformed(ActionEvent ae)
   {
      // getting the user request and storing in the object
      Object choice = ae.getSource();
      
      if(choice==jb1)
      {
         // getting the text and printing and flushing
          String st = jtf.getText();
          
          pr.println(st);
          pr.flush();
          // creating object of inner class
          ReadInner ri = new ReadInner(br);
          // running the thread
          ri.start();
                         
      }
      
   }
   public static void main(String args[])
   {
      new client();// constructor calling
   }
   
   public class ReadInner extends Thread
   {  Object lock =  new Object();
      BufferedReader br1;
      public ReadInner(BufferedReader br)
      {
         br1 = br;
         
      }
      public void run()
      {
         try{
         while(true)
         {
         // synchronization
            synchronized(lock){
            // reading and appending the data to text area
            String s = br1.readLine();
            jta.append(s);
            }
         }
         }
         catch(Exception ae)
         {
         // printing the error 
            System.out.println(ae);
         }
      }
   }
}