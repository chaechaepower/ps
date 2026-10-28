import java.util.*;

class Solution {
	public int solution(int[][] routes) {
	    Arrays.sort(routes, (r1,r2)-> r1[1]-r2[1]);
        
        boolean[] visited=new boolean[routes.length];
        
        int idx=0;
        int count=0;
        
        while(idx<routes.length){
            count++;
            int outTime=routes[idx][1];
                
            while(++idx<routes.length && routes[idx][0]<=outTime);
        }
        
        return count;
	}
}

/*
1. 나간지점 기준 오름차순
*/