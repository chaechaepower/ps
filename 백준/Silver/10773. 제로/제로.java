import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int cnt=Integer.parseInt(br.readLine());
		int[] stack=new int[cnt];
		int top=-1;
		
		while(cnt-->0) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				top--;
			}else {
				stack[++top]=n;
			}
		}
		
		int result=0;
		for(int i=0;i<=top;i++) {
			result+=stack[i];
		}
		
		System.out.println(result);
	}
}


