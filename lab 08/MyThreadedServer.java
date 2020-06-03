/**
LAB 08
----------------------------------------------------
SERVER PART

-----------------------------------------------------
author @ SHUBHAM MALHOTRA



*/



import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyThreadedServer extends JFrame{
   private JTextArea jta;
   private int count=0;
   private PrintWriter pw;
   private Vector<Order> v= new Vector<Order>();
   public static void main(String args[]){
      new MyThreadedServer();
   }
   public MyThreadedServer(){
      JPanel jp = new JPanel();
      jta = new JTextArea("",30,60);
      jta.setLineWrap(true);
      jta.setWrapStyleWord(true);
      jp.add(jta);
            
      add(jp,BorderLayout.CENTER);
      setTitle("Server");
      setVisible(true);
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
      try{
         
         ServerSocket ss = new ServerSocket(16789);
         Socket cs =null;
         while(true){
            jta.append("waiting for a client connection");
            cs = ss.accept();
            
            jta.append("have a client connection"+cs);
            
                      
           ClientThread ct = new ClientThread(cs);           
           ct.start();
         }
      }
      catch(Exception ae){
         System.out.println(ae);
      }
      
   }
   class ClientThread extends Thread{
      Socket cs;
      
      public ClientThread(Socket cs){
         this.cs = cs;
      }
      public void run(){
         try{
            ObjectOutputStream oos = new ObjectOutputStream(cs.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cs.getInputStream());
              while(true){
               Object choice = ois.readObject();
               System.out.println("Read in choice = "+choice);
               if(choice.equals("exit")){
                 JOptionPane.showMessageDialog(null,"Exiting, no more orders to accept");                     
               }
               else if(choice.equals("record1")){
                  Order obj1 = (Order)ois.readObject();
                  
                  System.out.println(obj1);
                  
                  v.add(obj1);
                  
                 pw = new PrintWriter(new FileWriter("121Lab8.csv",true));
                 pw.println(obj1.toString());
                 
                 System.out.println("file recorded");
                 pw.flush();
                 
               }
               else if(choice.equals("OK")){
                  System.out.println(choice);
                  int count_number = v.size();
                  System.out.println("count_number "+count_number);
                  jta.append("\ncount of files = "+count_number);
                  
                  oos.writeObject(new Integer(count_number));
                  oos.flush();
                  
               }
             
            }

         }
         catch(Exception ae){
            System.out.println(ae);
         }
      }
      
   }
}