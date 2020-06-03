/**
LAB 08
----------------------------------------------------
CLIENT PART

-----------------------------------------------------
author @ SHUBHAM MALHOTRA



*/

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class Client extends JFrame implements ActionListener{
   private JButton record;
   private JButton exit;
   private JButton count;
   private Socket s;
   private Order obj_1;
   private JTextField jtf1;
   private JTextField jtf2  = new JTextField(30);;
   private JTextField jtf3;
   private  ObjectOutputStream oos;
   private  ObjectInputStream ois;
   
   public static void main(String args[]){
      new Client();
   }
   public Client(){
      super("Sales Order information CLient");
      JPanel jp = new JPanel(new GridLayout(0,1));
      JPanel jp3 = new JPanel();
      record = new JButton("record");
      record.addActionListener(this);
      jtf1 = new JTextField(30);
      jp3.add(jtf1);
      jp3.add(record);
      jp.add(jp3);
      JPanel jp2 = new JPanel();
      count = new JButton("count");
      count.addActionListener(this);
       jtf2 = new JTextField(30);
      jp3.add(jtf2);
      jp3.add(count);
      jp.add(jp2);
      JPanel jp1 = new JPanel();
      exit = new JButton("exit");
      exit.addActionListener(this);
       jtf3 = new JTextField(30);
      jp3.add(jtf3);
      jp3.add(exit);
      jp.add(jp1);
      add(jp,BorderLayout.NORTH);
      setVisible(true);
      pack();
      
      try{
         s = new Socket("localhost",16789);
          ois = new ObjectInputStream(s.getInputStream());
          oos = new ObjectOutputStream(s.getOutputStream());
             
      }
      catch(Exception uhe) {
      
			jtf1.setText("Unable to connect to host.");
         jtf2.setText("Unable to connect to host.");
         jtf3.setText("Unable to connect to host.");

		}

   }
   public void actionPerformed(ActionEvent ae){
       
      
      int count1=-998;
      int record1 = -999;
      Object choice = ae.getSource();
      if(choice==record){
         String name = jtf1.getText();
         int no = Integer.parseInt(jtf2.getText());
         int count_1 = Integer.parseInt(jtf3.getText());
         obj_1 = new Order(name,no,count_1);
         
         try{
         String abc = new String("record1");
         oos.writeObject(abc);
           
         oos.writeObject(obj_1);
         oos.flush();
         
         }
         catch(Exception uae){
            uae.printStackTrace();
         }
         
      }
      else if(choice==count){
         
         try{
         
         String ab = new String("OK");
         oos.writeObject(ab);
         System.out.println(ab);
         oos.flush();
         
                  

      
      }
      catch(Exception hae){
         hae.printStackTrace();
      }
      }
      else if(choice==exit){
                 
           System.out.println("exiting");
            System.exit(0);
         
         
      }
   }
}