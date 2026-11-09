import java.util.*;
import java.math.*;
import java.io.*;

class Main{
    static int[] dr={-2,-2,-1,-1,1,1,2,2};
    static int[] dc={1,-1,2,-2,-2,2,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken())+1;
        int m=Integer.parseInt(st.nextToken())+1;

        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken())-1; // 말
        int c=Integer.parseInt(st.nextToken())-1; 
        int s=Integer.parseInt(st.nextToken())-1; // 졸
        int k=Integer.parseInt(st.nextToken())-1;

        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        queue.offer(new int[]{r,c,0});
        visited[r][c]=true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowR=now[0];
            int nowC=now[1];
            int move=now[2];

            if(nowR==s && nowC== k){
                System.out.println(move);
                return;
            }
            
            for(int d=0;d<8;d++){
                int nextR=nowR+dr[d];
                int nextC=nowC+dc[d];

                if(nextR<0 || nextR>=n || nextC<0 || nextC>=m) continue;

                if(visited[nextR][nextC]) continue;

                queue.offer(new int[]{nextR,nextC,move+1});
                visited[nextR][nextC]=true;
            }
        }
    }
}


/*
말: 출발점, 졸: 도착점


*/