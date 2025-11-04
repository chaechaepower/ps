import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> hash = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < str.length; i++){
            if(str[i].endsWith("Cheese")){
                String key = str[i];
                hash.put(key, hash.getOrDefault(key, 0) + 1);
            }
        }
        if(hash.size() >= 4){
            System.out.println("yummy");
        } else{
            System.out.println("sad");
        }
    }
}
