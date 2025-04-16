import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int e:priorities){
            pq.offer(e);
        }
        
        int answer=0;
        boolean isFind=false;
        
        while(!isFind && !pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(pq.peek()==priorities[i]){
                    pq.poll();
                    answer++;
                    
                    if(i==location){
                        isFind=true;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}


/*
1. pq에 담는다.
2. priorities 순서대로 읽으면서 현재 pq top에 있는거랑 같은지 확인
3. 같으면 poll하고 ans++, 
*/