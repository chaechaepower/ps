class Solution {
    public int[] solution(int num, int total) {
    	int[] answer=new int[num];

    	int remove=(num-1)*num/2;
    	int x=(total-remove)/num;
    	
    	for(int i=0;i<num;i++) {
    		answer[i]=x+i;
    	}
    	
    	return answer;
    }
}
