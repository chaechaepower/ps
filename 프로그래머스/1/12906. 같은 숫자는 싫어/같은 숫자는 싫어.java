import java.util.*;

public class Solution {
    public List<Integer>  solution(int []arr) {
        List<Integer> list=new ArrayList<>();
        
        int preNum=10;
        for(int e:arr){
            if(e!=preNum){
                list.add(e);
                preNum=e;
            }
        }
        
        return list;
    }
}