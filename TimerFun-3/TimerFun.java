/** This program is simply creating the desired frame and the progress bar are running.
  * Once we get any of the thread completed first, then whole of he program stops displayeing halted and finished
  * on the JProgress bar and all the other methods stops excluding the Clock timer.
  * @author Shubham Malhotra
  */
import java.text.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TimerFun extends JFrame 
{
   private boolean b=true;    // a boolean variable 
   // close method 
   public static void close()
    {
        try {
            Thread.sleep(2000);
        }
        catch(Exception ie)
        {
            System.out.println(ie);
        }
        System.exit(0);
    }
   // constructor for class TimerFun 
   public TimerFun() 
   {
      // making the JFrame and adding panles and other objects to it 
      setTitle("Fun with Timers");
      setLayout(new BorderLayout());
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                close();
            }
        });
      JMenuBar jmb = new JMenuBar();       
      setJMenuBar(jmb);
      JMenu file = new JMenu("File");
      JMenuItem exit = new JMenuItem("Exit");
      file.add(exit);
      jmb.add(file);
      JMenu help = new JMenu("Help");
      JMenuItem about = new JMenuItem("About");
      help.add(about);
      jmb.add(help);
      JPanel north = new JPanel();
      DateFormat date = new SimpleDateFormat("EEE, dd MMMM yyyy HH:mm:ss");
      Calendar calendar = Calendar.getInstance();
      JLabel clock = new JLabel(date.format(calendar.getTime()), JLabel.CENTER);
      Font font = new Font("Monospaced", Font.BOLD, 22);
      clock.setFont(font);
      clock.setForeground(Color.RED);
      north.add(clock, BorderLayout.NORTH);
      add(north, BorderLayout.NORTH);
      // actionListener for updating time every second 
      ActionListener swingAction = new ActionListener() 
      {
         public void actionPerformed(ActionEvent ae) 
         {
            DateFormat date = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
            Calendar calendar2 = Calendar.getInstance();
            clock.setText(date.format(calendar2.getTime()));
         }
      };
      new javax.swing.Timer( 0,swingAction ).start();
      exit.addActionListener( new ActionListener()
                              {
                                 public void actionPerformed(ActionEvent ae) 
                                 {
                                   close();
                                 }
                              } 
                            );
      // Adding the panel where the colours for rainbow are added      
      GridLayout grid = new GridLayout(0, 1);
      JPanel center = new JPanel();
      center.setLayout(grid);
      JPanel c1= new JPanel();
      JPanel c2= new JPanel();
      JPanel c3= new JPanel();
      JPanel c4= new JPanel();
      JPanel c5= new JPanel();
      JPanel c6= new JPanel();
      JPanel c7= new JPanel();   
      c1.setBackground(Color.RED);
      c2.setBackground(Color.ORANGE);
      c3.setBackground(Color.YELLOW);
      c4.setBackground(Color.GREEN);
      c5.setBackground(Color.BLUE);
      c6.setBackground(new Color(75, 0, 130));
      c7.setBackground(new Color(235, 130, 235));
      /*
      * Adding all raibow colours to the panel
      */
      center.add(c1);
      center.add(c2);
      center.add(c3);
      center.add(c4);
      center.add(c5);
      center.add(c6);
      center.add(c7);
      add(center, BorderLayout.CENTER);
      /* 
       * method to rotate the rainbw with a pause of 500ms
       * In this the very first value is stored in the temp variable which is further assigned to the very last coloour
       * and rest all of the colors are up updated to the colors from the next panels.
      */
      TimerTask rotate = new TimerTask()
      {
         public void run()
         {
            Color temp = c1.getBackground();
            c1.setBackground(c2.getBackground());
            c2.setBackground(c3.getBackground());
            c3.setBackground(c4.getBackground());
            c4.setBackground(c5.getBackground());
            c5.setBackground(c6.getBackground());
            c6.setBackground(c7.getBackground());
            c7.setBackground(temp);
         }
      };
      /*
      * declaring the vales of delay and start which are further used to perform the rotation of the rainbow colors
      */
      final  int START_AFTER = 2000;
      final int DELAY = 1000;
      final int DELAY2 = 500;
      java.util.Timer rotate1 = new java.util.Timer();
      rotate1.scheduleAtFixedRate(rotate, START_AFTER, DELAY2);
      // for menu
      about.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent ae)
         {
            JOptionPane.showMessageDialog(null,"Fun with timers and threads\nby: Shubham Malhotra");
         }
      });
      JPanel south = new JPanel();
      south.setLayout(grid);
      // progress bars
      InnerProgBar bar2 = new InnerProgBar("UnabridgedDictionary", 213558);
      InnerProgBar bar1 = new InnerProgBar("words", 10000);
      south.add(bar1);
      south.add(bar2);
      add(south, BorderLayout.SOUTH);
      Thread th1 = new Thread(bar1);
      Thread th2 = new Thread(bar2);
      th1.start();
      th2.start(); 
      Thread th3 = new Thread()
      {
         public void run()
         {
            try
            {
               th2.join();
            }
            catch(InterruptedException ie)
            {
            }
            rotate.cancel();
         }
       };
       th3.start();
       setSize(400,350);
       setLocationRelativeTo(null);
       setVisible(true);
   }  
   /*
    * class about reading and actions performed by progressbar while reading the files
    *
   */
      class InnerProgBar extends JPanel implements Runnable
   {
      private JProgressBar bar;
      private JLabel progress;
      private int lineNum;
      private String name; 
      private double c;  
      public InnerProgBar(String _name, int lines)
      {
         name = _name;
         lineNum = lines;
         bar = new JProgressBar();
         progress = new JLabel(name +"Progress: ");
         bar.setStringPainted(true);
         bar.setMaximum((int)(new File(_name)).length());
         bar.setString("Opening file..");
         add(progress);
         add(bar);
         b = true;
      }
      public void run()
      {
         try
         {
            Thread.sleep(2000);
         }
         catch(InterruptedException ie)
         {
            System.out.println("Sleep interruption: " + ie.getMessage());
         }
         File readFile = new File(name +".txt");
         int count = 1;
         bar.setStringPainted(true);
         try(BufferedReader br = new BufferedReader(new FileReader(readFile)))
         {
            String line;
            int bigLine=0;
            while((line=br.readLine()) != null && b == true)
            {
               bigLine++;
               count=bigLine;
               c=(count/(double)lineNum)*100;
               String c1=String.format("%4.1f",c);
               bar.setString(c1+"%");
               try
               {
                  Thread.sleep(1);
               }
               catch(InterruptedException ie)
               {
                  System.out.println("Sleep interruption: " + ie.getMessage());
               }
            }
            System.out.print(readFile);
            if (b==true)
            {
               b = false;
               try
               {
                  Thread.sleep(2000);
               }
               catch(InterruptedException ie){
                  System.out.println("Sleep interruption: " + ie.getMessage());
               }
               bar.setString("Finished");
               br.close();
            }
            else if(b==false)
            {
               br.close();
               bar.setString("Halted at " + String.format("%4.1f",c) + "%");
               try
               {
                  Thread.sleep(2000);
               }
               catch(InterruptedException ie)
               {
                  System.out.println("Sleep interruption: "+ ie.getMessage());
               } 
            }
            
         }
         catch(Exception e)
         {
         }
      }
   }
   public static void main(String []args)
   {
      new TimerFun();
   }
}
