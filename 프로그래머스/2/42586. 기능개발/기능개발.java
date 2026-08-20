import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int len = progresses.length;

		int[] days = new int[len];

		for (int i = 0; i < len; i++) {
			int mod = (100 - progresses[i]) / speeds[i];
			int rem = (100 - progresses[i]) % speeds[i];

			if (rem == 0) {
				days[i] = mod;
			} else {
				days[i] = mod + 1;
			}
		}

		List<Integer> result = new ArrayList<>();
		int count = 1;
		int prev = days[0];

		for (int i = 1; i < len; i++) {
			if (days[i] <= prev) {
				count++;
			} else {
				result.add(count);
				count = 1;
				prev = days[i];
			}
		}

		if (count > 0) {
			result.add(count);
		}

		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}

/*
 * 1. 각 기능별 며칠 뒤 배포 가능한지 확인 2. 자기보다 작은거까지 세기
 * 
 */
