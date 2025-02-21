import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //정답 배열
        int[] answer=new int[commands.length];
        
        for(int p=0;p<commands.length;p++){
            int i=commands[p][0];
            int j=commands[p][1];
            int k=commands[p][2];
            
            int[] arr=new int[j-i+1];
            for(int q=0;q<arr.length;q++){
                arr[q]=array[(i-1)+q];
            }
            
            Arrays.sort(arr);
            
            answer[p]=arr[k-1];
        }
        
        return answer;
    }
}


/*
commands 길이만큼 반복
원본 배열 유지

1. 
새로운 배열의 길이: j-i+1
i~j까지 자른다
인덱스: i-1 ~ j-1

2. 정렬

3. k번째 수
인덱스: k-1


*/