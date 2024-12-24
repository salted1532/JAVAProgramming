import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.StringTokenizer;

public class myclass<T, F> {

	T val;
	F val2;
	
	void set(T val, F val2) {
		this.val = val;
		this.val2 = val2;
	}
	
	T getval() {
		return val;
	}
	
	F getval2() {
		return val2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*myclass<Integer, Float> my = new myclass<Integer, Float>();
		myclass<String, Integer> my2 = new myclass<String, Integer>();
		
		
		my.set(100, 3.14f);
		System.out.print(my.getval() + "/");
		System.out.println(my.getval2());
		
		my2.set("자바", 2);
		System.out.print(my2.getval() + "/");
		System.out.println(my2.getval2());*/
		
		Scanner scanner = new Scanner(System.in);
		//Vector<Integer> vec = new Vector<Integer>();
		ArrayList<Integer> vec = new ArrayList<Integer>();
		

		String str = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		while(st.hasMoreTokens()) {
			vec.add(Integer.valueOf(st.nextToken()));
		}
		
		int a = 0;
		double b = 0;
		int c = 0;
		
		//예외처리를 한 나의 방법
		for(int i = 0; i < vec.size(); i++) {
			if(i < 9) {//vec.size 초과시 오류 예외처리(안전장치)
				a  = Integer.valueOf(vec.get(i+1) - vec.get(i)); 
			}
			if(a > b) {
				b = a;
				c = i;
			}
			
		}
		
		//교수님 방법
		for(int i = 0; i < vec.size() - 1; i++) {
			
			a  = Integer.valueOf(vec.get(i+1) - vec.get(i));
			
			if(a > b) {
				b = a;
				c = i;
			}
			
		}
		System.out.println("가장 키가 많이 자란 년도는 200" + c +"년 "+ b + "cm");
		scanner.close();
		
		
		
	}

}
