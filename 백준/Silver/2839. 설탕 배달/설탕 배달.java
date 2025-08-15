import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//3x+5y=n
		
		int maxY=n/5;
		for(int y=maxY;y>=0;y--) {
			if((n-5*y)%3==0) {
				int x=(n-5*y)/3;
				System.out.println(x+y);
				return;
			}
		}
		
		System.out.println(-1);
	}
}