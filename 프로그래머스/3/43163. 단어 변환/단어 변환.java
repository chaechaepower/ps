
class Solution {
	boolean[] visited;
	int min=Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		// target을 만들 수 있는지 확인
		boolean contained = false;

		for (String word : words) {
			if (target.equals(word)) {
				contained = true;
			}
		}

		if (!contained) {
			return 0;
		}

		visited = new boolean[words.length];

		dfs(begin, target, words, 0);
		return min;
	}

	public void dfs(String curWord, String target, String[] words, int length) {
		if (curWord.equals(target)) {
			min = Math.min(min, length);
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i]) continue;
			
			String candidate = words[i];

			// now, candidate 비교
			int diff = 0;

			for (int j = 0; j < candidate.length(); j++) {
				if (curWord.charAt(j) != candidate.charAt(j)) {
					diff++;
				}
			}

			if (diff == 1) {
				visited[i] = true;
				dfs(candidate, target, words, length + 1);
				visited[i] = false;
			}
		}
	}
}