import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
	static int n, temp, count;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][];
        for(int i=0;i<n;i++){
            map[i]=br.readLine().toCharArray();
        }

        visited=new boolean[n][n];
        List<Integer> danji = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]=='1' && !visited[i][j]){
                    temp=0;
                    dfs(i,j);
                    danji.add(temp);
                    count++;
                }
            }
        }

        Collections.sort(danji);
        System.out.println(count);
        for(int e:danji){
            System.out.println(e);
        }
    }

    private static void dfs(int r, int c){
        visited[r][c]=true;
        temp++;

        for(int d=0;d<4;d++){
            int nextR=r+dr[d];
            int nextC=c+dc[d];

            if(nextR<0 || nextR>=n || nextC<0 || nextC>=n) continue;

            if(!visited[nextR][nextC] && map[nextR][nextC] == '1'){
                dfs(nextR,nextC);
            } 
        }
    }
}

/*
1이고 visited false인 집을 대상으로 dfs
dfs과정에서 집 개수 카운팅
끝날 때 list에 추가

*/