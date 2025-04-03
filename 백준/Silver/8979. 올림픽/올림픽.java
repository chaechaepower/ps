import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Country {
	int id;
	int gold;
	int sliver;
	int bronze;

	public Country(int id, int gold, int sliver, int bronze) {
		this.id=id;
		this.gold = gold;
		this.sliver = sliver;
		this.bronze = bronze;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		Country[] countries=new Country[n];
		
		for(int i=0;i<countries.length;i++) {
			st=new StringTokenizer(br.readLine());
			
			int id=Integer.parseInt(st.nextToken());
			int gold=Integer.parseInt(st.nextToken());
			int sliver=Integer.parseInt(st.nextToken());
			int bronze=Integer.parseInt(st.nextToken());
				
			countries[i]=new Country(id, gold, sliver, bronze);
			
		}
		
		Arrays.sort(countries,(c1,c2)->{
			if(c1.gold==c2.gold && c1.sliver == c2.sliver) {
				return c2.bronze-c1.bronze;
			}
			if(c1.gold==c2.gold) {
				return c2.sliver-c1.sliver;
			}
			
			return c2.gold-c1.gold;
		});
		
		int findIdx=-1;
		for(int i=0;i<n;i++) {
			if(countries[i].id==k) {
				findIdx=i;
				break;
			}
		}
		
		Country findCountry=countries[findIdx];
		
		int preIdx=findIdx-1;
		
		for(int i=findIdx-1;i>=0;i--) {
			if(findCountry.gold!=countries[i].gold) {
				preIdx=i;
				break;
			}
			if(findCountry.sliver!=countries[i].sliver) {
				preIdx=i;
				break;
			}
			if(findCountry.bronze!=countries[i].bronze) {
				preIdx=i;
				break;
			}
		}
		
		System.out.println(preIdx+2);
	}

}

