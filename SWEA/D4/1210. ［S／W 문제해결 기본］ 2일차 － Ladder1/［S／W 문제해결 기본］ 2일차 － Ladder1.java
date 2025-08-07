import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dc={-1,1,0};
    static int[] dr= {0,0,-1};
    static int[][] map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++){
            br.readLine();

            map=new int[100][100];
           
            StringTokenizer st;
            
            int desR=99;
            int desC=-1;
            
            for(int i=0;i<100;i++){
                st=new StringTokenizer(br.readLine());
                
                for(int j=0;j<100;j++){
                	map[i][j]=Integer.parseInt(st.nextToken());

                    if(map[i][j]==2){
                    	desR=i;
                    	desC=j;
                    }
                }
            }

            System.out.println("#"+t+" "+move(desR,desC));

        }
    }
    
    public static int move(int r, int c) {
    	
    	while(true) {
    		if(r==0) {
    			return c;
    		}
    		
    		for(int i=0;i<3;i++) {
        		int nr=r+dr[i];
        		int nc=c+dc[i];
        		
        		if(isInRange(nr,nc) && map[nr][nc]==1) {
        			map[nr][nc]=3;
        			r=nr;
        			c=nc;
        		}
        	}
    	}
    }
    
    public static boolean isInRange(int r, int c) {
    	return r>=0 && r<100 && c>=0 && c<100;
    }
    
}
