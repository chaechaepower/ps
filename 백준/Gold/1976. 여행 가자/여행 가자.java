import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
    static int[] parent;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        parent=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }

        int m=Integer.parseInt(br.readLine()); 
        
        StringTokenizer st;
        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(br.readLine());

            for(int j=1;j<n+1;j++){

                if (Integer.parseInt(st.nextToken())==0) { //연결x
                    continue;
                }

                //연결o
                if (findParent(i, j)) { //이미 연결되있으면 union함수 안불러도도미.
                    continue;
                }
               
                unionParent(i, j);
            }
        }

        //방문 가능 여부 체크
        st=new StringTokenizer(br.readLine());
        List<Integer> plan=new ArrayList<>();
        for(int i=0;i<m;i++){
            plan.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<m-1;i++){
            int j=i+1;
            
            if (!findParent(plan.get(i), plan.get(j))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

        private static boolean findParent(int a, int b) { //같은 집합에 속하는지 찾기
            if (getParent(a)==getParent(b)) {
                return true;
            }else{
                return false;
            }
        }
    
        private static void unionParent(int a, int b) { //합집합
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