import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HashMapDic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("bady", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		
		String kor = dic.get("bady");
		System.out.println(kor);
		
		String kor1 = dic.get("love");
		System.out.println(kor1);

		String kor2 = dic.get("apple");
		System.out.println(kor2);
		
		System.out.println(dic.size());
		System.out.println(dic);
		
		Set<String>keys = dic.keySet();
		
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {//내 방법 
			String n = it.next();
			System.out.print(n + " / ");
			System.out.println(dic.get(n));
		}
		
		while(it.hasNext()) {//교수님 방법
			String key = it.next();
			String Value = dic.get(key);
			System.out.print(key + " : " + Value);
		}
	}

}
