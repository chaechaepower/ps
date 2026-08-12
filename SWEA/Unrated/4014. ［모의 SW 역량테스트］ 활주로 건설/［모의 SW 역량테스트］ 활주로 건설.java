import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Solution {
	static int x;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken()); // 한 변 크기
			x = Integer.parseInt(st.nextToken()); // 경사로 길이

			// 지형 정보 저장
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = 0;
			// 가로
			for (int i = 0; i < n; i++) {
				int[] arr = new int[n];

				for (int j = 0; j < n; j++) {
					arr[j] = board[i][j];
				}

				if (check(arr))
					answer++;
			}

			// 세로
			for (int j = 0; j < n; j++) {
				int[] arr = new int[n];

				for (int i = 0; i < n; i++) {
					arr[i] = board[i][j];
				}

				if (check(arr))
					answer++;
			}

			System.out.printf("#%d %d\n", t, answer);
		}
	}

	private static boolean check(int[] line) {
		int i = 0;
		int prev = line[i++];
		boolean[] used = new boolean[line.length];

		while (i < line.length) {
			int now = line[i];

			if (prev == now) {
				i++;
				continue;
			}
			
		    if (Math.abs(prev - now) > 1) {
		        return false;
		    }

			// 올라가는 경우
			if (prev < now) {
				int count = 0;

				for (int j = i - 1; j >= 0; j--) {

					// 낮은 쪽은 prev와 같은 높이여야 함
					if (prev != line[j] || used[j]) {
						return false;
					}

					count++;
					used[j] = true;

					if (count == x) {
						break;
					}
				}

				if (count < x) {
					return false;
				}
			}

			// 내려가는 경우
			if (prev > now) {
				int count = 0;

				for (int j = i; j < line.length; j++) {

					// 낮은 쪽은 now와 같은 높이여야 함
					if (now != line[j] || used[j]) {
						return false;
					}

					count++;
					used[j] = true;

					if (count == x) {
						break;
					}
				}

				if (count < x) {
					return false;
				}

				// 경사로로 사용한 X칸은 건너뜀
				i += x - 1;
			}

			prev = now;
			i++;
		}

		return true;
	}
}

/*
 * 1. 증감지점 찾기 2. 작은쪽이 활주로 길이만큼 존재하는지 파악
 * 
 */
