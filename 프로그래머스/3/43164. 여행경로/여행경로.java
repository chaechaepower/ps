import java.util.*;
import java.math.*;
import java.io.*;

class Solution {
    String[][] tickets;
    Map<String, List<String>> map;
    List<String> answer;
    
	public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        
        for(String[] ticket: tickets){
            String a = ticket[0];
            String b = ticket[1];
            
            map.computeIfAbsent(a,k->new ArrayList<>()).add(b);
        }
        
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        
        this.tickets=tickets;
        answer=new ArrayList<>();
        dfs("ICN");
        
        return answer.toArray(new String[0]);
    }
    
    private boolean dfs(String now){
        answer.add(now);
        
        if(answer.size()==tickets.length+1){
            return true;
        }
    
        List<String> list = map.get(now);
        
        if(list==null || list.isEmpty()){
            answer.remove(answer.size() - 1);
            return false;
        }
                
        for(int i=0;i<list.size();i++){
            String b = list.remove(i);
            
            if(dfs(b)){
                return true;
            }
            
            list.add(i,b);
        }
        
        answer.remove(answer.size() - 1);
        return false;
    }
}



/*

1. a공항에 연결된 b공항 정보 저장
2. "ICN" 공항부터 dfs
3. depth가 주어진 항공권 정보와 같다면 끝




*/