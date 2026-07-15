import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int num, int total) {
    	List<Integer> seq=new ArrayList<>();
    	
        
    	for(int i=-100;i<=100;i++) {
    		int sum=0;
    		
    		for(int j=i;j<i+num;j++) {
    			sum+=j;
    		}
    		
    		if(sum==total) {
    			for(int j=i;j<i+num;j++) {
    				seq.add(j);
        		}
    		}
    	}
    	
    	int[] answer=new int[num];
    	
    	for(int i=0;i<num;i++) {
    		answer[i]=seq.get(i);
    	}
    	
    	return answer;
    }
}