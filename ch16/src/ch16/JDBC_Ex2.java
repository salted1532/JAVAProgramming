package ch16;

import java.sql.*;

public class JDBC_Ex2 {

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","root");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from student");
			System.out.println("DB 연결 완료");
			
			while(rs.next()) {
				System.out.print(rs.getString("id"));
				System.out.print("\t" + rs.getString("name"));
				System.out.println("\t" + rs.getString("dept"));
			}
			System.out.println();
			rs = stmt.executeQuery("select name, id, dept from student where name='이기자'");
			
			while(rs.next()) {
				System.out.print(rs.getString("id"));
				System.out.print("\t" + rs.getString("name"));
				System.out.println("\t" + rs.getString("dept"));
			}
			
		} catch (ClassNotFoundException e)  {
			System.out.println("JDBC 드라이버 로드 오류");
			System.out.println(e);
		} catch (SQLException e) {
			System.out.print("DB 연결 오류");
		}finally {
			close(rs, stmt, conn);
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(stmt != null) {
//				try {
//					stmt.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
		} //finally
	}// main()
}
