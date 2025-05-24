import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int testN=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testN;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			
			int[] pPos=numToPos(p);
			int[] qPos=numToPos(q);
			
			int[] sumPos= {pPos[0]+qPos[0],pPos[1]+qPos[1]};
			int num=posToNum(sumPos[0],sumPos[1]);
			System.out.printf("#%d %d\n",t,num);
		}
	}
	
	private static int[] numToPos(int num) {
		if(num==1) {
			return new int[] {1,1};
		}
		
		int diff=1;
		int sum=1;
		
		while(true) {
			sum+=diff;
			diff++;
			if(num<sum) {
				diff--;
				sum-=diff;
				break;
			}
		}
		
		int x=1;
		int y=diff;
		
		if(num==sum) {
			return new int[] {x,y};
		}
		
		for(int i=sum;i<num;i++) {
			x++;
			y--;
		}
		return new int[] {x,y}; 
	}
	
	private static int posToNum(int x, int y) {
		int sum=x+y; //1,sum-1부터 시작
		
		int start=1;
		for(int i=1;i<sum-1;i++) {
			start+=i;
		}
		
		if(x==1) {
			return start;
		}
		
		int startX=1;
		int startY=sum-1;
		int num=start;
	
		while(true) {
			startX++;
			startY--;
			num++;
			if(startY==y) {
				break;
			}
		}
		
		return num;
	}
}
