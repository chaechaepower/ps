import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] grades=new int[n];
		
		int max=Integer.MIN_VALUE;
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			grades[i]=Integer.parseInt(st.nextToken());
			
			if(grades[i]>max) {
				max=grades[i];
			}
		}

		double sum=0;
		for(int i=0;i<n;i++) {
			sum+=(double)grades[i]/max*100;
		}
		
		System.out.println(sum/n);
	}
}


/*
 * 최댓값 구한다
 * 점수 고침과 동시에 sum 구하기
 * 평균 구하기 
 * 
 * */
 