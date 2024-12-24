package ch14;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); 
		try {
			listener = new ServerSocket(9999); // 서버 소켓 생성
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String inputMessage = in.readLine();
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 bye로 연결을 종료하였음");
					break;
				}
				System.out.println("클라이언트: " + inputMessage);
				System.out.print("서버/보내기>>"); // 프롬프트
				String outputMessage = scanner.nextLine();
				out.write(outputMessage + "\n");
				out.flush();
			} //while
		} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
		} finally {
			try {
				scanner.close(); // scanner 닫기
				if(socket != null) socket.close(); // 통신용 소켓 닫기
				if(listener != null) listener.close(); // 서버 소켓 닫기
			} catch (IOException ex) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
				ex.printStackTrace();
			}
		} //finally
	} //main
}
