/*
Reference - https://www.callicoder.com/java-priority-queue/

*/

import java.io.*;
import java.util.*;



public class Priorityqueue{
    public static void main(String[] args) {
        new Priorityqueue();
        }
        public Priorityqueue(){
        // Create a Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Add items to a Priority Queue (ENQUEUE)
        pq.add(700);
        pq.add(420);
        pq.add(990);
        pq.add(110);
        pq.add(1000);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!pq.isEmpty()) {
            System.out.println("Removed: "+pq.remove());
        }

    }
}