import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long i = Long.parseLong(st.nextToken());

        long i2 = Long.parseLong(st.nextToken());
        long i3 = Long.parseLong(st.nextToken());



        System.out.println(i+i2+i3);

    }



}
