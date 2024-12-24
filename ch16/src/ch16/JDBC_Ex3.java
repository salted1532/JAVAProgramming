package ch16;

import java.sql.*;

public class JDBC_Ex3 {

	public static void printData(ResultSet rs) throws SQLException {
		while(rs.next() ) {
			System.out.print(rs.getString("id"));
			System.out.print("\t" + rs.getString("name"));
			System.out.println("\t" + rs.getString("dept"));
		}
		System.out.println();
	}
	
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
			
			//insert 데이터
			int rows = stmt.executeUpdate("insert into student (id, name, dept)" + "values('0893012', '아무개', '컴퓨터공학');");
			System.out.println("insert 되는 행의 개수: " + rows);
			if(rows > 0) {
				System.out.println("insert 성공");
				rs = stmt.executeQuery("select * from student");
				printData(rs);
			}
			else {
				System.out.println("insert 실패");
			}
			
			//undate 데이터
			rows = stmt.executeUpdate("update student set id='0189011' where name='아무개'");
			System.out.println("update 되는 행의 개수: " +rows);
			if(rows > 0) {
				System.out.println("update 성공");
				rs = stmt.executeQuery("select * from student");
				printData(rs);
			}
			else {
				System.out.println("update 실패");
			}
			
			//delete 데이터
			rows = stmt.executeUpdate("delete from student where name='아무개'");
			System.out.println("delete 되는 행의 개수: " +rows);
			if(rows > 0) {
				System.out.println("delete 성공");
				rs = stmt.executeQuery("select * from student");
				printData(rs);
			}
			else {
				System.out.println("delete 실패");
			}
			
		} catch (ClassNotFoundException e)  {
			System.out.println("JDBC 드라이버 로드 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt, conn);
		} //finally
	}//main()
}
