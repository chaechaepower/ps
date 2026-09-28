import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {
	static List<Integer>[] list;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		int[][] wires = {
			    {1, 3},
			    {2, 3},
			    {3, 4},
			    {4, 5},
			    {4, 6},
			    {4, 7},
			    {7, 8},
			    {7, 9}
			};
		
		int answer=solution(9,wires);
		System.out.println(answer);
	}

	public static int solution(int n, int[][] wires) {
		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < wires.length; i++) {
			int u = wires[i][0];
			int v = wires[i][1];
			list[u].add(v);
			list[v].add(u);
		}
		
		// 간선 하나씩 제거	
		ans=Integer.MAX_VALUE;
		
		for(int[] wire:wires) {
			int u=wire[0];
			int v=wire[1];
			
			list[u].remove(Integer.valueOf(v));
			list[v].remove(Integer.valueOf(u));
			
			visited = new boolean[n + 1];
			int a=dfs(u);
			int diff = Math.abs(a - (n-a));
			
			ans = Math.min(diff, ans);
			
			list[u].add(v);
			list[v].add(u);
		}
		
		return ans;
	}

	private static int dfs(int v) {
		visited[v] = true;

		int total = 1;

		for (int e : list[v]) {
			if (visited[e])
				continue;
			
			total += dfs(e);
		}

		return total;
	}
}

/*
 * 
 * 
 * 간선 하나씩 끊고 각 그룹 송전탑 개수 구함
 * 
 * 
 * 
 */
