import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanWork = scores[0][0]; 
        int wanComp = scores[0][1];
        
        Arrays.sort(scores, (s1,s2)->{
           if(s1[0]!=s2[0]){
               return s2[0] - s1[0];
           } 
        
            return s1[1] - s2[1];
        });
        
        List<Integer> sums = new ArrayList<>();
        int maxComp = -1;
                
        for(int i=0;i<scores.length;i++){
            int nowWork = scores[i][0];
            int nowComp = scores[i][1];
           
            if(nowComp < maxComp) {
                if(nowWork == wanWork && nowComp == wanComp){
                    return -1;
                }
                
                continue;
            }
            
            if(nowComp > maxComp){
                maxComp = nowComp;
            }
                
            sums.add(nowWork+nowComp);
        }
        
        Collections.sort(sums, (l1,l2)->l2-l1);
        
        int grade=1;
        int wanSum= wanWork+wanComp;
        
        for(int sum: sums){
            if(sum > wanSum){
                grade++;
            }
        }
        
        return grade;
    }
}



/*

*/