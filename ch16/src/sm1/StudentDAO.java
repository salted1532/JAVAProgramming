package sm1;

import java.sql.*;
import java.util.Vector;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public StudentDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e)  {
			System.out.println("JDBC 드라이버 로드 오류");
			e.printStackTrace();
		} 
	}
	
	public void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","root");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
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
	
	public Vector<StudentBean> studentList() {
		Vector<StudentBean> list = new Vector<StudentBean>();
		String sql = "select * from student";
		
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setDept(rs.getString("dept"));
				list.add(bean);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public boolean insertStudent(StudentBean bean) {
		boolean success = false;
		
		String sql = "insert into student values(?,?,?)";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDept());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				success = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}
	
	public boolean updateStudent(StudentBean bean) {
		boolean success = false;
		
		String sql = "update student set name =?, dept=? where id = ?";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDept());
			pstmt.setString(3, bean.getId());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				success = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}
	
	public boolean deleteStudent(String id) {
		boolean success = false;
		
		String sql = "delete from student where id = ?";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				success = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}

}
