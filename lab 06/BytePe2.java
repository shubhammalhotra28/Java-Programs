import java.util.*;
import java.io.*;
import java.awt.*;

class BytePe2
{  
   private static ArrayList<Integer> arr = new ArrayList<Integer>();
   private static int in_list;
   public static void main(String args[])
   {

     for(int i=1;i<=8;i++)
     {
            String name="integer";
            String name1 = name+i+".dat";
            addInts(name1);
      }
   }
   public static void addInts(String file_name)
   {
   try
   {
      FileInputStream fis = new FileInputStream(file_name);
      DataInputStream dis = new DataInputStream(fis);
      int sum = 0,count=0;
      while(dis.available()>0){
         int i = dis.readInt();
         arr.add(i);
         sum = sum + i;
         count++;
         }
          System.out.print("Count " + count);
         System.out.print("  Sum = "+sum);
         System.out.print("  In List = "+arr.size());
         System.out.println("");
         dis.close();
         
      }
      catch(Exception e)
      {
         System.out.println("file does not exist");
      } 
   }
}