import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return (int)(this.weight-o.weight);
		}
	}
	
	static void makeSet() {
		for(int i=0;i<n;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int x) {
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	static double[][] position;;
	static int[] parents;
	static Edge[] edgeList;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		position=new double[n][2];
		edgeList=new Edge[n*(n-1)/2];
		parents=new int[n];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			position[i][0]=Double.parseDouble(st.nextToken());
			position[i][1]=Double.parseDouble(st.nextToken());
		}
		
		makeEdge();
		
		makeSet();
		Arrays.sort(edgeList);
		
		double total=0;
		long count=0;
		
		for(Edge edge:edgeList) {
			if(!union(edge.to,edge.from)) continue;
			
			total+=edge.weight;
			count++;
			
			if(count==n-1) break;
		}
		
		System.out.print(String.format("%.2f", total));
		
	}

	private static void makeEdge() {
		int idx=0;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				double weight=Math.sqrt(Math.pow(position[i][0] - position[j][0], 2) 
				        + Math.pow(position[i][1] - position[j][1], 2));
				edgeList[idx]=new Edge(i,j,weight);
				idx++;
			}
		}
		
	}
}


