import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[] usedCol;
    static int n, count;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map=new char[n][];
        usedCol=new boolean[n];
    
        for(int i=0;i<n;i++){
            map[i]=br.readLine().toCharArray();
        }

        count = 0;
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth){
        if(depth==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(map[depth][col]=='#') continue;
            
            if(usedCol[col]) continue;

            usedCol[col]=true;
            dfs(depth+1);
            usedCol[col]=false;
        }
    }
}

/*
어차피 행마다 하나씩만 놓아야하니까 행을 하나씩 탐색하면서
col만 신경쓰면 됨

result[n] => index행, value열에 rock 배치
value만 정해주면 된다 -> 순열...

*/



