import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Info{
	int dir;
	int len;
	
	public Info(int dir, int len) {
		this.dir=dir;
		this.len=len;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
	
		List<Info> infoList=new ArrayList<>();
		
		for(int i=0;i<6;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int dir=Integer.parseInt(st.nextToken());
			int len=Integer.parseInt(st.nextToken());
			infoList.add(new Info(dir,len));
		}
		
		int width=Integer.MIN_VALUE;
		int widthIdx = 0;
		int height=Integer.MIN_VALUE;
		int heightIdx=0;

		for(int i=0;i<infoList.size();i++) {
			Info target=infoList.get(i);
			int dir=target.dir; //key(dir)을 얻음.
			
			if(dir==1 || dir==2) {
				width=Math.max(width, target.len);
				if(width==target.len) {
					widthIdx=i;
				}
			}
			if(dir==3 || dir==4) {
				height=Math.max(height, infoList.get(i).len);
				if(height==target.len) {
					heightIdx=i;
				}
			}
		}
//		System.out.println("width: "+width);
//		System.out.println("height: "+height);
		
		int maxIdx=Math.max(widthIdx, heightIdx);
		
		int emptyWidthIdx=(widthIdx+3)%6;
		int emptyWidth=infoList.get(emptyWidthIdx).len;
		int emptyHeightIdx=(heightIdx+3)%6;
		int emptyHeight=infoList.get(emptyHeightIdx).len;
		
//		System.out.println("emptyWidth: "+emptyWidth);
//		System.out.println("emptyHeight: "+emptyHeight);
		
		int area=width*height-emptyWidth*emptyHeight;
		
		System.out.println(area*n);
		
	}
}

