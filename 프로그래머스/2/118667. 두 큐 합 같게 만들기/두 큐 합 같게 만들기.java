import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		long sum1 = 0, sum2 = 0;
		int len = queue1.length;

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		for (int i = 0; i < len; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];

			q1.offer(queue1[i]);
			q2.offer(queue2[i]);
		}

		if ((sum1 + sum2) % 2 != 0) { // 정확하게 반으로 나눌 수 없는 경우
			return -1;
		}

		long target = (sum1 + sum2) / 2;
		int move = 0;
		int cnt = 0;

		while (move <= 4 * len) {
			if (sum1 == target) {
				return cnt;
			}

			if (sum1 < target) {
				int num = q2.poll();
				q1.offer(num);
				
				sum1 += num;
				sum2 -= num;
				
				cnt++;
				move++;
			}

			else if (sum2 < target) {
				int num = q1.poll();
				q2.offer(num);
				
				sum2 += num;
				sum1 -= num;
				
				cnt++;
				move++;
			}
		}

		return -1;
	}
}