import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int dumpN=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] height=new int[100];
			
			for(int i=0;i<100;i++) {
				height[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(height);
			
			
			while(dumpN-->0) {
				height[99]--;
				height[0]++;
				Arrays.sort(height);
			}
		
			
			System.out.println("#"+t+" "+(height[99]-height[0]));
		}
	}

	
}
