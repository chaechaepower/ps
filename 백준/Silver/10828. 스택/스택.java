import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		
		
		int [] stack=new int[10000];
		int p=-1;
		int size=0;
		
		
		StringTokenizer st;
		String ord;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			ord=st.nextToken();
			
			switch(ord) {
			
			case "push":
				int x=Integer.parseInt(st.nextToken());
				stack[++p]=x;
				size++;
				break;
			
			case "pop":
				if(size==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack[p]);
					stack[p--]=0;
					size--;
				}
				break;
			
			case "size":
				System.out.println(size);
				break;
				
			case "empty":
				if(size==0) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				break;
				
			case "top":
				if(size==0) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack[p]);
				}
				break;

			}	
		}
		
	}

}