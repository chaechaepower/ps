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
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<bookTime.length;i++){
            int start=bookTime[i][0];
            int end=bookTime[i][1]+10;
            
            if(pq.isEmpty()) {
                pq.offer(end);
                continue;
            }
            
            if(pq.peek() > start){
                pq.offer(end);
            }else{
                pq.poll();
                pq.offer(end);
            }
        }
        
        return pq.size();
    }
}

/*

1. 시작시간 순으로 정렬

pq에 종료시각+10분 저장
가장 빨리 쓸 수 있는 룸 > 입력 시작 시간 : 새로운 룸 생성
                   <=           : 해당 룸 poll, 입력 종료시간+10분 저장


*/