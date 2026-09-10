import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
	static char[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			nums = br.readLine().toCharArray();

			Set<Integer> set = new HashSet<>();

			// 최초
			for (int i = 0; i < n; i += n / 4) {
				// nums를 n/4씩 끊어서 10진수 변환 뒤 set에 넣는다.
				set.add(hexToDec(i, i + n / 4 - 1));
			}

			// 회전 3번
			for (int i = 0; i < n/4; i++) {
				char last = nums[n - 1];

				for (int j = n - 1; j >= 1; j--) {
					nums[j] = nums[j - 1];
				}

				nums[0] = last;

				for (int j = 0; j < n; j += n / 4) {
					// nums를 n/4씩 끊어서 10진수 변환 뒤 set에 넣는다.
					set.add(hexToDec(j, j + n / 4 - 1));
				}
			}

			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.printf("#%d %d\n", t, list.get(k-1));
		}
	}

	private static int hexToDec(int start, int end) {
		int dec = 0;

		for (int i = end, j = 0; i >= start; i--, j++) {
			int mul = (int) Math.pow(16, j);

			if (nums[i] >= '0' && nums[i] <= '9') {
				dec += (nums[i] - '0') * mul;
			} else { // 알파벳
				dec += (10 + (nums[i] - 'A')) * mul;
			}
		}

		return dec;
	}
}

/*
 * 3회전으로 만들 수 잇는 모든 수(중복 x) k번째로 큰 수 (10진수)
 * 
 */
