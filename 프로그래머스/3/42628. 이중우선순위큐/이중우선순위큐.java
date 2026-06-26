import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (String str : operations) {
			String[] arr=str.split(" ");
			String op=arr[0];
			int data=Integer.parseInt(arr[1]);
			
			if(op.equals("I")) {
				maxHeap.offer(data);
				minHeap.offer(data);
			}
			
			else if(op.equals("D") && !maxHeap.isEmpty()) {
				
				if(data==1) {
					int max=maxHeap.poll();
					minHeap.remove(max);
				}
				
				else { // data ==-1
					int min=minHeap.poll();
					maxHeap.remove(min);
				}
			}
		}
		
		int[] answer = {};

		
		if(maxHeap.isEmpty()) {
			answer= new int[] {0,0};
		}
		else {
			answer= new int[] {maxHeap.peek(), minHeap.peek()};
		}

		return answer;
		
	}
}
