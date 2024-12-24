package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC_Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","root");
			
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e)  {
			System.out.println("JDBC 드라이버 로드 오류");
			System.out.println(e);
		} catch (SQLException e) {
			System.out.print("DB 연결 오류");
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		} //try-catch 문 finally
	}// main()

}
