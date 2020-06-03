import java.io.*;
import java.util.*;
public class test
{
   public static void main(String[]args)
   {
      Lab5 l5=new Lab5();
      if(args.length>0)
      {
         for(int i=0;i<args.length;i++)
         {
            String name;
            name=args[i];
            l5.find(name);
         }
      }
   }
}
