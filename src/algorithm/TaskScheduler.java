package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	 public static int leastInterval(char[] tasks, int n) {
		 Map<Character,Integer> map=new HashMap<>();
		 for(char c:tasks){
			 map.put(c, map.getOrDefault(c, 0)+1);
		 }
		 PriorityQueue<Task>maxHeap=new PriorityQueue<>((a,b)->b.total-a.total);
		 
		return n;
	        
	    }
	 class Task{
		 int total;
         char character;
         
         public Task(){
        	 
         }
	 }

	public static void main(String[] args) {
		

	}

}
