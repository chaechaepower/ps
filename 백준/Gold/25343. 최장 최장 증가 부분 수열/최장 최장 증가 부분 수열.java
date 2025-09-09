import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer>[][] lis=new ArrayList[n][n];
		
		lis[0][0]=new ArrayList<>();
		lis[0][0].add(map[0][0]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0) continue;
				
				//위쪽
				List<Integer> topList=(i-1)>=0 ? lis[i-1][j] : null;
				//왼쪽
				List<Integer> leftList=(j-1)>=0 ? lis[i][j-1] : null;
				//합치기
				List<Integer> mergeList=merge(topList, leftList);
				//lis 
				addNumToLis(mergeList, map[i][j]);
				lis[i][j]=mergeList;
			}
		}

		System.out.println(lis[n - 1][n - 1].size());
	}

	private static void addNumToLis(List<Integer> mergeList, int num) {
		int idx=mergeList.size()-1;
		
		if(num==mergeList.get(idx)) {
			return;
		}
		
		if(num>mergeList.get(idx)) {
			mergeList.add(num);
		}
		else {
			int lowerBoundIdx=lowerBound(mergeList, num);
			mergeList.set(lowerBoundIdx, num);
		}
	}

	private static int lowerBound(List<Integer> mergeList, int num) {
		int left=0;
		int right=mergeList.size();
		
		while(left<right) {
			int mid=(left+right)/2;
			
			if(mergeList.get(mid)>=num) {
				right=mid;
			}
			
			else {
				left=mid+1;
			}
		}
		
		return right;
	}

	private static List<Integer> merge(List<Integer> topList, List<Integer> leftList) {
		if(topList==null) {
			return new ArrayList<>(leftList);
		}
		
		if(leftList==null) {
			return new ArrayList<>(topList);
		}
		
		List<Integer> mergeList=new ArrayList<>();
		int p1=0, p2=0;
		while(p1<topList.size() && p2<leftList.size()) {
			mergeList.add(Math.min(topList.get(p1++), leftList.get(p2++)));
		}
		
		while(p1<topList.size()) {
			mergeList.add(topList.get(p1++));
		}
		
		while(p2<leftList.size()) {
			mergeList.add(leftList.get(p2++));
		}
		
		return mergeList;
	}
	
	
}
