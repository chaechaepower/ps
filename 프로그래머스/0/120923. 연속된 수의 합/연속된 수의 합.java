class Solution {
    public int[] solution(int num, int total) {
    	int[] answer=new int[num];

    	for(int i=-100;i<=100;i++) {
    		int sum=0;
    		
    		for(int j=i;j<i+num;j++) {
    			sum+=j;
    		}
    		
    		if(sum==total) {
    			for(int j=0;j<num;j++) {
    				answer[j]=i+j;
    			}
    		}
    	}
    	
    	return answer;
    }
}
