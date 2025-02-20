import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n; 
	static int[][] power;
	static boolean[] team; //true팀과 false팀으로 구분
	static int min=Integer.MAX_VALUE; //정답 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		power=new int[n][n];
		team=new boolean[n];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				power[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		seperateTeam(0,0);
		System.out.println(min);
	}
	
	//팀 나누기 
	static void seperateTeam(int depth, int idx) {
		
		if(depth==n/2) {
			calMin();
			return;
		}
		
		for(int i=idx;i<n;i++) {
			team[i]=true;
			seperateTeam(depth+1, i+1);
			team[i]=false;
		}
	}
	
	static void calMin() {
		int trueSum=0;
		int falseSum=0;
		
		List<Integer> teamT=new ArrayList<>();
		List<Integer> teamF=new ArrayList<>();
		
		//팀 분리 
		for(int i=0;i<n;i++) {
			if(team[i]) {
				teamT.add(i);
			}else {
				teamF.add(i);
			}
		}
		
		trueSum=calPower(teamT);
		falseSum=calPower(teamF);
		int diff=Math.abs(trueSum - falseSum);
		
		min=Math.min(min, diff);
	}
	
	//팀 능력치 계산
	static int calPower(List<Integer> team) {
		int sum=0;
		
		for(int i=0;i<team.size()-1;i++) {
			for(int j=i+1;j<team.size();j++) {
				int t1=team.get(i);
				int t2=team.get(j);
				sum+=power[t1][t2];
				sum+=power[t2][t1];
			}
		}
		
		return sum;
	}
	
}
