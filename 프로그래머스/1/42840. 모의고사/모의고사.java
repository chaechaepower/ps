import java.util.*;
import java.io.*;

class Solution {
    
    static int[] n1={1,2,3,4,5};
    static int[] n2={2, 1, 2, 3, 2, 4, 2, 5};
    static int[] n3={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static int[] sum={0,0,0};
    
    public int[] solution(int[] answers) {
    
        for(int i=0;i<answers.length;i++){
            int ans=answers[i];
          
            if(ans==n1[i%n1.length]){
                sum[0]++;
            }
            if(ans==n2[i%n2.length]){
                sum[1]++;
            }
            if(ans==n3[i%n3.length]){
                sum[2]++;
            }
        }
        
        //최댓값을 구한다.
        int maxSum=sum[0];
        for(int i=1;i<3;i++){
            if(sum[i]>maxSum){
                maxSum=sum[i];
            }
        }
        //최댓값과 같은 점수가 있으면 list에 그 번호를 넣는다.
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(maxSum==sum[i]){
                list.add(i+1);
            }
        }
        
        //배열에 넣는다.
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}