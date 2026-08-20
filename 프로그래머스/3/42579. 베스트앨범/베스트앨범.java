import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
	public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Integer>> map=new HashMap<>(); // <장르, 고유번호>
		Map<String, Integer> total = new HashMap<>();
		
        for(int i=0;i<genres.length;i++) {
        	map.computeIfAbsent(genres[i], k->new ArrayList<>()).add(i);
        	total.put(genres[i], total.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<String> list= new ArrayList<>(total.keySet());
        Collections.sort(list, (l1,l2)-> total.get(l2)-total.get(l1)); // 장르 재생수 내림차순 
        
        List<Integer> result=new ArrayList<>();
        
        for(String genre:list) {
        	List<Integer> indexs=map.get(genre);
        	
        	Collections.sort(indexs,(i1,i2)->{
        		if(plays[i1]==plays[i2]) { // 재생수 같으면 고유번호 낮은 순 
        			return i1-i2;
        		}
        		return plays[i2]-plays[i1]; // 재생수 순
        	});
        	
        	if(indexs.size()==1) {
        		result.add(indexs.get(0));
        		continue;
        	}
        	
        	result.add(indexs.get(0));
        	result.add(indexs.get(1));
        }
        
        int[] answer=new int[result.size()];
        
        for(int i=0;i<result.size();i++) {
        	answer[i]=result.get(i);
        }
        
        return answer;
    }
}