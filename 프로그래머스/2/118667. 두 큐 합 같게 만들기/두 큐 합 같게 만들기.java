import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public int solution(int[] queue1, int[] queue2) {
		long sum1 = 0, sum2 = 0;

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];

			q1.offer(queue1[i]);
			q2.offer(queue2[i]);
		}

		if ((sum1 + sum2) % 2 != 0)
			return -1;

		long target = (sum1 + sum2) / 2;
		int move = 0, cnt = 0;

		while (move <= 4 * queue1.length) {
			if(sum1==target) {
				return cnt;
			}
			
			if(sum1<target) {
				int v=q2.poll();
				q1.offer(v);
				
				sum2-=v;
				sum1+=v;
				
				move++;
				cnt++;
			}
			
			else if(sum2<target) {
				int v=q1.poll();
				q2.offer(v);
				
				sum1-=v;
				sum2+=v;
				
				move++;
				cnt++;
			}
		}
		
		return -1;
	}
}
