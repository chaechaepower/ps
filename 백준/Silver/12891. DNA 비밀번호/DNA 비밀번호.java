import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		char[] dna=br.readLine().toCharArray(); // dna문자열 
		
		st=new StringTokenizer(br.readLine()); 
		int[] cnt=new int[4]; // 부분 문자열 개수 조건 
		
		for(int i=0;i<4;i++) {
			cnt[i]=Integer.parseInt(st.nextToken());
		}
		
		int i=0;
		int j=m-1;
		int result=0;
		
		//최초 범위에 대해 계산 
		for(int k=i;k<=j;k++) {
			int idx=getIdx(dna[k]);
			
			cnt[idx]--;
		}
		
		boolean flag=true;
		for(int e:cnt) {
			if(e>0) {
				flag=false;
			}
		}
		
		if(flag) {
			result++;
		}
		
		i++;
		j++;
		
		while(j<n) {	
			//맨앞 범위는 더하고
			int idx=getIdx(dna[i-1]);
			cnt[idx]++;
			
			//맨뒷 범위는 뺀다  
			idx=getIdx(dna[j]);
			cnt[idx]--;
			
			flag=true;
			for(int e:cnt) {
				if(e>0) {
					flag=false;
				}
			}
			
			if(flag) {
				result++;
			}
			
			i++;
			j++;
		}
		
		System.out.println(result);
	}
	
	static int getIdx(char c) {
		if(c=='A') return 0;
		if(c=='C') return 1;
		if(c=='G') return 2;
		if(c=='T') return 3;
		else return -1;
	}
}

/*
 * 
 * actg -> 0123
 * i-1, j-1에 해당하는 수 다시 카운트 넣기
 * i, j에 해당하는 수 카운트 빼기
 * 
 * */
