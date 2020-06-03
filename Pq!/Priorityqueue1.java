/*
Reference - https://www.callicoder.com/java-priority-queue/

*/

import java.io.*;
import java.util.*;



public class Priorityqueue1{
    public static void main(String[] args) {
        new Priorityqueue1();
        }
        public Priorityqueue1(){
        // Create a Priority Queue
        PriorityQueue<String> pq = new PriorityQueue<String>();

        // Add items to a Priority Queue (ENQUEUE)
        pq.add("One");
        pq.add("Two");
        pq.add("Three");
        pq.add("Four");
        pq.add("Five");
        pq.add("six");
        pq.add("Six");
        pq.add("apple");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!pq.isEmpty()) {
            System.out.println("Removed: "+pq.remove());
        }

    }
}