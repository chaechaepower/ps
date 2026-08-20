
class Solution {
    boolean solution(String s) {
        int state=0;
        
        for(char ch:s.toCharArray()) {
        	if(ch=='(') {
        		state++;
        	}
        	
        	else {
        		state--;
        		if(state<0) {
        			return false;
        		}
        	}
        }
        
        return state==0 ? true : false;
    }
}