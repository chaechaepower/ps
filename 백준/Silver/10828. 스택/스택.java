import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int[] stack=new int[n];
		int top=-1;
		
		while(n-->0) {
			String prompt=br.readLine();
			StringTokenizer st=new StringTokenizer(prompt);
			
			switch(st.nextToken()) {
			case "push":
				int num=Integer.parseInt(st.nextToken());
				stack[++top]=num;
				break;
			
			case "pop":
				if(top==-1) {
					sb.append(-1).append('\n');
				}else {
					int result=stack[top--];
					sb.append(result).append('\n');
				}
				break;
			
			case "size":
				sb.append(top+1).append('\n');
				break;
				
			case "empty":
				if(top==-1) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
				break;
				
			case "top":
				if(top==-1) {
					sb.append(-1).append('\n');
				}else {
					sb.append(stack[top]).append('\n');
				}
				break;
			}
		}
		System.out.print(sb);
	}
}


