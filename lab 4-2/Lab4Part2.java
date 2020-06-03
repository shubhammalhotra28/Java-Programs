/**
  * this program makes the thread and progress bar race.
  * @author Shubham Malhotra
  */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Lab4Part2 extends JFrame
{
   private boolean keepGoing=true;                                            // boolean to check if any thread or progress bar has ended 
   private JButton jb1;                                                       // button to start the program

   public Lab4Part2(JProgressBar jpb1,JProgressBar jpb2,JProgressBar jpb3)
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Lab 4");                                             
      setLayout(new GridLayout(0,1));
      setLocation(650,350);
      jb1=new JButton("Let's start this show");         
      add(jb1);
      InnerProgress ip1=new InnerProgress(jpb1,"Progress 1:");                // Creating objects of InnerProgress 1
      InnerProgress ip2=new InnerProgress(jpb2,"Progress 2:");                // Creating objects of InnerProgress 2
      InnerProgress ip3=new InnerProgress(jpb3,"Progress 3:");                // Creating objects of InnerProgress 3
      add(ip1);                                                               // add InnerProgress 1 to GUI
      add(ip2);                                                               // add InnerProgress 2 to GUI
      add(ip3);                                                               // add InnerProgress 3 to GUI
      jb1.addActionListener(new ActionListener()
                           {  // creating action listener for button 
                              public void actionPerformed(ActionEvent e)
                              {
                                 Thread th1=new Thread(ip1);                  // thread 1
                                 Thread th2=new Thread(ip2);                  // thread 2
                                 Thread th3=new Thread(ip3);                  // thread 3
                                 th1.start();                                 // starting thread 1 
                                 th2.start();                                 // starting thread 2
                                 th3.start();                                 // starting thread 3
                                 keepGoing=true;
                                 jpb1.setValue(0);
                                 jpb2.setValue(0);
                                 jpb3.setValue(0);
                                 jb1.setEnabled(false);
                                 Thread extra=new Thread()
                                 {
                                    public void run()
                                    {
                                       try
                                       {
                                          th1.join();                         
                                          th2.join();                         
                                          th3.join();                                                                   
                                       }
                                       catch(InterruptedException ie)
                                       {
                                          System.out.println(ie.getMessage());
                                       }
                                       jb1.setEnabled(true);
                                    }
                                 };
                                 extra.start();
                              }
                           });   
      
      pack();                                                                 
      setVisible(true);                                                       // making the gui visible   
   }
   // class for progress bar and thread control 
   public class InnerProgress extends JPanel implements Runnable
   {
      String S;
      JProgressBar jpb;
      public InnerProgress(JProgressBar _jpb, String s)
      {
         S=s;
         JLabel l=new JLabel(S);
         jpb=_jpb;
         add(l);
         add(jpb);     
         jpb.setMaximum(80);
      } // run method 
      public void run()
      {
         jpb.setIndeterminate(false);
         System.out.println(S+" is Running.");
         // loop for running the progress bar 
         for(int i=1;i<=80&&keepGoing==true;i++)
         {
            double s=(Math.random())*1000;
            int s1=(int) s;
            try
            {
               Thread.sleep(s1);
            }
            catch(InterruptedException e)
            {
               System.out.println(e.getMessage());
            }
            jpb.setValue(i);
         }
         keepGoing=false;
         synchronized(jpb)
         {
            if(jpb.getValue()==80)
            {
               System.out.println(S+" Finished first");
            }
            else
            {
               System.out.println(S+" Finished last");
            }
         }
         System.out.println(S+" has ended. "+System.currentTimeMillis());
         jpb.setIndeterminate(true); 
      }
   }
   // main method 
   public static void main(String[]args)
   {
      JProgressBar jpb1=new JProgressBar();
      JProgressBar jpb2=new JProgressBar();
      JProgressBar jpb3=new JProgressBar();
      Lab4Part2 lp=new Lab4Part2(jpb1,jpb2,jpb3);
      jpb1.setStringPainted(true);
      jpb2.setStringPainted(true);
      jpb3.setStringPainted(true);
   }
}
    
