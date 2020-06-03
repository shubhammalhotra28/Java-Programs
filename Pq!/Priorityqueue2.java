/*
Reference - https://www.callicoder.com/java-priority-queue/

*/

import java.io.*;
import java.util.*;



public class Priorityqueue2{
    public static void main(String[] args) {
        new Priorityqueue2();
        }
        public Priorityqueue2(){
        //Creating a comparator
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String x1, String y1){
               if(x1.length()<y1.length()){
                  return -1;
               }
               else if(x1.length()>y1.length()){
                  return 1;
               }
               else{
                  return 0;
               }
            }     
        };
        // Create a Priority Queue
        PriorityQueue<String> pq = new PriorityQueue<String>(comp);

        // Add items to a Priority Queue (ENQUEUE)
        pq.add("One");
        pq.add("Four");
        pq.add("Seventeen");
        pq.add("Three");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!pq.isEmpty()) {
            System.out.println("Removed: "+pq.remove());
        }

    }
}