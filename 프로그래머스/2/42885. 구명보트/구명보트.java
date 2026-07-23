import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		
		int l = 0, r = people.length - 1;

		int answer = 0;

		while (l < r) {
			if (people[l] + people[r] <= limit) {
				answer++;
				l++;
				r--;
			} 
			else {
				answer++;
				r--;
			}
		}

		if (l == r) {
			answer++;
		}
		
		return answer;
	}
}
