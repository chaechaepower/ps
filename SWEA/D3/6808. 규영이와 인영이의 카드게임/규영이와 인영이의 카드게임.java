import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static List<Integer> gyo, in;
	static boolean visited[];
	static int win, lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			gyo = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				gyo.add(Integer.parseInt(st.nextToken()));
			}

			in = new ArrayList<>();
			for (int i = 1; i <= 18; i++) {
				if (!gyo.contains(i)) {
					in.add(i);
				}
			}

			win=0;
			lose=0;
			visited = new boolean[9];
			perm(0, 0, 0);

			System.out.printf("#%d %d %d\n", t, win, lose);
		}
	}

	private static void perm(int inSum, int gyoSum, int depth) {
		if (depth == 9) {
			if (gyoSum > inSum) {
				win++;
			}
			
			else if(gyoSum < inSum) {
				lose++;
			}
			
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;

			// 게임
			int gyoNow = gyo.get(depth);
			int inNow = in.get(i);

			if (gyoNow > inNow) {
				perm(inSum, gyoSum+ (gyoNow + inNow), depth+1);
			} else {
				perm(inSum +(gyoNow + inNow), gyoSum, depth+1);
			}
			
			visited[i] = false;
		}
	}
}

/*
 * 규영이가 낸 카드 규영이가 이기는 경우/지는 경우
 * 
 * 높은 수 -> 합 낮은 수 -> 점수 x
 * 
 * 순서를 정한다. 게임 시작 이긴 경우에 win++
 
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18
 
 */



