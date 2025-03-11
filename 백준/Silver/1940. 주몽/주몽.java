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
		int i=0;
		int j=n-1;
		
		while(i<j) {
			int sum=arr[i]+arr[j];
			
			if(sum<m) {
				i++;
			}
			else if(sum>m) {
				j--;
			}
			else {
				i++;
				j--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
