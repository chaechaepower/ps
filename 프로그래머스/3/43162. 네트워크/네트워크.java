class Solution {
    boolean[] visited;
    
	public int solution(int n, int[][] computers) {
		visited = new boolean[n];

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, computers);
				answer++;
			}
		}

		return answer;

	}
    
    public void dfs(int x, int[][] arr) {
        visited[x] = true;

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[x][i] == 1) {
                dfs(i, arr);
            }
        }
    }
}