import java.util.*;
import java.math.*;
import java.io.*;

class Solution {
    
	public static int solution(int[][] jobs) {        
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
            if(e1[2]!=e2[2]){
                return e1[2]-e2[2];
            }
            
            if(e1[1]!=e2[1]){
                return e1[1]-e2[1];
            }
            
            return e1[0]-e2[0];
            
        }); // 0: 번호, 1: 요청 시각 2: 소요 시간
        
        Arrays.sort(jobs, (j1,j2)->j1[0]-j2[0]);
        
        int time=0;
        int idx=0;
        int completed=0;
        int total=0;
        
        while(completed<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.offer(
                    new int[]{
                        idx,
                        jobs[idx][0],
                        jobs[idx][1],
                    }
                );
                
                idx++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                
                time+=job[2];
                total+=time-job[1];
                completed++;
            }
            else{
                time = jobs[idx][0];
            }
        }
        
        return total / jobs.length;
    }
}
    



