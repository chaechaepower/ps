import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = len - 1 - idx;
        }

        return result;
    }
}