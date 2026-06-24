import java.util.Collections;
import java.util.PriorityQueue;
class Solution {

	public long solution(int n, int[] works) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}

		for (int i = 0; i < n; i++) {
			int temp = pq.poll();

			if (temp <= 0) {
				return 0;
			}

			pq.offer(temp - 1);
		}

		long answer = 0;

		while (!pq.isEmpty()) {
			long x = pq.poll();
			answer += x * x;
		}

		return answer;
	}
}
