import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] list;
	static int[] population;
	static List<Integer> site1 = new ArrayList<>();
	static List<Integer> site2 = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		population = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());

			while (cnt-- > 0) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		comb(1, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void comb(int v, int depth) {
		if (depth == n) {
			if (site1.size() > 0 && site1.size() <= n / 2) {
				site2.clear();
				for (int i = 1; i <= n; i++) {
					if (!site1.contains(i)) {
						site2.add(i);
					}
				}
				// 적절한 선거구인지 확인
				if (isConnected(site1) && isConnected(site2)) {
					int sum1 = 0, sum2 = 0;

					for (int e : site1) {
						sum1 += population[e];
					}
					for (int e : site2) {
						sum2 += population[e];
					}
					min = Math.min(Math.abs(sum1 - sum2), min);
				}
			}
			return;
		}

		site1.add(v);
		comb(v + 1, depth + 1);

		site1.remove(site1.size() - 1);
		comb(v + 1, depth + 1);
	}

	public static boolean isConnected(List<Integer> site) {
		if (site.size() == 1) return true;

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> que = new LinkedList<>();
		que.offer(site.get(0));
		visited[site.get(0)] = true;

		int cnt=1;
		
		while(!que.isEmpty()) {
			int cur=que.poll();
			
			for(int nxt:list[cur]) {
				if(!site.contains(nxt) || visited[nxt]) continue;
				visited[nxt]=true;
				cnt++;
				que.offer(nxt);
			}
		}
		
		return cnt == site.size();
	}
}
