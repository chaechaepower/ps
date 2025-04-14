import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Question{
	String num;
	int strike;
	int ball;
	
	public Question(String num,
					int strike,
					int ball) {
		this.num=num;
		this.strike=strike;
		this.ball=ball;
	}
}

public class Main {
	
	static int[] seq;
	static boolean[] visited;
	static int possible; //가능성 개수(정답)
	static Question[] questions;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		questions=new Question[n];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			
			String num=st.nextToken();
			int strike=Integer.parseInt(st.nextToken());
			int ball=Integer.parseInt(st.nextToken());
			
			questions[i]=new Question(num,strike,ball);
		}
		
		seq=new int[3]; //9P3의 순열 
		visited=new boolean[10];
		dfs(0);
		System.out.println(possible);
	}
	
	static void dfs(int depth) {
		if(depth==3) {
			checkPossible();
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				visited[i]=true;
				seq[depth]=i;
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
	
	static void checkPossible() {
		
		boolean isPossible=true;
		
		for(Question q:questions) {
			char[] num=q.num.toCharArray();
			
			int strike=0;
			int ball=0;
			
			for(int i=0;i<seq.length;i++) {
				for(int j=0;j<num.length;j++) {
					if(seq[i]==(num[j]-'0') && i==j) {
						strike++;
						break;
					}
					
					if(seq[i]==(num[j]-'0') && i!=j) {
						ball++;
						break;
					}
				}
			}
			
			if(strike!=q.strike || ball!=q.ball) {
				isPossible=false;
				break;
			}
		}
		
		if(isPossible) {
			possible++;
		}
	}
}

/*
 * 모든 9P3에 대해 조사
 * 각 순열, 각 질문에 대해 조사
 * 다 일치하면 가능성 +1
 * 
 * 
 */