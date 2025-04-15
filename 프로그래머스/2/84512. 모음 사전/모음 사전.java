import java.util.*;

class StrComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2){
        int o1Len=o1.length();
        int o2Len=o2.length();
        int maxLen=Math.max(o1Len,o2Len);
        
        for(int i=0;i<maxLen;i++){
            if(i<o1Len && i<o2Len && o1.charAt(i)!=o2.charAt(i)){
                break;
            }
            
            if(i>=o1Len){
                return -1;
            }
            
            if(i>=o2Len){
                return 1;
            }
        }
        return o1.compareTo(o2);
    }
}

class Solution {
    List<String> list=new ArrayList<>();
    char[] seq;
    char[] alphabet={'A','E','I','O','U'};
    boolean[] visited;
    
    public int solution(String word) {
        visited=new boolean[alphabet.length];
        
        //문자열 만들기
        for(int depth=1;depth<=5;depth++){
            seq=new char[depth];
            dfs(0,depth);
        }
        
        Collections.sort(list,new StrComparator());
        
        for(String s:list){
            System.out.println(s);
        }
        
        int order=1;
        for(int i=0;i<list.size();i++){
            if(word.equals(list.get(i))){
                order+=i;
                break;
            }
        }
        return order;
    }
    
    void dfs(int nowDepth, int finalDepth){
        if(nowDepth==finalDepth){
            list.add(String.valueOf(seq)); //문자열 넣기 
            return;
        }
        
        for(int i=0;i<alphabet.length;i++){
            seq[nowDepth]=alphabet[i];
            dfs(nowDepth+1,finalDepth);
        }
    }
}

/*
문자 하나씩 비교
*/