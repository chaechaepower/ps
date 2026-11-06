import java.util.*;
import java.math.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        // 분으로 환산
        int[][] bookTime=new int[book_time.length][2];
        
        for(int i=0;i<book_time.length;i++){
            String start=book_time[i][0];
            String end=book_time[i][1];
            
            String[] startSplit=start.split(":"); // 시작시간 : 기준 분할
            String[] endSplit=end.split(":"); // 종료시간 : 기준 분할
            
            int startHour=startSplit[0].equals("00") ? 0 : Integer.parseInt(startSplit[0]) * 60;
            int startMin=startSplit[1].equals("00") ? 0 : Integer.parseInt(startSplit[1]);
            bookTime[i][0]=startHour+startMin;
            
            int endHour=endSplit[0].equals("00") ? 0 :Integer.parseInt(endSplit[0]) * 60;
            int endMin=endSplit[1].equals("00") ? 0 :Integer.parseInt(endSplit[1]);
            bookTime[i][1]=endHour+endMin;
        }
        
        // 시작시간 순으로 정렬
        Arrays.sort(bookTime, (b1,b2)->b1[0]-b2[0]);
        
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> room = new ArrayList<>();
        room.add(0);
        list.add(room);
        
        for(int i=1;i<bookTime.length;i++){
            
            boolean isPossible=false;
            
            // 들어갈 수 있는 룸 체크
            for(List<Integer> rooms : list){
                Collections.sort(rooms, (t1,t2)-> bookTime[t2][1]-bookTime[t1][1]); // 룸에서 제일 늦은 종료 시각 기준
            
                int lastIdx=rooms.get(0);
                int last=bookTime[lastIdx][1];
                
                if(last+10<=bookTime[i][0]){
                    rooms.add(i);
                    isPossible=true;
                    break;
                }
            }
            
            if(!isPossible){
                room = new ArrayList<>();
                room.add(i);
                list.add(room);
            }
        }
        
        // for(List<Integer> rooms : list){
        //     for(Integer time: rooms){
        //         System.out.print(time+" ");
        //     }
        //     System.out.println();
        // }
        
        return list.size();
        
    }
}

/*

1. 시작시간 순으로 정렬
2. Map<Integer, List<Integer>>
시간표 - 같은 객실 사용 가능한 시간표

사용 가능
-> 시작 시간이 제일 끝에 시간표 종료 시각보다 +10분 이상

시간 계산
계산할 땐 분으로 환산..

1
2 4
3 5

*/