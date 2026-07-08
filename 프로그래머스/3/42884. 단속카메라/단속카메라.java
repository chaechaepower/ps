import java.util.Arrays;

class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

		int answer = 0;
		int idx = 0;

		while (true) {
			int[] cur = routes[idx];
			int installed = cur[1];

			answer++;

			while (true) {
				idx++;

				if (idx == routes.length) {
					break;
				}

				int[] next = routes[idx];

				if (installed < next[0] || installed > next[1]) {
					break;
				}
			}
			
			if (idx == routes.length) {
				break;
			}
		}

		return answer;
	}
}