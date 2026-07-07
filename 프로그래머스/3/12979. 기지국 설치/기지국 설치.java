class Solution {
	public int solution(int n, int[] stations, int w) {

		int answer = 0;
		int cover = 2 * w + 1;

		int idx = 1;

		for (int st : stations) {
			int left = st - w;

			if (idx < left) {
				int len = left - idx;

				answer += len / cover;

				if (len % cover != 0) {
					answer++;
				}

			}

			idx = st + w+1;
		}
		
		if(idx<=n) {
			int len = n - idx+1;
			
			answer += len / cover;

			if (len % cover != 0) {
				answer++;
			}
		}
		
        return answer;
	}
}