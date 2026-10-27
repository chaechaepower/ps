import java.util.*;
import java.math.*;
import java.io.*;

class Solution {
    
	public static int solution(int[][] jobs) {        
        Arrays.sort(jobs, (j1,j2)->{
            return j1[0]-j2[0];
        });
           
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
            if(e1[2]!=e2[2]){
                return e1[2]-e2[2];
            }
            
            if(e1[1]!=e2[1]){
                return e1[1]-e2[1];
            }
            
            return e1[0]-e2[0];
            
            
        }); //0: 인덱스, 1: 요청시각 2: 소요시간
        
        int idx=0;
        int progress=0;
        int completed = 0;
        int total =0; // 반환시간 누적
        
        while(completed<jobs.length){
            // 넣어            
            while(idx<jobs.length && jobs[idx][0]<=progress){
                pq.offer(new int[]{idx,jobs[idx][0],jobs[idx][1]});
                idx++;
            }
            
            // 실행
            if(!pq.isEmpty()){
                int[] now = pq.poll();
                completed++;
                progress+=now[2];
                total+=progress-now[1];
            }else{
                 progress=jobs[idx][0];
            }

        
        
        }
        return total/jobs.length;
    }
}
    



/*
선점형 우선순위

1. jobs를 요청 시간 순으로 정렬
2. 큐에 넣는다.
3. 큐에서 꺼내서 진행시간 업데이트, 반환시간 total에 누적
4. 


*/