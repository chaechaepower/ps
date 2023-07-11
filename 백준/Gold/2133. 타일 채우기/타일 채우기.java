import java.io.*;
 
public class Main {
 
    private static int N;
    private static int[] cache;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
 
        cache = new int[N + 1];
        if (N % 2 == 0) {
            cache[0] = 1;
            cache[2] = 3;
            for (int i = 4; i <= N; i += 2) {
                cache[i] = cache[i - 2] * cache[2];
 
                for (int j = i - 4; j >= 0; j -= 2) {
                    cache[i] += (cache[j] * 2);
                }
            }
        }
 
        System.out.println(N % 2 == 0 ? cache[N] : 0);
    }
}