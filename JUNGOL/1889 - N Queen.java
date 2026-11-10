import java.util.*;
import java.math.*;
import java.io.*;

class Main{
    static int n, count;
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row){ 
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(possible(row,col)){
                result[row]=col;
                dfs(row+1);
            }
        }
    }

    private static boolean possible(int r, int c){
        for(int i=0;i<r;i++){
            if(result[i]==c) return false;
            
            if(Math.abs(i-r)== Math.abs(c-result[i])) return false;
        }

        return true;
    }
}

/*

다음 행에서는
배치된 퀸과 col과 대각선이 같으면 안됨.

*/