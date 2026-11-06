class Solution {
    int[] dr={-1,0,1,0}; //상좌하우
    int[] dc={0,-1,0,1};
    
    public int solution(String dirs) {
        boolean[][][] map=new boolean[11][11][4];        
        int nowR=5, nowC=5; 
        int dis=0;
        
        for(char dir:dirs.toCharArray()){
            int d=convert(dir);
            int nextR=nowR+dr[d];
            int nextC=nowC+dc[d];
            
            if(nextR<0 || nextC<0 || nextR>=11 || nextC>=11){
                continue;
            }
        
            if(!map[nowR][nowC][d]) {
                dis++;
                map[nowR][nowC][d]=true;
                map[nextR][nextC][(d+2)%4]=true;
            }
            
            nowR=nextR;
            nowC=nextC;

        }
        
        return dis;
    }
    
    private int convert(char dir){
        
        switch(dir){
            case 'U':
                return 0;
            case 'D':
                return 2;
            case 'R':
                return 3;
            case 'L':
               return 1;
        }
        
        return -1;
    }
}