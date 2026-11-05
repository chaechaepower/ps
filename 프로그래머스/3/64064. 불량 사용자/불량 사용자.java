import java.util.*;

class Solution {
    String[] banned_id;
    Set<Set<String>> result;
    List<String>[] candidates;
    
    public int solution(String[] user_id, String[] banned_id) {    
        this.banned_id=banned_id;
        
        List<Integer>[] list = new ArrayList[banned_id.length];
        for(int i=0;i<banned_id.length;i++){
            list[i]=new ArrayList<>();
        }
        
        candidates=new ArrayList[banned_id.length];
        for(int i=0;i<banned_id.length;i++){
            candidates[i]=new ArrayList<>();
        }
        
        for(int i=0;i<banned_id.length;i++){
            String bannedId=banned_id[i];
            
            for(int j=0;j<bannedId.length();j++){
                if(bannedId.charAt(j)=='*'){
                    list[i].add(j);
                }
            }
                        
            for(String userId:user_id){
                char[] userIdChar=userId.toCharArray();
                
                for(int covered:list[i]){
                    if(covered>=userId.length()) break;
                    userIdChar[covered]='*';
                }
                                
                if(new String(userIdChar).equals(bannedId)) candidates[i].add(userId);
            }
        }
        
        result=new HashSet<>();
        dfs(0,new HashSet<>());
        return result.size();
    }
    
    private void dfs(int depth, Set<String> set){
        if(depth==banned_id.length){
            result.add(new HashSet<>(set));
            return;
        }
        
        for(int i=0;i<candidates[depth].size();i++){
            String now = candidates[depth].get(i);
            
            if(set.contains(now)) continue;
            
            set.add(now);
            dfs(depth+1,set);
            set.remove(now);
        }
    }
}


/*
각 제재 아이디에 해당할 수 있는 경우의 수의 조합 -> int[]

각 제재 아이디마다 몇번째 문자에 *가 있는지 저장 -> List[]<>
입력 아이디를 동일하게 *로 가린 뒤 똑같은지 확인


*/