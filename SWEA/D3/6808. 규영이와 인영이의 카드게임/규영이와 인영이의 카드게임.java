import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] in, gyo, result;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 규영 카드 초기화
			gyo = new int[9];
			boolean[] check = new boolean[19]; // 1~18

			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyo[i] = num;
				check[num] = true;
			}

			// 인영 카드 초기화
			in = new int[9];
			for (int i = 1, idx = 0; i <= 18; i++) {
				if (check[i])
					continue;

				in[idx++] = i;
			}

			visited = new boolean[9];
			result=new int[9];
			
			answer=0;
			perm(0);
			System.out.printf("#%d %d %d\n", t, answer, per(9)-answer);
		}

	}

	public static void perm(int depth) {
		if (depth == 9) {
			if (isGyoWin())
				answer++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			result[depth] = in[i];

			perm(depth + 1);

			visited[i] = false;
		}
	}

	public static boolean isGyoWin() {
		int inSum = 0, gyoSum = 0;

		for (int i = 0; i < 9; i++) {
			if (gyo[i] > result[i]) {
				gyoSum += gyo[i] + result[i];
			} else {
				inSum += gyo[i] + result[i];
			}
		}

		return gyoSum > inSum;
	}

	public static int per(int n) {
		if (n == 1)
			return 1;

		return n * per(n - 1);
	}
}

/*
 * 모든 순열을 구한다. 각 경우마다 계산한다
 * 
 */
