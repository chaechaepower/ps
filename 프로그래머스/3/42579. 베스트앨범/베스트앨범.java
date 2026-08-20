import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    	static class Music{
		public int idx;
		public int plays;
		
		public Music(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}
	}
    
		public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Music>> map=new HashMap<>();
		Map<String, Integer> total=new HashMap<>();
		
		for(int i=0;i<genres.length;i++) {
			Music music=new Music(i, plays[i]);
			map.computeIfAbsent(genres[i], k->new ArrayList<>()).add(music);
			
			total.put(genres[i], total.getOrDefault(genres[i], 0)+plays[i]);
		}
		
		// 1. 총 재생수 기준 장르 내림차순  
		List<String> musics=new ArrayList<>(total.keySet());
		Collections.sort(musics,(s1,s2)-> total.get(s2)-total.get(s1));
		
		// 2. 가장 많이 재생된 장르중 가장 많이 재생된 노래 선택 (같으면 고유 번호 낮을거 선택)
		List<Integer> result=new ArrayList<>();
		
		for(String music:musics) {
			List<Music> list=map.get(music);
			
			if(list.size()==1) {
				result.add(list.get(0).idx);
				continue;
			}
			
			Collections.sort(list,(m1,m2)->{
				if(m1.plays==m2.plays) {
					return m1.idx-m2.idx;
				}
				
				return m2.plays-m1.plays;
			});
			
			result.add(list.get(0).idx);
			result.add(list.get(1).idx);
		}
		
		int[] answer=new int[result.size()];
		for(int i=0;i<result.size();i++) {
			answer[i]=result.get(i);
		}
		
		return answer;
    }
}