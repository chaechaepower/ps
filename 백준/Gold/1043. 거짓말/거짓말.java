import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;



public class Main {
    static int[] parent;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); //사람 수
        int m=Integer.parseInt(st.nextToken()); //파티 수
        
        parent=new int[n+1]; //union find 초기 세팅
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        
        HashSet<Integer>[] party=new HashSet[m]; //파티 정보 저장할 hashset
        for(int i=0;i<m;i++){
            party[i]=new HashSet<>();
        }
        
        st=new StringTokenizer(br.readLine());
        int truth=Integer.parseInt(st.nextToken()); //진실을 아는 사람 수
        if (truth==0) {
            System.out.println(m); //진실을 아는 사람이 한 명도 없으면 모든 파티에서 거짓말 칠 수 있음.
            return;
        }

        //진실 아는 사람 T, 모르는 사람 F
        boolean[] isknown=new boolean[n+1];
        for(int i=0;i<truth;i++){
            isknown[Integer.parseInt(st.nextToken())]=true;
        }
        
        //파티 정보 저장, 연관 관계 저장
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());

            int total=Integer.parseInt(st.nextToken()); //파티 총 인원

            if (total<=1) {
                party[i].add(Integer.parseInt(st.nextToken()));
                continue;
            }
            
            int a=Integer.parseInt(st.nextToken());
            party[i].add(a);
            for(int j=0;j<total-1;j++){
                int b=Integer.parseInt(st.nextToken());
                party[i].add(b);
                unionParent(a, b);
            }
        }
        
        //진실 아는 사람 연결
        boolean[] visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            
            if (!visited[i]&& isknown[i]) {
                int par=getParent(i);

                for(int j=0;j<=n;j++){
                    if (getParent(j)==par) {
                        visited[j]=true;
                        isknown[j]=true;    
                    }
                }
            }
        }
        
        int cnt=0;

        for(int i=0;i<m;i++){
            boolean flag=false;
            for(int e:party[i]){
                if (isknown[e]) {
                    flag=true;
                    continue;
                }
            }
            if (!flag) {
                cnt++;
            }
        }


        System.out.println(cnt);


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