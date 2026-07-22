class Solution {
    public int solution(int n) {
        int cnt=1; // 자기 자신 포함 
        
        for(int i=1;i<n-1;i++) {
        	int sum=0;
        	
        	for(int j=i;j<=n-1;j++) {
        		sum+=j;
        		
        		if(sum==n) {
        			cnt++;
        			break;
        		}
        		
        		if(sum>n) {
        			break;
        		}
        	}
        }
        
        return cnt;
    }
}