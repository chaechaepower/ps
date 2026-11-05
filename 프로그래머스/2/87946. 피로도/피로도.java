import java.io.*;
import java.math.*;
import java.util.*;

class Solution {
    int[][] dungeons;
    int maxLen;
    boolean[] visited;

	public int solution(int k, int[][] dungeons) {
	    this.dungeons = dungeons;
        maxLen=Integer.MIN_VALUE;
        visited=new boolean[dungeons.length];
        
        dfs(0,k);
        return maxLen;
	}

    private void dfs(int len, int fatigue){
        maxLen=Math.max(len,maxLen);
            
        // 방문하지 않았고 갈 수 있는 곳
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]) continue;
            
            if(fatigue>=dungeons[i][0]){
                visited[i]=true;
                dfs(len+1,fatigue-dungeons[i][1]);
                visited[i]=false;
            }
        }
    } 
}

/*
 * dfs 순열
 * 
 */
