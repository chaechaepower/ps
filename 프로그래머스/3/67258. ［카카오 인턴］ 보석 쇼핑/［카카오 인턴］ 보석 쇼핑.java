import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] gems) {
		// gem 종류 개수 
    	Set<String> set=new HashSet<>();
    	
    	for(String gem:gems) {
    		set.add(gem);
    	}
    	
    	int totalKind=set.size();
    	
    	// 윈도우에 포함된 보석 개수 
    	Map<String, Integer> map=new HashMap<>();
    	
    	int left=0, answerLeft=0, answerRight=0;
    	int minLen=Integer.MAX_VALUE;
    	
    	for(int right=0; right<gems.length;right++) {
    		// 보석 추가 
    		map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
    		
    		while(map.size()==totalKind) { // 현재 윈도우가 모든 종류를 포함 
    			// 현재 구간이 짧으면 답 갱신 
    			if(right-left<minLen) {
    				minLen = right - left;
        		    answerLeft = left;
        		    answerRight = right;
    			}
    			
    			// left 보석 개수 1 감소 
    			map.put(gems[left], map.get(gems[left])-1);
    			
    			// 개수가 0이면 map에서 제거 
    			if(map.get(gems[left])==0) {
    				map.remove(gems[left]);
    			}
    			
    			left++;
    		}
    	}
    	
    	return new int[] {answerLeft + 1, answerRight + 1};
	}
}