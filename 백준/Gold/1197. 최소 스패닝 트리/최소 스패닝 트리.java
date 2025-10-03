import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.weight-o.weight;
		}
	}
	
	static void makeSet() {
		for(int i=1;i<=v;i++) {
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
	
	static int[] parents;
	static Edge[] edgeList;
	static int v,e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		v=Integer.parseInt(st.nextToken()); // 정점 개수 
		e=Integer.parseInt(st.nextToken()); // 간선 개수 
		
		edgeList=new Edge[e];
		parents=new int[v+1];
		
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());  
			int b=Integer.parseInt(st.nextToken()); 
			int c=Integer.parseInt(st.nextToken()); 
			
			edgeList[i]=new Edge(a,b,c);
		}
		
		makeSet();
		Arrays.sort(edgeList);
		
		int total=0;
		long count=0;
		
		for(Edge edge:edgeList) {
			if(!union(edge.to,edge.from)) continue;
			
			total+=edge.weight;
			count++;
			
			if(count==v-1) break;
		}
		
		System.out.print(total);
		
	}
}


