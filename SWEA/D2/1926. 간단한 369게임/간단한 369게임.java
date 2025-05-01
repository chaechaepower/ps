import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {			
			String val=String.valueOf(i);
			
			int count=0;
			
			for(char ch:val.toCharArray()) {
				if(ch=='3' || ch=='6' || ch=='9') {
					count++;
				}
			}
			
			if(count>0) {
				for(int j=0;j<count;j++) {
					System.out.print('-');
				}
				System.out.print(' ');
			}
			else {
				System.out.print(val+" ");
			}
		}
	}

}
