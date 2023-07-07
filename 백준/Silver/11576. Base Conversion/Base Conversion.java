import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            arr[i] = sc.nextInt();
        }
        int ten = 0;
        for (int i = 1; i <= m; i++) {
            ten += arr[i] * Math.pow(A, m - i);
 
        }
 
        Stack<Integer> stack = new Stack<>();
 
        while (ten != 0) {
            stack.push(ten % B);
 
            ten /= B;
 
        }
 
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                System.out.println(stack.peek());
            } else {
                System.out.print(stack.peek() + " ");
            }
 
            stack.pop();
 
        }
 
    }
 
}
