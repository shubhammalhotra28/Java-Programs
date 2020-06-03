/** Exercise the user written ExamStack class
	This is supplied starter code
	219 Practical 2 
	
	@author ?????
 */
import java.util.*;
import java.io.*;

public class TestExam2Stack {

   public static void main(String [] args){
   	
   	// Create a stack object 
      ExamStack es = new ExamStack();
   	// Push some objects onto the stack
      es.push("Alpha");
      es.push("Beta");
      es.push("Gamma");
      es.push("Delta");
      es.push("Epsilon");
   	
   	// Peek at the top object
      String top = es.peek();
      System.out.println("Top item is "+ top );
   	
      System.out.println("Stack removal of items:");
   	// Get all the objects off the stack within a loop using the isEmpty() method
   	// loop
   	
   									// <<<<<<<<< YOU MUST WRITE CODE HERE TO LOOP
   									// <<<<<<<<< LOOP UNTIL EMPTY, NOT HARD CODED 5 TIMES
      for(int i=0;i<5;i++){
      	// Get the top item off the stack & print it
         String item = es.pop();
         System.out.println( ">  " + item );
      }
   	// end loop
   	
   	
   	
   	// After everything is off the stack, 
   	// make sure the isEmpty() method is really working
      if( es.isEmpty() )
         System.out.println("The stack is now empty. This is good.");
      else
         System.out.println("The stack says it is not empty. This is bad.\n"+
            					 "Did you add the loop to the main program?");
   	
   }
}
class ExamStack{
private ArrayList<String> al = new ArrayList<>();
      public String push(String ms) {
        al.add(ms);
        return (""+ms);
    }
    public String pop() {
        if(al.size()==0)
            System.out.println("It is empty");
        return al.remove(al.size()-1);
    }
    public boolean isEmpty() {
 		return (al.size() == 0);
 	}
   public int size() {
 		return al.size();
 	}
   public String peek() {
 		if (!isEmpty())
 			return al.get(size()-1);
 		else{
 			String p = "It is empty...";
         return p;
         }
 	}
}
      
