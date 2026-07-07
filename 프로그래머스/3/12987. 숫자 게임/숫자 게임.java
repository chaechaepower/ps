import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
    	PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
    	
    	for(int i=0;i<A.length;i++) {
    		pq1.offer(A[i]);
    		pq2.offer(B[i]);
    	}
    	
    	int score=0;
    	
    	 while(!pq1.isEmpty()) {
    		 int a=pq1.poll();    		
    		 int b=pq2.peek();
    		 
    		 if(a>=b) {
    			 continue;
    		 }
    		 else {
    			 pq2.poll();
    			 score++;
    		 }
    	 }
    	 
    	 return score;
    }
}