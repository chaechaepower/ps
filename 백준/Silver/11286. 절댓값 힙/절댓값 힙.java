import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class CompInteger implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(Math.abs(o1)==(Math.abs(o2))) {
			return o1-o2;
		}
		else {
			return Math.abs(o1)-Math.abs(o2);
		}
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> list=new PriorityQueue<>(new CompInteger());
		StringBuilder sb=new StringBuilder();
		
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			
			int absMin=Integer.MAX_VALUE;
			
			if(num!=0) {
				//넣기(넣으면서 절댓값이 가장 작은 수 구하기)
				list.add(num);
				absMin=Math.min(absMin, Math.abs(num));
			}
			else {
				//사이즈가 0이면 0출력 
				if(list.size()==0) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(list.poll()).append('\n');
				}
			}
		}
		
		System.out.println(sb);
	}
	
}
