import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		List<Integer> priority = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			priority.add(priorities[i]);
			queue.offer(new int[] { i, priorities[i] }); // 0: 인덱스, 1: 우선순위
		}

		Collections.sort(priority, (e1, e2) -> e2 - e1);
		
		int seq=0;

		while (! queue.isEmpty()) {
			int[] now=queue.peek();
			int idx=now[0];
			int prior=now[1];
			
			if(prior==priority.get(0)) { // 제일 최고 우선순위와 동일한지 
				queue.poll();
				priority.remove(0);
				seq++;
				
				if(idx==location) {
					return seq;
				}
			}

			else {
				queue.poll();
				queue.offer(new int[] {idx, prior});
			}
		}
		
		return seq;
	}
}