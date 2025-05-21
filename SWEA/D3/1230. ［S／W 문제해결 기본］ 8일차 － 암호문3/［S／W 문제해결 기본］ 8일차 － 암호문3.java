import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] board;
	static int n;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1;t<=10;t++) {
			int origN=Integer.parseInt(br.readLine());
			
			List<Integer> list=new ArrayList<>();
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int i=0;i<origN;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int promptN=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			
			while(promptN-->0) {
				char prompt=st.nextToken().charAt(0);
				
				switch(prompt) {
				
				case 'I':
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					for(int i=x;i<x+y;i++) {
						list.add(i,Integer.parseInt(st.nextToken()));
					}
					
					break;
					
				case 'D':
					x=Integer.parseInt(st.nextToken());
					y=Integer.parseInt(st.nextToken());
					
					for(int i=x;i<x+y;i++) {
						list.remove(x);
					}
					
					break;
					
				case 'A':
					y=Integer.parseInt(st.nextToken());
					for(int i=0;i<y;i++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			
			System.out.printf("#%d ",t);
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
	
}
