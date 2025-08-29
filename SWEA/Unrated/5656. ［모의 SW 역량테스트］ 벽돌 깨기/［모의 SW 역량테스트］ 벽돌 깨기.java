import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int N, W, H, min;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			
			int totalCount=0;

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]>0) totalCount ++;
				}
			}

			min = Integer.MAX_VALUE;
			drop(0, totalCount, map);
			System.out.println("#" + t + " " + min);
		}
	}

	private static boolean drop(int count, int remainCnt, int[][] map) {
		if(remainCnt==0) {
			min=0;
			return true; // 남은 벽돌이 존재하지 않음. 최적해
		}
		if(count==N) {
			min=Math.min(min, remainCnt);
			return false; // 남은 벽돌이 있다. 다른 경우도 고려해봐야. 
		}
		
		// 전달받은 배열을 백업으로 사용해야하므로 새로운 배열 생성해서 작업
		int[][] newMap = new int[H][W];

		// 구슬을 모든 열에 던지는 시도(중복 순열)
		for (int c = 0; c < W; c++) {
			// step1. c열에 던졌을 때 깨지는 맨 위 벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;
			// 벽돌이 없다면 비어있는 열이므로 다음 열로 구슬 던지기
			if (r == H)
				continue;

			// step2. 깨질 벽돌을 찾았으니 연쇄 작업 처리
			copy(map, newMap);
			// 깨지는 벽돌 주변으로 함께 깨지는 벽돌 찾기
			int brickCnt=boom(newMap, r, c);

			// 남은 벽돌 정리
			if(brickCnt>1) down(newMap); //벽돌이 하나만 깨지면 딱 처음 맞닿는 부분만 깨지므로 굳이 정리할 필요x(최적화)

			// 다음 구슬 던지러 가기
			if(drop(count+1, remainCnt-brickCnt, newMap)) return true;
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int count=0;
		for(int r=0;r<H;r++) {
			for(int c=0;c<W;c++) {
				if(map[r][c]>0) ++count;
			}
		}
		return count;
	}

	static Stack<Integer> stack=new Stack<>();
	
	private static void down(int[][] map) {
		for(int c=0;c<W;c++) { // 남은 벽돌 알아냄.
			for (int r = 0; r < H; r++) {
				if(map[r][c]==0) continue;
				stack.push(map[r][c]); //벽돌이면 넣기 
				map[r][c]=0; //빈칸으로 만듦.
			}
			
			int r=H-1;
			while(!stack.isEmpty()) {
				map[r][c]=stack.pop();
				r--;
			}
		}
	}

	private static int boom(int[][] map, int r, int c) {
		int cnt=0;
		
		Queue<Point> queue = new ArrayDeque<>();
		if (map[r][c] > 1) { //크기가 1이면 안넣어도 됨. 
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 큐에 들어가는 애는 반드시 제거됨. 따로 방문 처리 배열 대신 이렇게.
		cnt++;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r, nc = cur.c;
				
				for (int k = 0; k < cur.cnt - 1; k++) {
					
					nr += dr[d];
					nc += dc[d];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

	private static void print(int i, int j, int[][] map, boolean flag) {
		System.out.println(i + ", " + j + (flag ? " 전" : " 후") + " ================");
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
}
