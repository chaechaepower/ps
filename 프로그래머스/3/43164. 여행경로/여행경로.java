import java.util.*;

class Solution {
    Map<String, List<String>> map;
    List<String> result;
    String[][] tickets;
    
	public String[] solution(String[][] tickets) {
        this.tickets=tickets;
	    map=new HashMap<>();
        
        for(String[] ticket:tickets){
            String from = ticket[0];
            String to = ticket[1];
            
            map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        
        result=new ArrayList<>();
        dfs("ICN");
        
        return result.toArray(new String[0]);
	}
    
    private boolean dfs(String from){
        result.add(from);
        
        if(result.size()==tickets.length+1){
            return true;
        }
        
        List<String> toList = map.get(from);
        
        if (toList == null) {
            result.remove(result.size() - 1);
            return false;
        }
        
        Collections.sort(toList);
        
        for(int i=0;i<toList.size();i++){
            String to = toList.remove(i);
            
            boolean isDone = dfs(to);
            if(isDone) return true;
                
            toList.add(i,to);
        }
        
        result.remove(result.size() - 1);
        return false;
    }
}



/*


각 공항마다 갈 수 있는 공항 저장(알파벳 순)
ICN부터 dfs
간선을 방문 체크해야함 -> 방문하면 list에서 빼기


*/