import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		int[] coins=new int[n];
		for(int i=0;i<n;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		
		int[] dp=new int[k+1];
		dp[0]=1;
		
		for (int coin : coins) {      // 각 동전에 대해
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }
		
		System.out.println(dp[k]);
	}
}


/*
 * 1,2,5원을 여러 개 사용해서 10원 가치를 만들기.
 * 
 * dp[10]= dp[9]+1 //1원 사용 
 * dp[10]= dp[8]+1 //2원 사용 
 * dp[10]= dp[5]+1 //5원 사용 
 *
 * */
