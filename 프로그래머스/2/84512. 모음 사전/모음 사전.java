import java.util.*;


class Solution {
    List<String> list=new ArrayList<>();
    
    public int solution(String word) {
        dfs(0,"");
        return list.indexOf(word);
    }
    
    void dfs(int depth, String str){
        if(depth>5){
            return;
        }
        
        list.add(str);
        
        for(int i=0;i<5;i++){
            dfs(depth+1,str+"AEIOU".charAt(i));
        }
    }
}

/*
문자 하나씩 비교
*/