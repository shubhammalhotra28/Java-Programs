/* 
 * Server.java
 * 
 * Version: 
 *     Id$ 1.0
 * 
 */
/** 
 * A description of what the class does. 
 * 
 * @author      Shubham Malhotra
 * Home work 7(Assignment)
 * Class ISTE 121
 */



import java.util.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class Server 
{
   // object is created to have synchronized block further in the program
   Object lock = new Object();
   // global variable vector for storing and getting the data
   private Vector<PrintWriter> v = new Vector<PrintWriter>();
   public Server()
   {
      try
      {//establishing the connection
         ServerSocket ss = new ServerSocket(16789);
         Socket cs = null;
          while(true)
         {
            cs  = ss.accept();
            // making object of the inner thread
            ThreadedServer th = new ThreadedServer(cs);
            th.start();
         }
       }
       catch(Exception ae)
       {
         
       }
       

   }
   
   
   public static void main(String args[])
   {
      new Server();// constructor calling
   }
   class ThreadedServer extends Thread implements Runnable
   {
    
    Socket cs;//local variable
    public ThreadedServer(Socket cs)
    {
         this.cs = cs;  
    }
    public void run()
    {
    try
    {
      // buffered reader and printwriter for reading and writing
      BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
      v.add(pr);//adding to the global vector created
      
      while(true)
      {
         String msg = br.readLine(); // reading and storing 
         if(msg.equals("EXIT")||msg.equals("exit")||msg.equals("Exit"))
         {
            // closing and breaking in this case if we have exit
            pr.close();
            br.close();
            cs.close();
            break;
         }
         else 
         {
            synchronized(lock)
            {
               for(PrintWriter p: v)
               {
                  // writing and flushing
                  p.println(msg);
                  p.flush();
               }
            }
         }
      }

    }
    catch(Exception  ae)
    {
      System.out.println(ae);
    }
 }   
      
    }
}