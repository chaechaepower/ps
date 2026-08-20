import java.util.Arrays;

class Solution {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		int len = phone_book.length;

		for (int i = 1; i < len; i++) {
			String prev = phone_book[i-1];
			String now = phone_book[i];

			if (now.startsWith(prev)) {
				return false;
			}
		}

		return true;
	}
}
