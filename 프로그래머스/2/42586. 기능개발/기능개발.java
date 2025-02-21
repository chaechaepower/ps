import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days=new int[progresses.length];
        
        //남은 일수를 계산한다. 
        for(int i=0;i<progresses.length;i++){
            int progress=progresses[i];
            int speed=speeds[i];
            int remainder=100-progress; //남은 양 
            
            if(remainder%speed==0){
                days[i]=remainder/speed;
            }else{
                days[i]=remainder/speed+1;
            }
        }

        List<Integer> list=new ArrayList<>();
        int cnt=1;
        int max=days[0];
        
        for(int i=1;i<days.length;i++){
            if(max>=days[i]){
                cnt++;
            }
            
            else{
                list.add(cnt);
                max=days[i];
                cnt=1;
            }  
        }
        list.add(cnt);
        
        int[] answer=new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}

/*
각 작업이 며칠 남았는지 days를 구한다.

*/