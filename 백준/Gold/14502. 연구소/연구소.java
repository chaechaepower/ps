import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x: " + x + "y: " + y;
	}
}

public class Main {
	static boolean[][] visited;
	static int[] xDir = { -1, 1, 0, 0 }; // 상하좌우
	static int[] yDir = { 0, 0, -1, 1 };
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;// 안전 영역의 최대 크기
	static List<Pos> virus;
	static List<Pos> blank;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][m + 1];

		blank = new ArrayList<>();
		virus = new ArrayList<>();

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0) { // 빈칸 좌표 모음.
					blank.add(new Pos(i, j));
				} else if (num == 2) { // 바이러스 좌표 모음.
					virus.add(new Pos(i, j));
				}
				graph[i][j] = num;
			}
		}

		for (int i = 0; i < blank.size() - 2; i++) { // 벽 3개 세우는 모든 경우의 수
			for (int j = i+1; j < blank.size() - 1; j++) {
				for (int k = j+1; k < blank.size(); k++) {
					visited = new boolean[n + 1][m + 1]; // 방문 여부 초기화
					bfs(i, j, k);
				}
			}
		}
	

		System.out.println(max);
	}

	static void bfs(int p, int q, int r) {
		int[][] temp = new int[n + 1][m + 1];
		// 기존 그래프 복사
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				temp[i][j] = graph[i][j];
			}
		}

		Pos wall1 = blank.get(p);
		Pos wall2 = blank.get(q);
		Pos wall3 = blank.get(r);

		// 벽 설정
		temp[wall1.x][wall1.y] = 1;
		temp[wall2.x][wall2.y] = 1;
		temp[wall3.x][wall3.y] = 1;

		// 큐에 바이러스 넣음.
		Queue<Pos> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}
		
		// bfs
		while (!queue.isEmpty()) {
			Pos node = queue.poll();
			int x = node.x;
			int y = node.y;
		
			for (int i = 0; i < 4; i++) {
				int newX = x + xDir[i];
				int newY = y + yDir[i];
				
				if (newX < 1 || newX > n || newY < 1 || newY > m) {
					continue;
				}

				if (temp[newX][newY] == 0 && !visited[newX][newY]) { // 빈칸이고 방문 x
					temp[newX][newY] = 2; // 바이러스 확산
					visited[newX][newY] = true;
					queue.offer(new Pos(newX, newY));
				}
			}
		}

		// 안전구역 크기 구하기
		int area = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (temp[i][j] == 0) {
					area++;
				}
			}
		}

		max = Math.max(max, area);
	}

}
