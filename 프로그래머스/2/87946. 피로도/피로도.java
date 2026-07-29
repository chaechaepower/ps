class Solution {
	int n;
	int[][] arr;
	boolean[] visited;
	int answer;

	public int solution(int k, int[][] dungeons) {
		n = dungeons.length;
		arr = dungeons;
		visited = new boolean[n];

		answer = 0;

		perm(0, k);

		return answer;
	}

	public void perm(int depth, int now) {
		answer = Math.max(answer, depth);

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			if (now < arr[i][0])
				continue; // 현재 피로도가 최소 필요 피로도보다 작으면 스킵

			visited[i] = true;
			perm(depth + 1, now - arr[i][1]);
			visited[i] = false;
		}
	}
}
