class Solution {
	int n;
	int cnt;

	public int solution(int[] numbers, int target) {
		n = numbers.length;
		dfs(0, 0, numbers, target);
		return cnt;
	}

	private void dfs(int idx, int sum, int[] numbers, int target) {
		if (idx == n) {
			if (sum == target) {
				cnt++;
			}
			return;
		}

		dfs(idx + 1, sum + numbers[idx], numbers, target);
		dfs(idx + 1, sum - numbers[idx], numbers, target);
	}
}