import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String[] args) throws IOException {
		int[] cookie= {1,1,2,3};
		System.out.println(solution(cookie));
	}

	public static int solution(int[] cookie) {
		if (cookie.length == 1) {
			return 0;
		}

		int answer = 0;

		for (int i = 0; i < cookie.length - 1; i++) {
			int m = i;
			int l = m, r = m + 1;

			int lSum = cookie[l];
			int rSum = cookie[r];

			while (l >= 0 && r < cookie.length) {
				if (lSum == rSum) {
					answer = Math.max(answer, rSum);

					if (--l >= 0) {
						lSum += cookie[l];
					}
					if (++r < cookie.length) {
						rSum += cookie[r];
					}
				}

				else if (lSum < rSum) {
					if (--l >= 0) {
						lSum += cookie[l];
					}
				}

				else {
					if (++r < cookie.length) {
						rSum += cookie[r];
					}
				}
			}
		}

		return answer;
	}
}
