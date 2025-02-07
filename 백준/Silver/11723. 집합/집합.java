import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		
		int set=0;
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x;
			
			switch(st.nextToken()) {
			case "add":
				x=Integer.parseInt(st.nextToken());
				set |= (1<<x);
				break;
				
			case "remove":
				x=Integer.parseInt(st.nextToken());
				set &= ~(1<<x);
				break;
				
			case "check":
				x=Integer.parseInt(st.nextToken());
				sb.append((set & (1<<x)) !=0 ? 1: 0).append('\n');
				break;
				
			case "toggle":
				x=Integer.parseInt(st.nextToken());
				set^=(1<<x);
				break;
				
			case "all":
				set=(1<<21)-1;
				break;
				
			case "empty":
				set=0;
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
