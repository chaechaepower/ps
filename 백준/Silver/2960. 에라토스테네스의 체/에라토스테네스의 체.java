import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int delete=0; //현재 몇 개 지웠는지
		
		boolean[] prime=new boolean[n+1]; //2~n까지의 소수 판별. true: 소수 아님, false: 소수임 
		
		int num=2;
		while(true) {
			
			// 아직 지우지 않은 수 중 가장 작은 수를 찾는다
			for(int i=2;i<=n;i++) {
				if(!prime[i]) {
					num=i;
					break;
				}
			}
						
			int i=1;
			boolean flag=false;
			
			while(num*i<=n) {
				if(!prime[num*i]) {
					prime[num*i]=true;
					delete++;
				}
				
				if(delete==k) {
					num=num*i;
					flag=true;
					break;
				}
				
				i++;
				
			}
			
			if(flag) {
				break;
			}
		}
		
		System.out.println(num);
	}
}

