import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int origN=Integer.parseInt(br.readLine());
			List<Integer> orig=new ArrayList<>();
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<origN;i++) {
				orig.add(Integer.parseInt(st.nextToken()));
			}
			
			int promptN=Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			while(promptN-->0) {
				st.nextToken();
				
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				for(int i=x;i<x+y;i++) { //x=1, y=3 123
					orig.add(i, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.printf("#%d ",t);
			
			for(int i=0;i<10;i++) {
				System.out.print(orig.get(i)+" ");
			}
			System.out.println();
		}
		
	}

	
}
