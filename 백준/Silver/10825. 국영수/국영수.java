import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int n = Integer.parseInt(bf.readLine());
		
		String[] name=new String[n]; //
		int[][] arr=new int[n][4]; //[0]에는 들어온 순서 [1]국 [2]영 [3]수
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(bf.readLine());
			name[i]=st.nextToken();
			arr[i][0]=i; //저장되는 i는 배열 name의 인덱스랑 매칭되게(map의 key값 같은 느낌)
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
			arr[i][3]=Integer.parseInt(st.nextToken());		
		}
		
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1]>o2[1]) return -1;
			if(o1[1]<o2[1]) return 1;
			if(o1[2]>o2[2]) return 1;
			if(o1[2]<o2[2]) return -1;
			if(o1[3]>o2[3]) return -1;
			if(o1[3]<o2[3]) return 1;
			return name[o1[0]].compareTo(name[o2[0]]);
		});

		for(int i=0;i<n;i++) {
			sb.append(name[arr[i][0]]).append('\n');
		}
		
		System.out.println(sb);
		
		
	}
	
}