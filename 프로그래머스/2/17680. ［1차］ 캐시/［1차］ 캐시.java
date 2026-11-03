import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();
        
        int total=0;
        
        if(cacheSize==0){
            return cities.length * 5;
        }
        
        for (int i = 0; i < cities.length; i++) {
            // miss
            String city = cities[i].toLowerCase();
            
            if(!cache.containsKey(city)){
                total += 5;
                
                if(cache.size()==cacheSize){
                    // 교체
                    List<String> keySet = new ArrayList<>(cache.keySet());
                    
                    Collections.sort(keySet,(k1,k2)->{
                        return cache.get(k1) - cache.get(k2);
                    });
                    
                    cache.remove(keySet.get(0));
                }
            }
                
            // hit
            else{
                total += 1;
            }
            
            cache.put(city,i);

        }
        
        return total;
    }
}


/*

*/