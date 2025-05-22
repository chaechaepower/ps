import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Num implements Comparable<Num>{
	int num;
	String planetNum;
	
	public Num(int num, String planetNum) {
		this.num=num;
		this.planetNum=planetNum;
	}

	@Override
	public int compareTo(Num o) {
		return this.num-o.num;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testN; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			int len=Integer.parseInt(st.nextToken());
			
			Num[] nums=new Num[len];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<len;i++) {
				String planetNum=st.nextToken();
				nums[i]=new Num(getNum(planetNum),planetNum);
			}
			
			Arrays.sort(nums);
			System.out.printf("#%d\n",t);
			for(Num num:nums) {
				System.out.print(num.planetNum+" ");
			}
		}
	}

	private static int getNum(String planetNum) {
		switch(planetNum) {
		case "ZRO":
			return 0;
		case "ONE":
			return 1;
		case "TWO":
			return 2;
		case "THR":
			return 3;
		case "FOR":
			return 4;
		case "FIV":
			return 5;
		case "SIX":
			return 6;
		case "SVN":
			return 7;
		case "EGT":
			return 8;
		case "NIN":
			return 9;
		default:
			return -1;
		}
	}
}
