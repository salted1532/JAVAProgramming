package ch16;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Ex4 {

	public static void printData(ResultSet rs) throws SQLException {
        // rs가 비어 있으면 아무것도 출력하지 않음
        boolean hasData = false;
        while (rs.next()) {
            hasData = true;
            System.out.print(rs.getString("id"));
            System.out.print("\t" + rs.getString("name"));
            System.out.println("\t" + rs.getString("dept"));
        }
        if (!hasData) {
            System.out.println("검색결과를 찾을 수 없습니다.");
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","root");
			
			System.out.println("<학생 리스트>");
			pstmt = conn.prepareStatement("select * from student");
			rs = pstmt.executeQuery();
			printData(rs);
			
            while (true) {  // 무한 루프를 이용하여 검색 결과가 나올 때까지 반복
                System.out.print("검색할 학생 이름: ");
                String name = sc.next();

                // ResultSet 타입을 TYPE_SCROLL_INSENSITIVE로 설정
                pstmt = conn.prepareStatement("select * from student where name = ?", 
                                               ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                               ResultSet.CONCUR_READ_ONLY);
                pstmt.setString(1, name);
                rs = pstmt.executeQuery();

                if (!rs.next()) {
                    System.out.println("검색결과를 찾을 수 없습니다.");
                } else {
                    // 검색결과가 있으면, 결과를 출력하고 종료
                    rs.beforeFirst();  // 커서를 첫 번째 레코드로 이동
                    printData(rs);
                    break;  // 결과를 찾으면 반복문을 종료
                }
            }
			
		} catch (ClassNotFoundException e)  {
			System.out.println("JDBC 드라이버 로드 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			sc.close();
		} //finally
	}//main()
}
