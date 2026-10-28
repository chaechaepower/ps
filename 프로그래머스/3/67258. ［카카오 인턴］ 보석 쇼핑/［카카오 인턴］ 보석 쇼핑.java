import java.util.*;

class Solution {

	public static int[] solution(String[] gems) {
	    Set<String> set = new HashSet<>();
        for(String gem:gems){
            set.add(gem);
        }
        
        int size = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int lo=0, hi=-1;
        int total=0, len=Integer.MAX_VALUE;
        
        int[] answer = new int[2];
        
        while(hi<gems.length){
            if(total<size && ++hi<gems.length){
                String gem = gems[hi];
                
                if(!map.containsKey(gem)){
                    total++;
                }
                
                map.put(gem,map.getOrDefault(gem,0)+1);
            }
            
            else if(total == size){
                int nowLen = hi-lo+1;
                
                if(nowLen<len){
                    len=nowLen;
                    answer[0]=lo+1;
                    answer[1]=hi+1;
                }
                
                String gem = gems[lo++];
                
                if(map.get(gem)==1){
                    map.remove(gem);
                    total--;
                }else{
                    map.put(gem,map.get(gem)-1);
                }
            }
        }
        
        return answer;
        
	}
}

/*
1. 보석 종류 저장
2. 투포인터
    덜 포함 -> hi 늘림
    다 포함 -> lo 늘림

*/