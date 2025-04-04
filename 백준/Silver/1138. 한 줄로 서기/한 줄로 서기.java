import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int n;
	public static int[] seq; //줄 선 위치 
	public static int[] tallerCounts;
	public static boolean[] visited;
	public static int[] compare;
	public static boolean isRightSeq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
	
		tallerCounts=new int[n+1]; //idx는 키, value는 해당 키보다 큰 사람 수(왼쪽)
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			tallerCounts[i]=Integer.parseInt(st.nextToken());
		}
		
		seq=new int[n];
		visited=new boolean[n+1];
		dfs(0);
		
	}
	
	public static void dfs(int depth) {
		if(depth==n) {
			compareTaller();
			if(isRightSeq) {
				for(int e:seq) {
					System.out.print(e+" ");
				}
			}
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]&&!isRightSeq) {
				visited[i]=true;
				seq[depth]=i;
				dfs(depth+1);
				visited[i]=false;
			}
		}
	}
	
	public static void compareTaller() {
		compare=new int[n+1];
		
		for(int i=0;i<seq.length;i++) {
			 for(int j=i-1;j>=0;j--) {
				 if(seq[j]>seq[i]) {
					 compare[seq[i]]++;
				 }
			 }
			 if(compare[seq[i]]!=tallerCounts[seq[i]]) {
				 isRightSeq=false;
				 return;
			 }
		}
		
		isRightSeq=true;
	}

}

