class Solution {
    public int solution(int[] citations) {
        
        int ans=0;
    
        int max=citations[0];
        
        for(int i=1;i<citations.length;i++){
            max=Math.max(max,citations[i]);
        }
        
        for(int i=0;i<=max;i++){ //h설정 
            int h=i;
            
            int cnt=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=h){
                    cnt++;
                    
                    if(h==cnt){
                        ans=Math.max(ans,h);
                        break;
                    }
                }
            }
        }        
        return ans;
    }
}


/*
0<=h<=10000
h이상인 원소가 h개 이상
이때, h의 최댓값 


*/