import java.io.*;

/**
 *	DirectoryContents - Find how much space is stored in a specified directory. <br />
 *	Recursively traverse subdirctory structure <br />
 *	Michael Floeser
 * Updated by Jai Kang & Jim Leone
 */

public class DirectoryContents
{
	private long dir_counter=0;
	private long file_counter=0;
   // Attributes go here
	   
	// This is called with a starting directory in a file object
   public long getSpace( File currentDir )
   {
   	
      long length = 0;

      try{
      // Develop code here.  Read lab sheet for what goes here.
   	
            
   	//File dir = new File(currentDir);
   	File[] files = currentDir.listFiles();
      

   	for(File file : files)
   	{
   		
   		if(file.isFile())
   		{
   			// normal incrementing the length
   			length = length+file.length();
   			file_counter++;
   		}

   		else if(file.isDirectory())
   		{
   			//increment with recursion
   			length = length+getSpace(file);
   			dir_counter++;

   		}
   	}
      }
      catch(SecurityException se)
      {
         System.out.println(se.getMessage());
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
      


   	
   		// return
   	return length;



	// Hint:  Look at the flow of the main method, for other code to write.
   }

   
   // Other methods as needed. Possibly the 2 that showed up as compile errors?
   public long getFileCount(){
   		return file_counter;
   }
   public long getDirCount(){
   		return dir_counter;
   }
   public static void main(String[] args)
   {
      if(args.length > 0) {
         DirectoryContents fs = new DirectoryContents();
         File startDir = new File(args[0]);
         System.out.println( "Starting directory: "+startDir.getAbsolutePath() );
         long totalSpace = fs.getSpace(startDir);
         System.out.printf("Total space is %,d bytes = %,.2f MB%n",
										totalSpace,totalSpace/1000000.);
         System.out.printf("Files: %d   Directories: %d %n",
										fs.getFileCount(), fs.getDirCount());
      }
      else {
         System.out.println("No command line input");
         System.exit(1);
      }
   }
}