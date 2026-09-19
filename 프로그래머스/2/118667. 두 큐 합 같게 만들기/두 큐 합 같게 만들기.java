import java.util.LinkedList;
import java.util.Queue;

class Solution{

public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long total = 0, sum1 = 0, sum2 = 0;

		for (int e : queue1) {
			q1.offer(e);
			sum1 += e;
		}

		for (int e : queue2) {
			q2.offer(e);
			sum2 += e;
		}
    
        total = sum1 + sum2;
		
		if(total%2!=0) {
			return -1;
		}
		
		total/=2;

		int count = 0;

		while (count < (queue1.length + queue2.length)*4) {

			if (sum1 == sum2) {
				break;
			}

			else if (sum1 > sum2) {
				int out = q1.poll();
				q2.offer(out);
				sum1 -= out;
				sum2 += out;
				count++;
			}

			else { // sum2>sum1
				int out = q2.poll();
				q1.offer(out);
				sum2 -= out;
				sum1 += out;
				count++;
			}
		}

		// 결과
		if (sum1 == total) {
			return count;
		} else {
			return -1;
		}
	}
    }