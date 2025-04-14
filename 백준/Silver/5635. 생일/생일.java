import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
	String name;
	int date;
	int month;
	int year;
	
	public Student(String name, int date, int month, int year) {
		this.name = name;
		this.date = date;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Student o) {
		if(this.year==o.year) {
			if(this.month==o.month) {
				return this.date-o.date;
			}
			return this.month-o.month;
		}
		return this.year-o.year;
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		Student[] students=new Student[n];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			
			String name=st.nextToken();
			int date=Integer.parseInt(st.nextToken());
			int month=Integer.parseInt(st.nextToken());
			int year=Integer.parseInt(st.nextToken());
			
			students[i]=new Student(name,date,month,year);
		}
		
		Arrays.sort(students);
		
		System.out.println(students[n-1].name);
		System.out.println(students[0].name);
	}
}

/*
 * 모든 9P3에 대해 조사
 * 각 순열, 각 질문에 대해 조사
 * 다 일치하면 가능성 +1
 * 
 * 
 */