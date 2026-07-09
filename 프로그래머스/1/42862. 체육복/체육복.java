import java.util.Arrays;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {

		int[] clothes = new int[n + 1];

		Arrays.fill(clothes, 1);

		for (int i : lost) {
			clothes[i]--;
		}

		for (int i : reserve) {
			clothes[i]++;
		}

		for (int i = 1; i < n + 1; i++) {
			if (clothes[i] == 0) {
				if (i > 1 && clothes[i - 1] > 1) {
					clothes[i - 1]--;
					clothes[i]++;
				}

				else if (i < n && clothes[i + 1] > 1) {
					clothes[i + 1]--;
					clothes[i]++;
				}
			}
		}

		int answer = 0;

		for (int i = 1; i < n + 1; i++) {
			if (clothes[i] >= 1) {
				answer++;
			}
		}

		return answer;
	}
}
