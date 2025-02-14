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
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int size=2; // 상어 크기
	static int stack; // 먹은 물고기 수
	static List<int[]> availFish; // 0:row, 1:col, 2:아기상어와의 거리
	static int time; // 더이상 먹을 수 있는 물고기가 없을 때까지 걸리는 시간(정답)
	static int sharkR, sharkC; // 현재 상어 위치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					sharkR = i;
					sharkC = j;
					arr[i][j] = 0; //안해주면, 아기 상어의 크기가 9보다 클 경우, 9를 물고기로 착각해서 먹게됨. 현재 상어 위치만 있으면 됨. 
				}
			}
		}
		shark();
		System.out.println(time);
	}

	static void shark() {
		availFish = new ArrayList<>();

		// 먹을 수 있는 물고기 파악
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (i == sharkR && j == sharkC) {
					continue;
				}

				if (0 < arr[i][j] && arr[i][j] < size) {
					availFish.add(new int[] { i, j, 0 });
				}
			}
		}
		
		// 전체 bfs 후 fish[2]로 최솟값 비교. 최솟값 여러 개이면 또 비교해야. 최종 하나 선택 후 상어 위치 이동
		for (int i = 0; i < availFish.size(); i++) {
			bfs(i);
		}
		
		// 거리가 0인거 삭제(그 물고기에 도달 못함)
		for (int i = availFish.size() - 1; i >= 0; i--) {
			int[] fish = availFish.get(i);
			if (fish[2] == 0) {
				availFish.remove(i);
			}
		}

		if (availFish.size() == 0) {
			return;

		} else if (availFish.size() == 1) {
			// bfs로 시간 계산 후 전체 시간에 누적
			bfs(0);
			eatFish(0);
			shark();

		} else { // 먹을 수 있는 물고기가 여러 개

			// 최솟값 비교 먼저
			availFish.sort((o1, o2) -> {
				if (o1[2] == o2[2]) {// 거리가 같다면
					if (o1[0] == o2[0]) { // 행이 같다면
						return o1[1] - o2[1]; // 열을 비교
					} else {
						return o1[0] - o2[0];
					}
				} else {
					return o1[2] - o2[2];
				}
			});
			eatFish(0);
			shark();
		}
	}

	static void eatFish(int idx) {
		int[] fish = availFish.get(idx);
		int fishR = fish[0];
		int fishC = fish[1];
		int dis = fish[2];

		time += dis;

		stack++; // 물고기 먹음
		if (size == stack) {
			size++;
			stack = 0;
		}

		sharkR = fishR; // 상어 위치 이동
		sharkC = fishC;
		arr[fishR][fishC] = 0; // 빈칸으로
	}

	static void bfs(int idx) { // (fishR, fishC)가 목적지
		int[] fish = availFish.get(idx);
		int fishR = fish[0];
		int fishC = fish[1];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { sharkR, sharkC, 0 });
		boolean[][] visited = new boolean[n][n];
		visited[sharkR][sharkC] = true;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int nowR = node[0];
			int nowC = node[1];

			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int newR = nowR + dr[i];
				int newC = nowC + dc[i];

				if (newR < 0 || newR > n - 1 || newC < 0 || newC > n - 1) {
					continue;
				}

				if (newR == fishR && newC == fishC) { // 목적지에 도달하면
					fish[2] = node[2] + 1;
					flag = true;
					break;
				}

				if (size < arr[newR][newC]) { // 아기 상어보다 크기가 큰 물고기
					continue;
				}

				if (!visited[newR][newC]) {
					queue.offer(new int[] { newR, newC, node[2] + 1 });
					visited[newR][newC] = true;
				}
			}

			if (flag) {
				break;
			}
		}
	}
}
