import java.util.*;
import java.io.*;
import java.awt.*;

class BytePe1
{  
   private static ArrayList<Integer> arr = new ArrayList<Integer>();
   private static int in_list;
   public static void main(String args[])
   {
      int sum=0,count=0;
      try
      {
         FileInputStream fis = new FileInputStream("integer1.dat");
         DataInputStream dis = new DataInputStream(fis);
         
         while(dis.available()>0){
         int i = dis.readInt();
         arr.add(i);
         sum = sum + i;
         count++;
         }
         
         
         
         System.out.print("Count " + count);
         System.out.print("  Sum = "+sum);
         System.out.print("  In List = "+arr.size());
         dis.close();
         
         
      }
      catch(Exception e)
      {
         
      }
   }
}