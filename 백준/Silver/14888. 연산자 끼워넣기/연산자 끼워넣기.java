import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] seq; //수열 
	static char[] oper; //연산자 
	static char[] tempOper; //연산자 순열 
	static boolean[] visited;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static char[] opList= {'+','-','*','/'};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		seq=new int[n];
		oper=new char[n-1];
		tempOper=new char[n-1];
		visited=new boolean[n-1];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			seq[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] opCnt=new int[4];
		st= new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			opCnt[i]=Integer.parseInt(st.nextToken());
		}
		
		int idx=0;
		for(int i=0;i<4;i++) {
			int cnt=opCnt[i];
			char c=opList[i]; //0이면 +, 1이면 -,..
			
			for(int j=0;j<cnt;j++) {
				oper[idx++]=c;
			}
		}
		
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	//백트래킹으로 연산자 순열 
	static void dfs(int depth) {
		
		if(depth==n-1) {
			bruteForce();
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				tempOper[depth]=oper[i];
				dfs(depth+1);
				visited[i]=false;
			}
		}
		
	}
	
	//연산자 순열에 따른 수열 계산 
	static void bruteForce() {
		int result=seq[0];
		
		for(int i=1;i<n;i++) {
			int n2=seq[i];
			int op=tempOper[i-1];
			
			switch(op) {
			
			case '/':
				if(result<0) {
					int temp=-1*result; //양수로 바꾼 뒤 
					int sh=temp/n2; //몫을 구하고,
					result=-1*sh; //다시 음수로 바꾼다. 
				}else {
					result/=n2;
				}
				break;
				
			case '+':
				result+=n2;
				break;
			
			case '-':
				result-=n2;
				break;
				
			case '*':
				result*=n2;
				break;
			}
		}
		
		//최대, 최소 구하기 
		min=Math.min(min, result);
		max=Math.max(max, result);
	}
}



