/* 
 * OrderSystem.java 
 * 
 * Version: 
 *     Id$ 1.0
 * 
 */
/** 
 * A description of what the class does. 
 * 
 * @author      Shubham Malhotra
 * Home work 1(Assignment)
 * Class ISTE 121
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTextField.*;
import java.io.*;
import java.util.*;

public class OrderSystem extends JFrame implements ActionListener
{
     private JTextField jtfEntry;
     private JTextField jtfEntry1;
     private JTextField jtfEntry2;
     private JTextField jtfEntry3;
     private JButton jbCalculate;
     private JButton jbSave;
     private JButton jbClear;
     private JButton jbExit;
     private JButton jbLoad;
     private JButton jbPrev;
     private JButton jbNext;
     private int count=0;
     // count declared as global variable to store the number of total entries in he file.
     String[] info = new String[5];
     // string array will be storing all the entries within a specific line.
     private ArrayList<String> dataStorage = new ArrayList<>();
     // Array list will be storing all the data after reading it from the csv file.
     private int lines = 0; 
     // lines variable is created to keep a check on the number of times next and prev is pressed.



  public static void main(String args[])
  {
  
  new OrderSystem();
  }//end main
  public OrderSystem()
  {
     setTitle("{SHUBHAM} Item Orders Calculator");
    JPanel jpFields = new JPanel(new GridLayout(0,2));
    jpFields.add(new JLabel("Item name:",JLabel.RIGHT));
    jtfEntry = new JTextField("Gidget Widget");
    jpFields.add(jtfEntry);
    
    jpFields.add(new JLabel("Number of:",JLabel.RIGHT));
    jtfEntry1 = new JTextField("40000        ");
    jpFields.add(jtfEntry1);

    jpFields.add(new JLabel("Cost:",JLabel.RIGHT));
    jtfEntry2 = new JTextField("2            ");
    jpFields.add(jtfEntry2);

    jpFields.add(new JLabel("Amount owned:",JLabel.RIGHT));
    jtfEntry3 = new JTextField(13);//13 is the size of the col
    
    jpFields.add(jtfEntry3); 
    jtfEntry3.setEnabled(false);//textfield is set up as disabled
  
    add(jpFields,BorderLayout.EAST);
       
       
       //adding buttons to the south with their respective tool tip
       jbCalculate = new JButton("Calculate");
       jbCalculate.addActionListener(this);
       jbCalculate.setToolTipText("Calculate the total amount of the entries within the respective textfields");

       jbSave = new JButton("Save");
       jbSave.addActionListener(this);
       jbSave.setToolTipText("Calculate and save the all data within the text fields into the csv Lab121 file");
       jbClear = new JButton("Clear");
       jbClear.addActionListener(this);
       jbClear.setToolTipText("clear all the data within all the text fields");
       jbExit = new JButton("Exit");
       jbExit.addActionListener(this);
       jbExit.setToolTipText("Exit the running program");
       jbLoad = new JButton("Load");
       jbLoad.addActionListener(this);
       jbLoad.setToolTipText("Load the file entry from the csv lab121 file");
       jbPrev = new JButton("<Prev");
       jbPrev.addActionListener(this);
       jbPrev.setToolTipText("display the previous entry within the csv Lab121 file");
       jbNext = new JButton("Next>");
       jbNext.addActionListener(this);
       jbNext.setToolTipText("display the next entry from the csv Lab121 file");

       JPanel jpButtons = new JPanel(new GridLayout(2,0));
       
       JPanel jpButtons2 = new JPanel();
       jpButtons2.add(jbCalculate);
       jpButtons2.add(jbSave);
       jpButtons2.add(jbClear);
       jpButtons2.add(jbExit);
       
       jpButtons.add(jpButtons2);
       add(jpButtons,BorderLayout.SOUTH);
       
       JPanel jpButtons3 = new JPanel();
       jpButtons3.add(jbLoad);
       jpButtons3.add(jbPrev);
       jpButtons3.add(jbNext);
       
       jpButtons.add(jpButtons3);
       add(jpButtons,BorderLayout.SOUTH);
    

    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    
    setVisible(true);
    
  }
  public void actionPerformed(ActionEvent ae)
  {
  
    System.out.println(ae);
    Object Choice = ae.getSource();
      
   //jbClear will clear all the text fields
    if (Choice==jbClear)
    {
    clear();
   
    }//jbSave will save the file
    else if (Choice == jbSave)
    { 
      savefile();     
    }//jbCalculate will calculate the entire entry in text field by multiplying the amount and the cost of the respective item
    else if(Choice == jbCalculate)
    {
    
      calc();
      
    }//jbExit will exit the running program
    else if(Choice==jbExit)
    {
      System.exit(0);
    }
    //jbLoad will load the current entry of textfields from the file and return the value of count and also load the content in arraylist
    else if(Choice==jbLoad)
    {
       dataInArray();
    }
    // jbNext will display the next entity within the text field
    else if(Choice==jbNext)
    {
      lines++; 
    	if(CountCheck()){
    	String s = dataStorage.get(lines);
    	info = s.split(",");
    	jtfEntry.setText(info[0]); 
    	jtfEntry1.setText(info[1]);
    	jtfEntry2.setText(info[2]);
    	jtfEntry3.setText(info[3]); 
    }
    
  }
    // jbPrev will display the previous entity within the text field
    
    else if(Choice==jbPrev)
    {
      lines--;
    	if(CountCheck()){
    	String s = dataStorage.get(lines);
    	info = s.split(",");
    	jtfEntry.setText(info[0]); 
    	jtfEntry1.setText(info[1]);
    	jtfEntry2.setText(info[2]);
    	jtfEntry3.setText(info[3]); 
      }

    }
    else
    {
     System.out.println("No Button Pressed");
    }
    
  }
  //method calling for calculate
/**
  * Calc() method is getting the number from the text fields in the string variables which is being changed 
  * to the double type and then the product of the amount and the total quantity is calculated and set up 
  * within the Amount text field (disabled text field).It is initialised up as void type , so it is just 
  * setting the amount entity text field and does not return any value.
*/
  public void calc()
  {
   String num1 = jtfEntry1.getText();
    String num2 = jtfEntry2.getText();
    double amount1 = Double.parseDouble(num1);
    double amount2 = Double.parseDouble(num2);
      double req_amount = amount1*amount2;
      jtfEntry3.setText(""+req_amount);

  }
  /**
  * clear() method will set all the entities within the text field to the null. It is void method , 
  * so does not return any value. Just set the text fields to null.
  */
  public void clear()
  {
   jtfEntry.setText(null);
     jtfEntry1.setText(null);
     jtfEntry2.setText(null); 
     jtfEntry3.setText(null);


  }
  /**
  * CountCheck() is used for checking the number of records within the file(lab 121.csv),it will display the 
  * total number of records and if the requested entity within the file is less than that number or eual or 
  * greater than the number, ten it will pop up the message on another window and sets the answer value. 
  * It is a boolean data type so it return =s a boolean (true or false).
  * @return boolean answer
  */
  public boolean CountCheck(){
   boolean answer = false;
   System.out.println("Number of records in a file:"+dataStorage.size());
   if((lines<0)||(lines>=count))
   {
      JOptionPane.showMessageDialog(null,"there is no more data in the next direction");
      answer = false;
   }
   else
   {
   	
      System.out.println(""+count);
      answer = true;

   }
   return answer;
  }
  /**
  * savefile() ethod is a void method, that is it is not returning any thing. It is simply saving all the data 
  * from the text fields to the file(csv).
  * @exception IOException
  */
  public void savefile()
  {
  	calc();
      try
      {
       PrintWriter pw = new PrintWriter(new FileWriter("121Lab1.csv",true));
       pw.println(""+jtfEntry.getText()+","+jtfEntry1.getText()+","+jtfEntry2.getText()+","+jtfEntry3.getText());
       pw.flush();
       pw.close();
       }
       catch(IOException ex)
       {
         System.out.println("Error writing to file '121Lab1.csv'");
       }
  }
  /**
  * dataInArray() is a void method, it is just simply reading all the data from the csv file (lab 121) and storing 
  * all the data into an array list which is further stored within the string array and al the text fields are further 
  * set up to the requested entity data from the file. The data within the string array is getting seperated wherever 
  * we are finding the commas in the dataStorge(Array List).This function is just setting the data withi the text fields
  * and it is not supposed to return any thing.
  * @exception IOException
  */
  public void dataInArray()
  {
  	try{
      BufferedReader br = new BufferedReader(new FileReader("121Lab1.csv"));
      String line = null;
      Scanner scanner = null;
      while((line=br.readLine())!=null)
      {
         scanner = new Scanner(line);
         dataStorage.add(line);
         count++;
         }
         System.out.println(count);
         String s = dataStorage.get(0);
         info = s.split(",");   
      jtfEntry.setText(info[0]); 
    	jtfEntry1.setText(info[1]);
    	jtfEntry2.setText(info[2]);
    	jtfEntry3.setText(info[3]); 
     scanner.close();
 }
  catch(IOException e)
  {
      System.out.println("Error");
  }
  
}
}

