class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxW=Integer.MIN_VALUE; //가장 큰 너비
        int maxH=Integer.MIN_VALUE; //가장 큰 높이
        
        for(int i=0;i<sizes.length;i++){
            int w=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            
            maxW=Math.max(maxW, w);
            maxH=Math.max(maxH, h);
        }
        
        answer=maxW*maxH;
        return answer;
    }
}


/*

가로를 길게, 세로를 짧게 배치한다고 하자.
이때 가장 큰 가로와 세로를 구하면 됨.

*/