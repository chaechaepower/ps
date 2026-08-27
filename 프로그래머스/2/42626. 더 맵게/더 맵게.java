import java.util.PriorityQueue;

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) {
        	pq.offer(scoville[i]);
        }
        
        int cnt=0;
        
        while(true) {
        	if(pq.peek()>=K) {
        		break;
        	}
        	
        	if(pq.size()==1) {
        		cnt=-1;
        		break;
        	}
        	
        	int s1=pq.poll();
        	int s2=pq.poll();
        	int newS=s1+s2*2;
        	
        	pq.offer(newS);
        	cnt++;        
        }
        
        return cnt;
    }
}