class Solution {
	public int[] solution(int[] sequence, int k) {

		int left = 0, right = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0, end = 0;

		for (right = 0; right < sequence.length; right++) {
			sum += sequence[right];

			while (sum > k) {
				sum -= sequence[left++];
			}

			if (sum == k) {
				if (right - left < minLen) {
					minLen = right - left;
					start = left;
					end = right;
				}
			}
		}

		return new int[] { start, end };
	}
}