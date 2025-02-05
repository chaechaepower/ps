import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] square=new boolean[100][100];
		
		int area=0;
		
		StringTokenizer st;
		while(n-->0) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(!square[i][j]) {
						square[i][j]=true;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}
}

