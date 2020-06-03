/*
   Reference - https://www.geeksforgeeks.org/priority-queue-using-linked-list/
*/ 
import java.util.* ; 
  
class Pq 
{ 
    
    
// Node  
   static class Node {  
      int data1;  
    
    // Lower values indicate higher priority  
      int priority1;  
    
      Node next1;  
    
   } 
  
   static Node node1 = new Node(); 
    
// Function to Create A New Node  
   static Node Node(int d, int p)  
   {  
      Node temp1 = new Node();  
      temp1.data1 = d;  
      temp1.priority1 = p;  
      temp1.next1 = null;  
    
      return temp1;  
   }  
    
// Return the value at head  
   static int peek(Node head1)  
   {  
      return (head1).data1;  
   }  
    
// Removes the element with the  
// highest priority form the list  
   static Node pop(Node head1)  
   {  
      Node temp1 = head1;  
      (head1)  = (head1).next1;  
      return head1; 
   }    
    
// Function to push according to priority  
   static Node push(Node head1, int d, int p)  
   {  
      Node start = (head1);  
    
    // Create new Node  
      Node temp1 = Node(d, p);  
    
    // Special Case: The head of list has lesser  
    // priority than new node. So insert new  
    // node before head node and change head node.  
      if ((head1).priority1 > p) {  
      
        // Insert New Node before head  
         temp1.next1 = head1;  
         (head1) = temp1;  
      }  
      else {  
      
        // Traverse the list and find a  
        // position to insert new node  
         while (start.next1 != null &&  
               start.next1.priority1 < p) {  
            start = start.next1;  
         }  
      
        // Either at the ends of the list  
        // or at required position  
         temp1.next1 = start.next1;  
         start.next1 = temp1;
      }  
      return head1; 
   }  
    
// Function to check is list is empty  
   static int isEmpty(Node head1)  
   {  
      return ((head1) == null)?1:0;  
   }  
    
   public static void main(String args[]) 
   {  
    // Create a Priority Queue  
      Node pq = Node(5, 1);  
      pq =push(pq, 6, 2);  
      pq =push(pq, 7, 3);  
      pq =push(pq, 8, 0);  
    
      while (isEmpty(pq)==0) {  
         System.out.printf("%d ", peek(pq));  
         pq=pop(pq);  
      }  
    
   }  
}