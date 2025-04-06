import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int targetRow;
	static int targetCol;
	static final int[][] board=new int[5][5];
	static int cnt=0;
	static int pass=0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringTokenizer st;
		
		for(int row=0;row<5;row++) {
			st=new StringTokenizer(br.readLine());
			for(int col=0;col<5;col++) {
				board[row][col]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<5;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int num=Integer.parseInt(st.nextToken());
				cnt++;
				
				findTargetIdx(num);
				
				isBingo();

				if(pass>=3) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}
	
	//num에 해당하는 요소를 찾아서 0으로 저장 
	static void findTargetIdx(int num) {
		
		for(int row=0;row<5;row++) {
			for(int col=0;col<5;col++) {
				if(board[row][col]==num) {
					board[row][col]=0;
					targetRow=row;
					targetCol=col;
					return;
				}
			}
		}
	}
	
	static void isBingo() {
		
		boolean isBingo=true;
		
		//같은 행 확인
		for(int col=0;col<5;col++) {
			if(board[targetRow][col]!=0) {
				isBingo=false;
				break;
			}
		}
		
		if(isBingo) {
			pass++;
		}
		
		isBingo=true;
		
		//같은 열 확인
		for(int row=0;row<5;row++) {
			if(board[row][targetCol]!=0) {
				isBingo=false;
				break;
			}
		}
		
		if(isBingo) {
			pass++;
		}
		
		isBingo=true;
		
		//오른쪽 대각선 확인 
		if(targetRow==targetCol) {
			for(int i=0;i<5;i++) {
				if(board[i][i]!=0) {
					isBingo=false;
					break;
				}
			}
			
			if(isBingo) {
				pass++;
			}
		}
		
		isBingo=true;
		
		//왼쪽 대각선 확인
		if(targetRow+targetCol==4) {
			for(int i=0;i<5;i++) {
				if(board[i][5-i-1]!=0) {
					isBingo=false;
					break;
				}
			}
			
			if(isBingo) {
				pass++;
			}
		}
	}
}

/*
 * 사회자가 5개 이상 부른 이후부터 체
 * 지운 수를 기준으로 열,행,대각선 지워졌는지 확인
 * 
 * */
