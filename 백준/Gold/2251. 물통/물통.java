import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Status{
    int[] vol;
    
    public Status(){
        vol=new int[3];
    }

    public Status(int a, int b, int c){
        vol=new int[3];

        vol[0]=a;
        vol[1]=b;
        vol[2]=c;
    }

    @Override
    public boolean equals(Object object){
        Status status=(Status)object;
        
        if (this.vol[0]==status.vol[0] 
            && this.vol[1]==status.vol[1] 
                && this.vol[2]==status.vol[2]) {
            return true;
        }else{
            return false;
        }
    }
}

public class Main {
    static List<Status> visited=new ArrayList<>(); 
    static List<Integer> answer=new ArrayList<>();
    static int[] oriVol=new int[3];

    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        oriVol[0]=Integer.parseInt(st.nextToken()); //a
        oriVol[1]=Integer.parseInt(st.nextToken()); //b
        oriVol[2]=Integer.parseInt(st.nextToken()); //c
        
        bfs();

        Collections.sort(answer);
        //System.out.println(answer);

        StringBuilder sb=new StringBuilder();
        for(int e:answer){
            sb.append(e).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(){
       
        Queue<Status> queue=new ArrayDeque<>();

        Status status=new Status(0, 0,oriVol[2]);
        queue.offer(status);
        visited.add(status);
        
        answer.add(oriVol[2]);
        
        while (!queue.isEmpty()) {
            status=queue.poll();

            for(int i=0;i<3;i++){ //status의 i to j 로 물 이동
                for(int j=0;j<3;j++){
                    if(i==j) continue;
                    
                    int startVol=status.vol[i];
                    int endVol=status.vol[j];


                    /*
                    //i to j로 물 이동 후
                    if (startVol+endVol<=oriVol[j]) { //startVol이 빌 때까지 부을 수 있음.
                        endVol+=startVol;
                        startVol=0;
                    }else{ //endVol이 다 찰 때까지 부음
                        endVol=oriVol[j];
                        startVol-=oriVol[j]-endVol;
                    }
                         */
                    
                    endVol+=startVol;
                    startVol=0;

                    if (endVol>oriVol[j]) {
                        startVol=endVol-oriVol[j];
                        endVol=oriVol[j];
                    }

                    Status newStatus=new Status();
                    newStatus.vol[i]=startVol;
                    newStatus.vol[j]=endVol;
                    newStatus.vol[3-i-j]=oriVol[2]-startVol-endVol;

                    if (!visited.contains(newStatus)) {//visited에 같은 상태 있는지 확인 후 없으면 큐에 넣기.
                        queue.offer(newStatus);
                        visited.add(newStatus);
                        if (newStatus.vol[0]==0) { //이떄 a가 0이라면 c를 answr에 저장
                            answer.add(newStatus.vol[2]);
                        }
                    }
                }
            }


        } 


    }
}