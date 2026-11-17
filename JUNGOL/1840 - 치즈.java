import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];

        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<w;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> melting;
        Queue<int[]> que;
        boolean[][] visited;
        int result=0, time=0;
        
        while(true){
            melting=new ArrayList<>();
            que=new LinkedList<>();
            visited=new boolean[h][w];
            que.offer(new int[]{0,0});
            visited[0][0]=true;

            while(!que.isEmpty()){
                int[] now = que.poll();
                int nowR=now[0];
                int nowC=now[1];

                for(int d=0;d<4;d++){
                    int nextR=nowR+dr[d];
                    int nextC=nowC+dc[d];

                    if(nextR<0 || nextR>=h || nextC<0 || nextC>= w) continue;
                    
                    if(visited[nextR][nextC]) continue;
                    
                    if(board[nextR][nextC]==1){
                        melting.add(new int[]{nextR,nextC});
                    }else{
                        que.offer(new int[]{nextR,nextC});
                    }

                    visited[nextR][nextC]=true;
                }
            }

            if(melting.size()==0){
                break;
            }else{ // 치즈 없애기 
                result = melting.size();
                
                for(int[] now:melting){
                    board[now[0]][now[1]]=0;
                }
            }

            time++;
        }

        System.out.println(time);
        System.out.println(result);
    }
}






/*


바깥쪽에서 외부 공기 탐색
탐색 중 치즈 만나면 녹을 치즈로 판별
*/