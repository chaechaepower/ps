import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
	static int m,n,k;
    static boolean[][] rectangle;
    static boolean[][] visited;
    static int count, temp;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        rectangle = new boolean[m][n];
        for(int i=0;i<k;i++){
            st= new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int r=m-y2;r<=m-y1-1;r++){
                for(int c=x1;c<=x2-1;c++){
                    rectangle[r][c]=true;
                }
            }
        }

        visited=new boolean[m][n];
        List<Integer> width=new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && !rectangle[i][j]){
                    temp=0;
                    count++;
                    dfs(i,j);
                    width.add(temp);
                }
            }
        }
        
        Collections.sort(width);
        System.out.println(count);
        for(int e: width){
            System.out.print(e+" ");
        }
    }

    private static void dfs(int r, int c){
        visited[r][c]=true;
        temp++;

        for(int d=0;d<4;d++){
            int nextR=r+dr[d];
            int nextC=c+dc[d];

            if(nextR<0 || nextR>=m || nextC<0 || nextC>=n) continue;

            if(!visited[nextR][nextC] && !rectangle[nextR][nextC]){
                dfs(nextR,nextC);
            }
        }
    }
}

/*

1. 직사각형 영역을 구분 -> rectangle true
2. 나머지 영역을 dfs로 넓이 구함

좌표변환
n행 m열

*/