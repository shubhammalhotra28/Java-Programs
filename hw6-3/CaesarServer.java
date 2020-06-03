/* 
 * CaesarServer.java
 * 
 * Version: 
 *     Id$ 1.0
 * 
 */
/** 
 * Server is created which is further doing the encryption as well as
 * decryption and further settting the string accordingly. There is even the 
 * option for error which is seeting the string to 0 which is also the default
 * case as handled.
 * 
 * @author      Shubham Malhotra
 * Home work 6(Assignment)
 * Class ISTE 121
 *

*/


import java.util.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class CaesarServer implements CaesarConstants
{
   int d;// global varibale
   public static void main(String args[])
   {
   
      /*
      *  defining the shift of deafault value of 3 if
      *  no command line arguments will be passed.
      */
      int shift = 3;
      //d=shift;
      if(args.length>0)
      {
        shift = Integer.parseInt(args[0]); 
      }
      new CaesarServer(shift);// calling constructor
   
   }
   public CaesarServer(int shift)
   {  // assigning the value of shift to global variable
      d=shift;
      try
      {//establishing the connection
         ServerSocket ss = new ServerSocket(a);
         Socket cs = null;
         while(true)
         {
            cs  = ss.accept();
            ThreadedServer th = new ThreadedServer(cs);
            th.start();
         }
      }
      catch(Exception ae)
      {
         System.out.println(ae);
      }
   }
   class ThreadedServer extends Thread implements Runnable
   {
         Socket cs;
         public ThreadedServer(Socket cs)
         {
            this.cs = cs;
         }
         public void run()
         {
            BufferedReader br;
            PrintWriter pr;
            try{
               int shift = getShift();
               br = new BufferedReader(
                  new InputStreamReader( cs.getInputStream() ));
               pr = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
               String client_msg = br.readLine();// reading the text and storing it
               String s2 ="";// initialising an empty string
               
               if(client_msg.equals("ENCRYPT"))
               {
               
                  pr.println("OK");
                  pr.flush();
                  String str1 = br.readLine();
                  int n = str1.length();
                  
                  for(int i=0;i<n;i++)
                  {

                     char c = str1.charAt(i);
                     //System.out.println(str1);
                     int a = (int)c; //type casting
                     if((a>=65 && a<=90) || (a>=97 && a<=122)) // if there is letter 
                     {
                        a=a+shift;// incrementing the int vaue or ascii value in a 
                        s2 = s2+((char)a); // concatinating the string s2 with char a after type casting
                        
                     }
                     else
                     {
                        // if there is no letter that is if there are digits
                        s2 = s2+(c); // simply concatinating to the string
                     }
                  }
                  pr.println(s2);
                  pr.flush();
               }
               
            
            if(client_msg.equals("DECRYPT"))
            {
               pr.println("OK");
               pr.flush();
               //String s2="";
               String str1 = br.readLine();
               int n = str1.length();// getting the length of the string
               for(int i=0;i<n;i++)
               {
                  char c = str1.charAt(i);
                  int a = (int)c;
                  if((a>=65 && a<=90) || (a>=97 && a<=122))// checking if its a letter
                  {
                     a = a-shift;// decrementing the a by shift amount to decrypt
                     s2 = s2+((char)a);
                  }
                  // if its not a letter that is a number or so
                  else
                  {
                     // simply concatinating
                     s2 = s2+(c);
                  }
               }
               pr.println(s2);
                  pr.flush();

            }
            else if(client_msg.equals("ERROR"))
            {
               pr.println("ERROR");
               pr.flush();

               //if this choice is selected s2 is set up as 0
               String str1 = br.readLine();
               //s2 = "0";
            }
            else
            {
               // s2 will be set up as 0
               s2="0";
            }
           // System.out.println(s2);
          //  pr.println(s2);
            pr.flush();

         }
         catch(Exception ae)
         {
            System.out.println(ae);
         }
   }
   /*
   * method to get the shift or method returning the value of global 
   * variable
   */
   public int getShift()
   {
      return d;
   }
}
}
