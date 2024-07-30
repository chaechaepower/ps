import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    
    Meeting(int start, int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(Meeting o) {

        if(this.end==o.end){
            return this.start-o.start;
        }else{
            return this.end-o.end;
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Meeting[] arr=new Meeting[n];

        StringTokenizer st;
        
        for(int i=0;i<arr.length;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            arr[i]=new Meeting(start,end);
        }

        Arrays.sort(arr);

        int preEnd=arr[0].end;
        int max=1;
        
        for(int i=1;i<arr.length;i++){
            if (arr[i].start<preEnd) { //다음 시작시간이 이전 종료시간보다 크거나 같지 않으면
                continue;
            }
            preEnd=arr[i].end;
            max++;
        }
        
        System.out.println(max);
    }
}