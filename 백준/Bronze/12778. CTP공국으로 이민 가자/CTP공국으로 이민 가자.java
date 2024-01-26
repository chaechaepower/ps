import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t,k;
		
		t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("C")) {
				st = new StringTokenizer(br.readLine());
				while(k-->0) sb.append((st.nextToken().charAt(0)-'A'+1)+" ");
			}else {
				st = new StringTokenizer(br.readLine());
				while(k-->0) sb.append((char)(Integer.parseInt(st.nextToken())+64)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}