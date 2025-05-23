import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= 10; t++) {
			int n=Integer.parseInt(br.readLine());
			List<String> list=new ArrayList<>();
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				list.add(st.nextToken());
			}
			
			int promptCount=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			
			while(promptCount-->0) {
				char ch=st.nextToken().charAt(0);
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				switch(ch) {
				case 'I':
					for(int i=x;i<x+y;i++) {
						list.add(i,st.nextToken());
					}
					
					break;
				case 'D':
					for(int i=0;i<y;i++) {
						list.remove(x);
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
