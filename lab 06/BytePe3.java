import java.util.*;
import java.io.*;
import java.awt.*;

class BytePe3 extends Thread
{  
   private static ArrayList<Object> arr = new ArrayList<Object>();
   private int in_list;
   
   
    
   public static void main(String args[])
   {
         new BytePe3();
   }
   public BytePe3()
   {
     for(int i=1;i<=8;i++)
     {
            String name="integer";
            String name1 = name+i+".dat";
            //readInts(name1);
            ReadInts r = new ReadInts(name1);
            Thread t1 = new Thread(r);
            t1.start();
                  }
   }
   public class ReadInts implements Runnable
   {
      private String name_of_file;
      ReadInts(String name)
      {
         name_of_file = name;
         
      }
      public void run()
      {
       try
         {
            int sum = 0,count=0;
            FileInputStream fis = new FileInputStream(name_of_file);
            DataInputStream dis = new DataInputStream(fis);
            while(dis.available()>0)
            {
            
                  int i = dis.readInt();
                   synchronized(arr)
                   {
                     arr.add(i);
                   }
                  //arr.add(i);
                   sum = sum + i;
                   count++;
                  
            }
            System.out.print("Filename = "+name_of_file);
            System.out.print("Count " + count);
            System.out.print(" Sum = "+sum);
            System.out.print(" In List = "+arr.size());
            System.out.println();
            dis.close();
         
         }
      catch(Exception e)
            {
             System.out.println("File does not exist : "+name_of_file);
            } 
  
      }
   }
}