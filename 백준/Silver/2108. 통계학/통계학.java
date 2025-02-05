import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int[] count=new int[8001]; // -4000~4000 사이 수 저장 x를 x+4000 인덱스에 저장 
		
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int sum=0;
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			sum+=num;
			count[num+4000]++;
			
			if(num<min) {
				min=num;
			}
			if(num>max) {
				max=num;
			}
		}
		
		int max_mode=0; //최대 최빈값 
		int mode=0;
		boolean flag=false; //이미 해당 최빈값이 등장한 적 있는지
		int cnt=0;
		int mid=0;
		
		for(int i=min+4000;i<=max+4000;i++) {
			if(count[i]>0) {
//				if(cnt==n/2+1) {
//					mid=i-4000;
//				}
				
				if(cnt<(n+1)/2) {
					cnt+=count[i];
					mid=i-4000;
				}
				
				if(count[i]>max_mode) {
					max_mode=count[i];
					mode=i-4000;
					flag=true;
				}
				
				else if(count[i]==max_mode && flag) { //현재 최대 최빈값과 같고 2번째로 등장하는 경우 
					mode=i-4000;
					flag=false;  
				}
			}
		}
		
		System.out.println((int)(Math.round((double)sum/n))); //산술평균
		System.out.println(mid);//중앙값 
		System.out.println(mode); //최빈값 
		System.out.println(max-min); //범위 
	}
}

