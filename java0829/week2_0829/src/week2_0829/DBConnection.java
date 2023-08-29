package week2_0829;

import java.sql.*;

public class DBConnection {
	
	public static void main(String[] args) {
		DBConnection dbconn= new DBConnection();
		dbconn.getConnection();
		
		//dbconn.close();
	}
	

	private Connection getConnection() {
		Connection conn=null;
		
		 //1.드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//2.Connection객체 만들기
			String url="jdbc:mysql://localhost:3306/bookdb";
			String id="root";
			String pwd="1234";
			
			conn=DriverManager.getConnection(url, id, pwd);
			System.out.println("연결성공");
			
//			String sql = "insert into user values(?,?,?,?,?)";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "aaa");
//			pstmt.setString(2, "1111");
//			pstmt.setString(3, "소지섭");
//			pstmt.setString(4, "010-222-3333");
//			pstmt.setString(5, "silver");
//			
//			int i=pstmt.executeUpdate();
//			System.out.println(i+"개의 레코드가 삽입되었습니다.");
//			
			String sql2 = "select * from user";
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql2);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"/"+rs.getString(2)
									+"/"+rs.getString(3)+"/"
									+rs.getString(4)+"/"+rs.getString(5));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결 실패");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}

	
