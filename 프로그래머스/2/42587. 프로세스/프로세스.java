import java.util.*;

class Job{
    int location;
    int priority;
    
    public Job(int location,
                int priority){
        this.location=location;
        this.priority=priority;
    }
    
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Job> queue=new LinkedList<>();
        int[] priorityCounts=new int[10];
        
        for(int i=0;i<priorities.length;i++){
            queue.offer(new Job(i,priorities[i]));
            priorityCounts[priorities[i]]++;
        }
    
        int count=0;
        
        while(!queue.isEmpty()){
            
            int nowPriority=queue.peek().priority;
            
            boolean isExist=false;
            
            for(int i=nowPriority+1;i<10;i++){
                if(priorityCounts[i]>0){
                    isExist=true;
                    break;
                }
            }
            
            //우선순위가 더 높은 프로세스가 존재
            if(isExist){
                Job job=queue.poll();
                queue.offer(job);
            }
            else{ //존재x
                Job job=queue.poll();
                count++;
                priorityCounts[nowPriority]--;
                if(job.location==location){
                    break;
                }
            }
        }
        return count;
    }
}