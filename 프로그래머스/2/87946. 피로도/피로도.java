import java.io.IOException;

class Solution {

	static int[][] dungeons;
	static boolean[] visited;
	static int len;
	static int ans;

	public static void main(String[] args) throws IOException {

	}

	public static int solution(int k, int[][] dungeons) {
		Solution.dungeons = dungeons;
		len = dungeons.length;
		visited = new boolean[len];

		dfs(0, k);
		return ans;
	}

	private static void dfs(int depth, int now) {

		ans = Math.max(ans, depth);

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				if (now >= dungeons[i][0]) {
					visited[i] = true;
					dfs(depth + 1, now - dungeons[i][1]);
					visited[i] = false;
				}
			}
		}
	}
}

/*
 * dfs 순열
 * 
 */
