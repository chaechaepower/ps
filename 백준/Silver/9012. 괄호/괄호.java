import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int n = Integer.parseInt(bf.readLine());

		while(n-->0) {
			sb.append(solve(bf.readLine())).append('\n');
		}
		
		System.out.println(sb);
		

		}
	
	
	public static String solve(String s) {
		
		int count=0;
		
		for(int i=0;i<s.length();i++) {
			
			char c=s.charAt(i);
			
			if(c=='(') {
				count++;
			}
			else if(count==0) {
				return "NO";
			}
			else {
				count--;
			}
		}
		
		if(count==0) {
			return "YES";
		}
		else {
			return "NO";
		}

	
	}
	
}