/** Exercise the user written ExamQueue class 
	This is supplied starter code
	219 Practical 2 
	
	@author ?????
*/
import java.util.*;
import java.io.*;
public class TestExam2Queue {

   public static void main(String [] args){
   	
   	// Create a queue object 
      ExamQueue eq = new ExamQueue();
   	
   	// Push some objects onto the Queue
      eq.enqueue("Alpha");
      eq.enqueue("Beta");
      eq.enqueue("Gamma");
      eq.enqueue("Delta");
      eq.enqueue("Epsilon");
   	
   	// Peek at the top object
      String top = eq.peek();
      System.out.println("Top item is "+ top );
   	
      System.out.println("Queue removal of items:"); // DO NOT CHANGE CODE ABOVE HERE
   	
   	// Get all the objects off the Queue within a loop using the isEmpty() method
   	// loop
      for(int i=0;i<5;i++){
      						// <<<<<<<<< ONLY ALLOWED TO ADD CODE IN THIS AREA FOR LOOPING
      						// <<<<<<<<< You must write code here to loop
      						// <<<<<<<<< LOOP UNTIL EMPTY, NOT HARD CODED 5 TIMES
      
      	// Get the top item off the Queue & print it  (DO NOT CHANGE THESE TWO LINES OF CODE)
         String item = eq.dequeue();
         System.out.println( ">  " + item );
      }
   	// <<<<< end loop
   	
   	
   															// DO NOT CHANGE CODE BELOW HERE IN THIS CLASS
   	// After everything is off the Queue, 
   	// make sure the isEmpty() method is really working
      if( eq.isEmpty() )
         System.out.println("The Queue is now empty. This is good.");
      else
         System.out.println("The Queue says it is not empty. This is bad.\n"+
            					 "Did you add the loop to the main program?");
   	
   }
}

// YOU NEED TO COMPLETE THE "ExamQueue" CLASS

// Add all your code into this class
class ExamQueue {
   private ArrayList<String> al = new ArrayList<>();
   public String enqueue(String ms){
      al.add(ms);
      return(""+ms);
   }
   public String dequeue(){
		String p = al.get(0);
		al.remove(0);
		
		return p;
	} 
    public int size() {
 		return al.size();
 	}
      public String peek() {
 		if (!isEmpty())
 			return al.get(size()-1);
 		else{
 			String empty = "It is empty...";
         return empty;
         }
 	}
     public boolean isEmpty() {
 		return (al.size() == 0);
 	}
   
}
