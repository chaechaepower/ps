import java.util.*;
import java.math.*;
import java.io.*;
    
class Main{
	static int n;
    static int[] closet;
    static int[] seq;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        closet=new int[2];
        closet[0] = Integer.parseInt(st.nextToken());
        closet[1] = Integer.parseInt(st.nextToken());

        int seqCnt=Integer.parseInt(br.readLine());
        seq= new int[seqCnt];

        for(int i=0;i<seqCnt;i++){
            seq[i]=Integer.parseInt(br.readLine());
        }

        min = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(min);
    }

    private static void dfs(int depth, int move){
        if(depth==seq.length){
            min = Math.min(move,min);
            return;
        }

        for(int i=0;i<2;i++){
            int now = seq[depth];
            int temp = closet[i];
            int dis = Math.abs(now-temp);

            closet[i] = now;
            dfs(depth+1, move + dis);
            closet[i] = temp;
        }
    }
}


/*
1. 현재 사용가능한 문 확인
2. 이동횟수 += 현재 위치 - 문 위치
3. 현재 위치에 문 갱신
*/