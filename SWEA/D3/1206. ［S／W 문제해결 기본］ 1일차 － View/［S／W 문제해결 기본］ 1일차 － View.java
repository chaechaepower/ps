import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int testI=1;testI<=10;testI++) {
			int n=Integer.parseInt(br.readLine());
			
			int[] buildings=new int[n];
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<n;i++) {
				buildings[i]=Integer.parseInt(st.nextToken());
			}
			
			if(n==4) {
				printer(testI, 0);
			}
			
			int count=0;
			
			for(int i=2;i<n-2;i++) {
				int max=Integer.MIN_VALUE;
				
				for(int j=i-2;j<=i+2;j++) {
					
					if(i==j) {
						continue;
					}
					
					max=Math.max(max, buildings[j]);
				}
				
				if(max>=buildings[i]) {
					continue;
				}
				
				count+=buildings[i]-max;
			}
			
			printer(testI, count);	
		}

		System.out.println(sb);
	}
	
	public static void printer(int testI, int count) {
		sb.append('#').append(testI).append(' ').append(count).append('\n');
	}
}



