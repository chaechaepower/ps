import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidNickname=new HashMap<>(); //유저 아이디 - 닉네임 매핑
        List<String[]> history = new ArrayList<>(); //유저 아이디 - 출입 기록
        
        for(String rec:record){
            String[] sentence = rec.split(" ");
            String prompt = sentence[0];
            String uid = sentence[1];
            
            switch(prompt){
                case "Enter":
                    String nickname = sentence[2];
                    uidNickname.put(uid,nickname);
                    history.add(new String[]{uid,"Enter"});
                    break;
                case "Leave":
                    history.add(new String[]{uid,"Leave"});
                    break;
                case "Change":
                    nickname = sentence[2];
                    uidNickname.put(uid,nickname);
                    break;
            }
        }
        
        List<String> answer= new ArrayList<>();
        
        for(String[] his:history){
            String uid = his[0];
            String nickname = uidNickname.get(uid);
            String prompt = his[1];
            
            switch(prompt){
                case "Enter":
                    answer.add(nickname+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(nickname+"님이 나갔습니다.");
                    break;
            }
        }
        
        return answer.toArray(new String[0]);
    }
}


/*

Enter, Leave에 대해서만 순서대로 기록
uid에 대응되는 최종nickname을 대체

*/