import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.CRC32;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;


public class FindDups {
   //global attirbutes 
   ArrayList<Info> crcInfo = new ArrayList<Info>();
	SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	ArrayList<File> directoriesList = new ArrayList<File>();
	private final int SIZE = 9000;
	int read = 0;
	long s;
	long e;
	
   //main method
	public static void main(String[] args){
		if(args.length == 0){
			new FindDups( "C:\\Public");
        
		}
      else if(args.length == 1){
			new FindDups(args[0]);
		}
      else{
			System.out.println("You must enter a directory in the arguments");
		}//e of else
	}//e of main method


   //param constructor
	public FindDups(String dir){
      //bwput to FindDups.txt file
		try{
			System.out.println("Processing files in specified directory: " + dir + "\n");
			BufferedWriter bw = new BufferedWriter(new FileWriter(dir + "\\FindDups.txt"));
			bw.write(dir+"\n");
			s = System.currentTimeMillis();
			bw.write("Start Time: " + simpleFormat.format(s) + "\n");
			bw.write(String.format("%-15s%-25s%s\n", "File Size", "Date Modified", "File Name"));
			s(dir, bw);
			e = System.currentTimeMillis();
			bw.write("End Time: " + simpleFormat.format(e) + "\n");
			bw.write("Processing Time: " + (e-s)/1000.0 + " seconds");
			bw.write("Number of Files Processed: " + read);
			System.out.println("Wrote duplicates to: " + dir + "\\FindDups.txt\n");

			try{
				bw.flush();
				bw.close();
			}
         catch(IOException e){
				e.getMessage();
            //System.bw.println("error e");
			}
		}//e of big try
      catch (IOException e){
			e.getMessage();
		}
	}//e of find dups method


	public void s(String dirString, BufferedWriter bw){
		//loading directory
		File[] fileItems = new File(dirString).listFiles();
		for(int i = 0; i< fileItems.length; i++) {
			//directory
			if(fileItems[i].isDirectory() && !fileItems[i].isHidden()){
				this.s((fileItems[i].toString()), bw);
				//files
			}
         else if(fileItems[i].isFile() && !fileItems[i].isHidden()){
				crcInfo.add(new Info(getCrc(fileItems[i]), fileItems[i]));
				read++;
			}
         else{
				try{
					bw.write((fileItems[i].getName() + " is hidden"));
				}
            catch(IOException e){
					e.getMessage();
				}
			}//end of if else
			//counter for all files
		}// end of for loop
		for(int n = 0; n < directoriesList.size(); n++){
			s(directoriesList.get(n).getPath(),bw);
		}
      
		Collections.sort(crcInfo);
		for(int k = 0; k < crcInfo.size()-1; k++){
      
			if(crcInfo.get(k).getCRC() == crcInfo.get(k+1).getCRC()){
				try{
					bw.write(String.format("%-12s%-12s%-27s%s\n",crcInfo.get(k).getCRC(), crcInfo.get(k).getFileObj().length(), simpleFormat.format(crcInfo.get(k).getFileObj().lastModified()), 
               crcInfo.get(k+1).getFileObj().getPath(),crcInfo.get(k).getFileObj().getName()));
					bw.write(String.format("%-12s%-12s%-27s%s\n",crcInfo.get(k+1).getCRC(),crcInfo.get(k+1).getFileObj().length(), 
               simpleFormat.format(crcInfo.get(k+1).getFileObj().lastModified()), crcInfo.get(k+1).getFileObj().getPath()));// // ,crcInfo.get(k+1).getFileObj().getName()));
				}
            catch (IOException e){
					e.getMessage();
				}
				//System.bw.println(crcInfo.get(k).getFileObject().getName() + " IS THE SAME AS " + crcInfo.get(k+1).getFileObject().getName());
			}//e of if for formatting
		}//e of for loop
	}//e of s method

   //print crc
	public long getCrc( File aFile ){
		byte [] buffer = new byte[SIZE];
		CRC32 crc = new CRC32();
		int length = 0;
		long cVal = -1;
		crc.reset();
		try{
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(aFile));

			while ((length = bis.read(buffer)) > -1){
				crc.update(buffer,0,length);
			}

			cVal = crc.getValue();
			bis.close();
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		return cVal;

	}//e getCrc() method
}//e of FindDups Class
                                                                                                                                                                                                                                                                                                                                                                                                    