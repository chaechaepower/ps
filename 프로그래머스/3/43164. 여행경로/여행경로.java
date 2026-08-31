import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	static int n;
	static Map<String, List<String>> map;
	static List<String> result;

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };

		String[] str = solution(tickets);
		for(String s:str) {
			System.out.println(s);
		}
	}

	public static String[] solution(String[][] tickets) {
		n = tickets.length;

		map = new HashMap<>();

		for (String[] ticket : tickets) {
			String u = ticket[0];
			String v = ticket[1];

			map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
		}

		for (List<String> end : map.values()) {
			Collections.sort(end);
		}

		result = new ArrayList<>();
		result.add("ICN");
		dfs("ICN", 0);

		String[] answer = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}

	private static boolean dfs(String start, int count) {
		if (count == n) {
			return true;
		}

		List<String> ends = map.get(start);
		
		if(ends==null) {
			return false;
		}

		for(int i=0;i<ends.size();i++) {
			String end = ends.remove(i);
			result.add(end);
			
			if(dfs(end, count+1)) {
				return true;
			}
			
			result.remove(result.size()-1);
			ends.add(i, end);
		}
		
		return false;
	}
}

/*
 * 모든 경로를 다 사용 방문한 곳 또 방문 가능 여러 경로 존재 시 알파벳 순으로 방문
 * 
 */
