import java.util.*;

class Solution {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
		
        for(String operation:operations){
            switch(operation){
                case "D 1":
                    if(!maxHeap.isEmpty()){
                        int max= maxHeap.poll();
                        minHeap.remove(max);
                    }
                    break;
                    
                case "D -1":
                    if(!minHeap.isEmpty()){
                        int min= minHeap.poll();
                        maxHeap.remove(min);
                    }
                    break;
                    
                default: 
                    int num=Integer.parseInt(operation.split(" ")[1]);
                    minHeap.offer(num);
                    maxHeap.offer(num);
            }
        }
        
        if(minHeap.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{maxHeap.poll(),minHeap.poll()};
        }
        
	}
}
