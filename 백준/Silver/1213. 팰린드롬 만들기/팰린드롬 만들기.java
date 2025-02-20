import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		int[] alpCnt=new int[26]; //0은 a의 개수,..25는 z의 개수..
		
		for(char c:name.toCharArray()) {
			alpCnt[c-'A']++;
		}
		
		int oddCnt=0;
		
		for(int e:alpCnt) {
			if(e%2!=0) {
				oddCnt++;
			}
		}
		
		if(oddCnt>1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		StringBuilder sb=new StringBuilder();
		int oddI=-1;
		
		//front
		for(int i=0;i<26;i++) {
			int cnt=alpCnt[i];
			
			for(int j=0;j<cnt/2;j++) {
				sb.append((char)(i+'A'));
			}
			
			//홀수인 인덱스 구하기 
			if(cnt%2!=0) {
				oddI=i;
			}
		}
		
		String front=sb.toString();
		String end=sb.reverse().toString();
		
		//mid
		if(oddI>=0) { //홀수가 존재하면 
			front+=(char)(oddI+'A');
		}
		
		System.out.println(front+end);
		
	}
}

/*
 * 1. 문자 개수 저장.
 * 2. 홀수인 문자 개수? 0이거나 하나만 가능. 
 * 3. 아니라면, front+mid+end 
 * 
 * 
 * */
