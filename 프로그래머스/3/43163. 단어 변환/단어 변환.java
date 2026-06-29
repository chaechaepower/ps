import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Node {
		String word;
		int length;

		public Node(String word, int length) {
			this.word = word;
			this.length = length;
		}
	}

	boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		int n = words.length;
		visited = new boolean[n];

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			// target과 같은지 확인
			if (cur.word.equals(target)) {
				return cur.length;
			}

			for (int i = 0; i < n; i++) {
				if (!visited[i] && isNext(cur.word, words[i])) { // 방문 x, 다음에 갈 수 있는 단어인지
					queue.offer(new Node(words[i], cur.length + 1));
					visited[i] = true;
				}
			}
		}
		
		return 0;
	}

	private boolean isNext(String cur, String next) {
		int diff = 0;

		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != next.charAt(i)) {
				diff++;
			}
		}

		return diff == 1 ? true : false;
	}

}
