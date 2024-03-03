import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		bf.readLine();

		st = new StringTokenizer(bf.readLine()); 
		StringBuilder sb=new StringBuilder();

		while (st.hasMoreTokens()) { 
			
			int input = Integer.parseInt(st.nextToken());
			
			if(bs(list,input,0,list.length-1)) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean bs(int[] list, int key, int start, int end) {
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(key==list[mid]) return true;
			
			else if(key>list[mid]) return bs(list,key,mid+1,end);
			
			else return bs(list,key,start,mid-1);
		}
		
		return false;
		
	}
	
}