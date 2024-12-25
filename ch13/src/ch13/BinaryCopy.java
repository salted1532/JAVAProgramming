package ch13;

import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File( "c:/Temp/img.jpg");
		File dest = new File("c:/Temp/back.jpg");
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			//한 바이트씩 복사방법
			/*while((c = fi.read()) != -1) {
				fo.write((byte)c);//바이트로 형변환
			}*/
			//버퍼 크기를 지정하여 크기에 맞춰 복사시키는 방법
			byte [] buf = new byte [1024*10]; // 10KB 버퍼
			while(true) {
				int n = fi.read(buf); // 버퍼 크기만큼 읽기. n은 실제 읽은 바이트
				fo.write(buf, 0, n); // buf[0]부터 n 바이트 쓰기
				if(n < buf.length)
					break; // 버퍼 크기보다 작게 읽었기 때문에 파일 끝에 도달. 복사 종료
				}
			fi.close();
			fo.close();
			System.out.println( src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}