class Solution {
public int[] solution(int[] prices) {
    	int len= prices.length;
        int[] result=new int[len];
        
        for(int i=0;i<len-1;i++) {
        	int now=prices[i];
        	int count=0;
        	
        	for(int j=i+1;j<len;j++) {
        		int post=prices[j];
        		count++;
        		
        		if(now>post) {
        			break;
        		}
        	}
        	
        	result[i]=count;
        }
        
        return result;
    }
}