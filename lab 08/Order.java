import java.io.*;


import java.util.*;

class Order implements Serializable{
    String name;
    int number;
    int count;
    private static final long serialversionUID = 129348938L; 
   public Order(String _name,int no,int cnt){
      name = _name;
      number = no;
      count = cnt;
   
   }
   public String toString(){
      
      String a = "name = "+ name +", number = " +number+", count = "+count;
      
      return a;
   }
}