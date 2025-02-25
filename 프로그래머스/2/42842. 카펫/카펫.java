class Solution {
    public int[] solution(int brown, int yellow) {
        int ansW=0;
        int ansH=0;
        
        for(int w=3;w<=brown;w++){
            for(int h=3;h<=w;h++){
                int sum=brown/2+2;
                int mul=brown+yellow;
                
                if(w+h==sum && w*h==mul){
                    ansW=w;
                    ansH=h;
                    break;
                }
            }
        }
        
        
        int[] answer={ansW, ansH};
        return answer;
    }
}