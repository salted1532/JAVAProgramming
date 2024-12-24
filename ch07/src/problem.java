import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem {
	public static void main(String[] args) { 
		
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		
		int a = 0;
		int b = 0;
		String c = "";
		String d = "";
		String country = "";
        int population = 0;
		System.out.println("나 라 이름과 인구를 5개 입력하세요.(예: Korea 5000)");
		for(int i=0; i<5; i++) {
			System.out.print("나라 이름, 인구 >>");
			String str = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(str," ");
			
			if (st.countTokens() == 2) { // 두 개의 토큰이 있는지 확인
                country = st.nextToken(); // 첫 번째 토큰 (나라 이름)
                population = Integer.parseInt(st.nextToken());
                dic.put(country, population);
			}
			
			for(int j = 0; j < dic.size() - 1; j++) {
				
				a  = population;
				c  = country;
				if(a > b) {
					b = a;
					d = c;
				}
			}
           
		}
		
		System.out.println("제일 인구가 많은 나라는 " +"(" + d + "," + b + ")");
		scanner.close();
	}
}
