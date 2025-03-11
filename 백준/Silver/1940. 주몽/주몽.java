import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int sum=arr[i]+arr[j];
				
				if(sum==m) {
					cnt++;
					break;
				}
				else if(sum>m) {
					break;
				}
			}
		}
		
		
		System.out.println(cnt);
	}
}


 