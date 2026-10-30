import java.util.*;

class Solution {
    int min;

	public int solution(String begin, String target, String[] words) {
        // words안에 target이 없으면 0 return
        String[] word = Arrays.copyOf(words, words.length + 1);
        word[words.length] = begin;
        
        min=Integer.MAX_VALUE;
        dfs(word.length-1,new boolean[word.length],word,0,target);
        return min==Integer.MAX_VALUE ? 0:min;
        
    }
    
    public void dfs(int now, boolean[] visited, String[] words, int depth, String target){
        if(target.equals(words[now])){
            min=Math.min(min,depth);
            return;
        }
        
        visited[now]=true;
        
        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;
            
            // 한단어 차이나면
            int diff=0;
            for(int j=0;j<words[i].length();j++){
                if(words[now].charAt(j) != words[i].charAt(j)){
                    diff++;
                }
            }
            
            if(diff==1){
                dfs(i,visited,words,depth+1,target);
            }
        }
    }

}


/*
한단어만 차이나는걸 어떻게 알지..
갈 수 있는 단어 매번 조사후에 가기


*/