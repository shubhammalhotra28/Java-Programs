import java.io.*;
/*
LAB 3
PART 1
NAME SHUBHAM MALHOTRA
*/

class Testdata{
  public static void main(String args[]) {
         new Testdata();
    }
  
      public Testdata(){
    
    try {
      
      FileInputStream fis = new 	FileInputStream("ClassList.dat");
		BufferedInputStream bis = new BufferedInputStream( fis );
      DataInputStream dis = new DataInputStream(bis);
      System.out.printf("%-16s %9s %4s %4s %4s %4s %4s" ,"Name","ID", "Grade1", "Grade2", "Grade3", "Grade4","Avg." )  ;    //String s;
      while(dis.available() > 0){
      String str = dis.readUTF();
      int id = dis.readInt(); 
      double data1 = dis.readDouble();
      double data2 = dis.readDouble();
      double data3 = dis.readDouble();
      double data4 = dis.readDouble();
      double data5 = (data1+data2+data3+data4)/4; 
      System.out.printf("\n"+"%-16s %12s %5s %5s %5s %5s ",str,data1,data2,data3,data4,data5+"\n");    
            
    }  

		dis.close();
    }
    catch(Exception e) {
      System.out.println("Exception: " + e.getMessage());
		e.printStackTrace();
    }
 }




















































































































}
