import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

	public static int solution(int[][] jobs) {
		int time = 0; // 흐른 시간
		int idx = 0; // 현재 job
		int count = 0; // 처리한 job
		int res = 0; // 반환 시간의 합

		Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]); // 들어온 순서대로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> jobs[e1][1] - jobs[e2][1]);

		while (count < jobs.length) {
			while (idx < jobs.length && jobs[idx][0] <= time) {
				pq.offer(idx++);
			}

			if (pq.isEmpty()) {
				time = jobs[idx][0];
				continue;
			}

			int now = pq.poll();
			time += jobs[now][1];
			res += time - jobs[now][0];
			count++;
		}

		return res / jobs.length;
	}
}

/*
 * 대기큐에 작업을 저장했다가 하드디스크가 일을 안할 때 대기큐에서 꺼내서 실행 / 비선점
 * 
 * 
 */

//  [요청 시점, 소요시간]
// 반환시간 = 현재 흐른 시각 - 요청 시각 