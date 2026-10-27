import java.util.*;

class Solution {
	public int solution(int[] A, int[] B) {
	    Arrays.sort(A);
        Arrays.sort(B);
        
        int score=0;
        
        for(int i=A.length-1, j=B.length-1;i>=0;i--){
            if(B[j]>A[i]){
                score++;
                j--;
            }
        }
        
        return score;
    }
}

/*
B팀이 최대한 많이 승리할 수 있게


*/