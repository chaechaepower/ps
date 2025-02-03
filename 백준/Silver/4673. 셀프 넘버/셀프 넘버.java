
public class Main {

	public static void main(String[] args){		
		boolean[] check=new boolean[10001];
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=1;i<10001;i++) {
			
			if(!check[i]) {
				sb.append(i).append('\n');
			}
			
			int result=i;
			
			int quo=i;
			while(quo>0) {
				result+=quo%10;
				quo/=10;
			}
			
			if(result<10001) {
				check[result]=true;
			}
		}
		
		System.out.println(sb);
	}
}


