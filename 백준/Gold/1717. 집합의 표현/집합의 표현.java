import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    static int[] parent;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int opt=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if (opt==0) {
                unionParent(a,b);
            }else{
                findParent(a,b);
            }
        }

        System.out.println(sb);
    }

    private static void findParent(int a, int b) {
       if (getParent(a)==getParent(b)) {
        sb.append("yes").append('\n');
       }else{
        sb.append("no").append('\n');
       }
    }

    private static void unionParent(int a, int b) {
        a=getParent(a);
        b=getParent(b);
        
        if (a<b) {
            parent[b]=a;
        }else{
            parent[a]=b;
        }
    }

    private static int getParent(int n){
        if (n==parent[n]) {
            return n;
        }
        return parent[n]=getParent(parent[n]);
    }
}