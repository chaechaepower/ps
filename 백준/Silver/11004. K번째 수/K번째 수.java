import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void quickSort(int[] arr, int start, int end) {
        int part2=partition(arr,start,end);
        if (start<part2-1) { //왼쪽
            quickSort(arr,start,part2-1);
        }
        if (part2<end) { //오른쪽
            quickSort(arr,part2,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot=arr[(start+end)/2];
        while (start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if (start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, n-1);
        System.out.println(arr[k-1]);
    }
}