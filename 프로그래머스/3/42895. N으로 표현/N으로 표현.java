import java.util.HashSet;
import java.util.Set;

class Solution {
	static Set<Integer>[] mem;

	public int solution(int N, int number) {
		mem = new HashSet[9]; // 1~8

		for (int i = 1; i < 9; i++) {
			mem[i] = new HashSet<>();
		}

		// 연속 수 넣기
		for (int i = 1; i < 9; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < i; j++) {
				sb.append(N);
			}

			mem[i].add(Integer.parseInt(sb.toString()));
		}

		for (int i = 1; i <= 8; i++) { // i번 사용해서 만든 숫자 모음

			for (int j = 1; j < i; j++) {

				for(int a:mem[j]) {
					for(int b:mem[i-j]) {
						mem[i].add(a + b);
						mem[i].add(a * b);
						mem[i].add(a - b);

						if(b!=0) {
							mem[i].add(a/b);
						}
					}
				}
			}

			if(mem[i].contains(number)) {
				return i;
			}
		}
		
		return -1;
	}
}
