import java.io.*;
import java.util.*;
public class Lab5 extends Thread
{
   private FileInputStream fis;
   private DataInputStream dis;
   private FileOutputStream fos;
   private DataOutputStream dos;
   private String name;
   private int zip=0;
   private String city="";
   private String state="";
   private int records=0;
   private boolean run=true;
   private List list;
   private static ArrayList <String> list1;
   public Lab5()
   {  
      boolean find=true;
      int n=1;
      list=Collections.synchronizedList(list1=new ArrayList<String>());
      while(find==true)
      {
         name="Lab5File"+n+".dat"; 
         File f=new File(name);
         if(f.exists())
         {
            Thread a=
               new Thread()
               {
                  int count=0;
                  public void run() 
                  {
                     run=true;
                     try
                     {
                        fis=new FileInputStream(name);
                        dis=new DataInputStream(fis);
                        fos=new FileOutputStream("ZipCityState.dat");
                        dos=new DataOutputStream(fos);
                     }
                     catch(Exception e)
                     {
                     }
                     while(run==true)
                     {
                        try
                        {
                           zip=dis.readInt();
                           dos.writeInt(zip);
                           city=dis.readUTF();
                           list.add(city);
                           dos.writeUTF(city);
                           state=dis.readUTF();
                           dos.writeUTF(state);
                           dis.readDouble();
                           dis.readDouble();
                           dis.readInt();
                           dis.readInt(); 
                           records++;
                           count++;
                        }
                        catch(Exception e)
                        {
                           run=false;
                        }
                     }
                     try
                     {
                        dis.close();
                        dos.close();
                     }
                     catch(Exception e)
                     {
                     }
                     System.out.println("File "+name+" completed, record count is "+String.format("%,-6d",count));   
                  }
               };
               
            a.start();
            try
            {
               a.join();
            }
            catch(Exception e)
            {
            }
            n++;
         }
         else 
         {
            find=false;
         }
      }
      System.out.println("Loaded list size has " + String.format("%,-6d",list.size()) + " cities.");
      System.out.println("ZipCityState.dat has " + String.format("%,-6d",records) + " cities."); 
      try
      {
         FileOutputStream fos = new FileOutputStream("CityArrayList.ob");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(list);
         oos.close();
         long size = new File("CityArrayList.ob").length();
         System.out.printf("%s is %,d bytes.%n", "CityArraylist.ob" , size );
      }
      catch(Exception e)
      {
      }
   }
   public static void main(String[]args)
   {
      Lab5 l5=new Lab5();
      if(args.length>0)
      {
         for(int i=0;i<args.length;i++)
         {
            boolean flag=false;
            String cn=args[i];
            String cn1;
            for(int s=0;s<list1.size();s++)
            {   
               cn1=list1.get(s);
               if(cn1.equals(cn))
               {
                  System.out.println(cn1+"                was found at position "+String.format("%,-6d",s));
                  flag=true; 
                  break;
               }
            }
            if(flag==false)
            {
               System.out.println(cn+"                was NOT found"); 
            }
            
         }
      }
   }
}

