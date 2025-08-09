import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static boolean[] visited;
    static int n; //고객 수 
    static int[] company;//회사 좌표 
    static int[] home;//집 좌표 
    static int[][] consumer; //고객 번호를 인덱스로. 각 좌표 저장
    static int[] seq; //방문 순서 
    static int min;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testN=Integer.parseInt(br.readLine());
        
        for(int t=1;t<=testN;t++) {
        	n=Integer.parseInt(br.readLine());
        	company=new int[2];
        	consumer=new int[n][2];
        	home=new int[2];
        	
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	
        	//회사
        	company[0]=Integer.parseInt(st.nextToken());
        	company[1]=Integer.parseInt(st.nextToken());
        	//집 
        	home[0]=Integer.parseInt(st.nextToken());
        	home[1]=Integer.parseInt(st.nextToken());
        	//고객
        	for(int i=0;i<n;i++) {
        		consumer[i][0]=Integer.parseInt(st.nextToken());
        		consumer[i][1]=Integer.parseInt(st.nextToken());
        	}
        	
        	seq=new int[n];
        	min=Integer.MAX_VALUE;
        	visited=new boolean[n];
        	dfs(0,0,0); //노드, 깊이, 거리 
        	
        	System.out.printf("#%d %d\n",t,min);
        }
    }   
    
    public static void dfs(int v,int depth, int len){
        if(depth==n){
        	//집과의 거리 추가 
        	len+=calculateDistance(home[0],home[1],consumer[seq[depth-1]][0],consumer[seq[depth-1]][1]);
        	min=Math.min(len, min);
            return;
        }

        for(int i=0;i<n;i++){
        	if(!visited[i]) {
        		visited[i]=true;
        		seq[depth]=i;
        		
        		int dis=0;
        		
        		//depth가 0인 경우 회사와 거리 계산
        		if(depth==0) {
        			dis=calculateDistance(company[0],company[1],consumer[i][0],consumer[i][1]);
        		}
        		else { //아닌 경우, 이전 depth의 고객과 거리 계산
        			dis=calculateDistance(consumer[seq[depth-1]][0],consumer[seq[depth-1]][1],consumer[i][0],consumer[i][1]);
        		}
        		
        		dfs(i,depth+1,len+dis);
        		visited[i]=false;
        	}
        }
    }
    
    public static int calculateDistance(int x1,int y1,int x2,int y2) {
    	return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}

