import java.text.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;

public class TestDups{
   private final int SIZE = 9000;
   
   //main method
   public static void main(String [] args){
      TestDups td = new TestDups();
      String fileEntered = args.length>0 ? args[0] : "test.txt";	// default file if none entered in args
      long longCrc;
      
      File file = new File(fileEntered);
      longCrc = td.getCRC(file);

      //print info out to console
      System.out.println("Information for: " + fileEntered);
      System.out.println("CRC: " + Long.toHexString(longCrc).toUpperCase());
      System.out.println("Name: " + file.getName());
      System.out.println("Path Name: " + file.getAbsolutePath());
      System.out.println("File size: " + file.length());
      System.out.println("Directory: " + file.isDirectory());
      System.out.println("File: " + file.isFile());
      System.out.println("Hidden: " + file.isHidden());
      System.out.println("Exist: " + file.exists());
      
      long ts = file.lastModified();
      Format sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss aa");
		System.out.printf("Last Modified  : %1$tF %1$tT \n", ts);
		System.out.printf("Last Modified  : %1$tF %1$tr \n", ts);
      System.out.println("Last Modified  : "+ sdf.format(new Date(ts)));
   }//end of MAIN METHOD
	
	/**
		Given a file object, return the CRC.
		Students, you may use this method in your homework, it will not be
		considered plagiarism.
		What you need to do is add comments, explaining what the code does.
		Look up the methods in the CRC32 javadocs. Don't copy/paste explainations.
	*/
   public long getCRC(File aFile){
      //need to have specified array of bytes
      byte [] b1 = new byte[SIZE];
      //crc class is used to compute CRC32 of datastream
      CRC32 crc = new CRC32();
      int len = 0;
      long crcValue = -1;
      //resets crc to intial value
      crc.reset();
      try{
         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(aFile));
         //while this is true
         while ((len = bis.read(b1)) > -1){
            //updates checksum with the bytes from the specified buffer
            crc.update(b1,0,len);
         }//end of while
         
         //returns crc value, setting it to crcValue, a long
         crcValue = crc.getValue();
         bis.close();
         
      }//end of try
      catch(Exception e){
         e.getMessage();
      }
      //final crc Value
      return crcValue;
		
   } // end getCRC() method
} // end CalcCRC class