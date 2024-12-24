package ch14;

import java.net.*;

public class AddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		try {
			//getLocalHost 사용
			InetAddress address1 = InetAddress.getLocalHost();
			System.out.println("로컬 컴퓨터 이름:" + address1.getHostName());
			System.out.println("로컬 컴퓨터 IP 주소:" + address1.getHostAddress());
			
			//getByName 사용
			InetAddress address2 = InetAddress.getByName("seoil.ac.kr");
			System.out.println("seoil.ac.kr 컴퓨터의 이름과 IP 주소:" + address2);
			
			//getAllByName 사용 InetAddress[] 객체들의 배열을 반환
			InetAddress all[] = InetAddress.getAllByName("daum.net");
			//for 문을 통해 InetAddress[] 출력
			for(int i=0; i < all.length; i++) {
				System.out.println(all[i]);
			}
			//네이버 확인
			InetAddress all2[] = InetAddress.getAllByName("naver.com");
			for(int i=0; i < all2.length; i++) {
				System.out.println(all2[i]);
			}
			//구글 확인
			InetAddress all3[] = InetAddress.getAllByName("google.com");
			for(int i=0; i < all3.length; i++) {
				System.out.println(all3[i]);
			}
		}
		catch (UnknownHostException e) {
			System.out.println("오류가 발생하였습니다. 오류내용: " + e);
		}
	}
}
