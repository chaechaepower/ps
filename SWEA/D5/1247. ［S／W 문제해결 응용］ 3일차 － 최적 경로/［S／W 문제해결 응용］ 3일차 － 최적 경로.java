import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int n;
	static int[] company, home;
	static int[][] client;
	static boolean[] visited;
	static int[] result;
	static int minDis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			n = Integer.parseInt(br.readLine()); // 고객의 개수

			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new int[2];
			home = new int[2];

			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			client=new int[n][2];
			
			for (int i = 0; i < n; i++) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[n];
			result = new int[n];
			minDis = Integer.MAX_VALUE;
			perm(0);
			System.out.printf("#%d %d\n", t, minDis);
		}
	}

	private static void perm(int depth) {
		if (depth == n) {
			minDis = Math.min(minDis, cal());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			result[depth] = i;
			perm(depth + 1);
			visited[i] = false;
		}
	}

	private static int cal() {
		int dis = 0;

		// 회사~ 고객 1
		int idx=result[0];
		dis += Math.abs(company[0] - client[idx][0]) + Math.abs(company[1] - client[idx][1]);

		// 고객
		for(int i=0;i<n-1;i++) {
			int u=result[i];
			int v=result[i+1];
			dis += Math.abs(client[u][0] - client[v][0]) + Math.abs(client[u][1] - client[v][1]);
		}

		// 막 고객 ~ 집
		idx=result[n-1];
		dis += Math.abs(home[0] - client[idx][0]) + Math.abs(home[1] - client[idx][1]);

		return dis;
	}
}
