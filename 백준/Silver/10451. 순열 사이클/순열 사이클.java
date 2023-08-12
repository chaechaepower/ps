import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int testN=Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int t=0;t<testN;t++) {
			int N=Integer.parseInt(bf.readLine());
			int[] arr=new int[N+1];
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<N+1;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			boolean[] visited=new boolean[N+1];
			int start;
			int cnt=0;
			
			for(int i=1;i<N+1;i++) {
				if(!visited[i]) {
					start=i;
					visited[start]=true;
					int k=arr[start];
					visited[k]=true;
					while(start!=k) {
						k=arr[k];
						visited[k]=true;
					}
					cnt++;
				}
			}
			
			System.out.println(cnt);
			
		
		}
	}
}