package ch14;

import java.io.*;
import java.net.*;
import java.util.*;

public class CalcServerEx {
	
	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp, " ");//수식을 빈칸을 기준으로 나눔
		if (st.countTokens() != 3) {
			return "error";
		}
		String res="";
		int op1 = Integer.parseInt(st.nextToken());//첫번째 숫자
		String opcode = st.nextToken();//계산 수식
		int op2 = Integer.parseInt(st.nextToken());//두번째 숫자
		switch (opcode) {//수식 case 문
			case "+": res = Integer.toString(op1 + op2);
				break;
			case "-": res = Integer.toString(op1 - op2);
				break;
			case "*": res = Integer.toString(op1 * op2);
				break;
			case "/":
			    try {
			        res = Integer.toString(op1 / op2);
			    } catch (ArithmeticException e) {
			        res = "Error: 0 입력 감지";  // 0으로 나누는 경우 에러 메시지 반환
			    }
			    break;
			case "%": res = Integer.toString(op1 % op2);
				break;
			case "^": res = Integer.toString((int) Math.pow(op1, op2));
				break;
			default : res = "error";
		}
		return res;//계산결과 뱉음
	}
	
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
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
					System.out.println("클라이언트에서 연결을 종료하였음");
					break; // "bye"를 받으면 연결 종료
				}
				System.out.println(inputMessage); // 받은 메시지를 화면에 출력
				String res = calc(inputMessage); // 계산함수 호출. 계산 결과는 res
				out.write(res + "\n"); // 계산 결과 문자열 전송
				out.flush();//계산결과 전부 보내버림
			}
		} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
		} finally {
			try {
				if(socket != null) socket.close(); // 통신용 소켓 닫기
				if(listener != null) listener.close(); // 서버 소켓 닫기
			} catch (IOException ex) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
				ex.printStackTrace();
			}
		} // finally
	} // main()
}
