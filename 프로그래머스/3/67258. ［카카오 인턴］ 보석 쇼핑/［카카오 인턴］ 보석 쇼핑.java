import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		String[] str = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] result = solution(str);

		for (int e : result) {
			System.out.println(e);
		}
	}

	public static int[] solution(String[] gems) {
		Set<String> orig = new HashSet<>();
		for (String gem : gems) {
			orig.add(gem);
		}

		Map<String, Integer> map = new HashMap<>();

		int left = 0, right = -1;
		int aLeft = -1, aRight = -1, len = Integer.MAX_VALUE;

		while (right < gems.length) {
			int size = map.keySet().size();

			if (size == orig.size()) {

				if (right - left + 1 < len) {
					aLeft = left;
					aRight = right;
					len = right - left + 1;
				}

				// left에 해당하는 보석 제거, left++
				String gem=gems[left];
				
				map.put(gem, map.get(gem) - 1);
				
				if(map.get(gem)==0) {
					map.remove(gem);
				}
				
				left++;
			}

			else if (size < orig.size()) {				
				if (++right < gems.length) {
					map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
				}
			}
		}

		return new int[] { aLeft+1, aRight+1 };
	}
}

/*
 * 1번 진열대부터 시작
 * 
 * 종류를 다 센다 투 포인터로 종류만큼 있는지 확인
 * 
 */
