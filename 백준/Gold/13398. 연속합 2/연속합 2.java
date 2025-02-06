import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Long[] dp; //dp[i]: i를 포함하는 연속된 수의 최대 합 
	static Long[] maxDp; //maxDp[i]: i까지의 연속된 수의 최대 합 
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		dp=new Long[n];
		arr=new int[n];
		maxDp=new Long[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//제거 전 
		dp[0]=(long) arr[0];
		maxDp[0]=dp[0];
		for(int i=1;i<n;i++) {
			dp[i]=Math.max(dp[i-1]+arr[i], arr[i]);
			maxDp[i]=Math.max(dp[i], maxDp[i-1]);
		}
		long max=maxDp[n-1];
		
		//i 제거 후 최댓값(i==n-1과 1은 안구해도 됨.)
		long tempMax=Long.MIN_VALUE; //연속된 수의 합 중 최대 
		long seqSum = 0;//현재까지의 연속된 수의 합 
		for(int i=1;i<n-1;i++) {
			if(arr[i]<0) {
				for(int j=i+1;j<n;j++) {
					if(j==i+1) {
						if(dp[j-2]+arr[j]>arr[j]) {
							seqSum=dp[j-2]+arr[j];
							tempMax=seqSum;
						}else {
							break;
						}
					}else {
						if(seqSum+arr[j]> arr[j]) {
							seqSum=seqSum+arr[j];
							tempMax=Math.max(tempMax, seqSum);
						}else {
							break;
						}
					}
				}
				
				if(tempMax>max) {
					max=tempMax;
				}
			}
		}
		System.out.println(max);
	}

}





