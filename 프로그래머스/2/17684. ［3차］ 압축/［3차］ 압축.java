import java.util.*;
import java.math.*;
import java.io.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        
        for(int i=0;i<26;i++){
            String key=String.valueOf((char)('A'+i));
            dictionary.put(key,i+1);
        }
        
        int start=0;
        int maxLen=1;
        int endIdx=26;
        List<Integer> answer = new ArrayList<>();
        
        while(start<msg.length()){
            int end=start+maxLen > msg.length() ? msg.length() : start+maxLen;
            String now = msg.substring(start,end);
            String part="";
                
            for(int len=now.length();len>0;len--){
                part = now.substring(0,len);
                
                if(dictionary.containsKey(part)) break;
            }
            
            int idx = dictionary.get(part);
            answer.add(idx);
            
            start+=part.length();
            
            if(start<msg.length()){
                String key = part+String.valueOf(msg.charAt(start));
                dictionary.put(key,++endIdx);
                maxLen = Math.max(maxLen, key.length());
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

/*

사전에서 가장 긴 단어 길이 저장: len

입력을 len부터 1까지 일치하는거 찾기

해당하는 색인번호 출력
다음글자랑 합쳐서 사전에 등록 




*/