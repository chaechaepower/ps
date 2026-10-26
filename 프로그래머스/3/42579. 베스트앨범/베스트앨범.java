import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
  	public int[] solution(String[] genres, int[] plays) {
        List<Integer> idxs = new ArrayList<>(); // 각 노래의 고유번호
        
        Map<String, Integer> totalCount=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            
            totalCount.put(genre, totalCount.getOrDefault(genre,0)+play);
            idxs.add(i);
        }
        
        Collections.sort(idxs, (i1,i2)->{
            String i1Genre=genres[i1];
            String i2Genre=genres[i2];
            
            if(totalCount.get(i1Genre) != totalCount.get(i2Genre)){
                return totalCount.get(i2Genre) - totalCount.get(i1Genre);
            }
            
            if(plays[i1] != plays[i2]){
                return plays[i2] - plays[i1] ;
            }
            
            return i1-i2;
        });
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(int i=0;i<idxs.size();i++){
            int idx = idxs.get(i);
            Integer now = count.get(genres[idx]);
            
            if(now != null && now ==2){
                continue;
            }{
                result.add(idx);
                count.put(genres[idx], count.getOrDefault(genres[idx],0)+1);
            }
            
        }
        
        return result.stream()
                .mapToInt(a->a)
                .toArray();
    }
}


/*

정렬 조건
1. 각 장르별 총 재생횟수 높은 순 -> Map k:장르, v:총 재생횟수
2. 1같으면 노래별 재생횟수 높은 순 
3. 2같으면 고유번호 낮은 순


*/