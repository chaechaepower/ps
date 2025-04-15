import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque= new ArrayDeque<>();
        
        for(int e:arr){
            if(deque.isEmpty()){
                deque.offerFirst(e);
                continue;
            }
            
            if(deque.peekFirst()==e){
                continue;
            }
            
            deque.offerFirst(e);
        }
        
        int[] answer=new int[deque.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=deque.pollLast();
        }
        
        return answer;
    }
}