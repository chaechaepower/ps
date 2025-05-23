import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr= {0, 1,-1, 1}; //가로, 세로, 우상향 대각선, 좌하향 대각선
	static int[] dc= {1, 0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			int n=Integer.parseInt(br.readLine());
			String[] arr=new String[n];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=st.nextToken();
			}
			
			int boundary=n/2-1;
			if(n%2!=0) {
				boundary+=1;
			}
			
			System.out.print("#"+t+" ");
			
			int idx1=0;
			int idx2=boundary+1;
			
			StringBuilder sb=new StringBuilder();
			while(idx1<=boundary &&idx2<n) {
				sb.append(arr[idx1]).append(' ');
				sb.append(arr[idx2]).append(' ');
				
				idx1++;
				idx2++;
			}
			
			if(n%2!=0) {
				sb.append(arr[idx1]);
			}
			
			System.out.println(sb);
		}
	}
}

/*
 * 경계 
 * 홀수 
 * 0~n/2, n/2+1~n-1
 * 짝수
 * 0~n/2-1, n/2~n-1
 * 
 * */
