
class Solution {

	public int[] solution(int[] sequence, int k) {
		int left = 0;
		int sum = 0;
		int lAns = 0, rAns = 0;
		int len = Integer.MAX_VALUE;

		for (int right = 0; right < sequence.length; right++) {
			sum += sequence[right];

			while (sum > k) {
				sum -= sequence[left++];
			}

			if (sum == k) {
				// 값갱신
				if (right - left < len) {
					len = right - left;
					lAns = left;
					rAns = right;
				}
			}
		}

		return new int[] { lAns, rAns };
	}
}
