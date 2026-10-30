import java.util.*;

class Solution {

	public int solution(String begin, String target, String[] words) {
        String[] word = Arrays.copyOf(words, words.length+1);
        word[word.length-1]=begin;
        
        // 단어, 단계
        Queue<int[]> queue=new LinkedList<>();
        boolean[] visited=new boolean[word.length];
        queue.offer(new int[]{word.length-1,0});
        visited[word.length-1]=true;
        
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            String nowWord=word[now[0]];
            int nowStep=now[1];
            
            if(target.equals(nowWord)){
                return nowStep;
            }
            
            for(int i=0;i<word.length;i++){
                if(visited[i]) continue;
                
                // 차이가 1인지 확인
                int diff=0;
                
                for(int j=0;j<word[i].length();j++){
                    if(nowWord.charAt(j)!=word[i].charAt(j)){
                        diff++;
                    }
                }
                
                if(diff==1){
                    queue.offer(new int[]{i,nowStep+1});
                    visited[i]=true;
                }
            }
        }
        
        return 0;
    }
}


/*
한단어만 차이나는걸 어떻게 알지..
갈 수 있는 단어 매번 조사후에 가기


*/