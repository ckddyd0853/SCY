package week2_0829;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;

	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/bookdb";
			String id="root";
			String pwd="1234";
			conn=DriverManager.getConnection(url,id,pwd);
		}catch(Exception e) {
			System.out.println("출력중 예외발생");
		}
		return conn;
	}
	
	public void inserUser(User u) {
		String sql = "insert into user values(?,?,?,?,?)";
		
		
		try {
			conn= getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,u.getUserid() );
			pstmt.setString(2,u.getPwd() );
			pstmt.setString(3,u.getName() );
			pstmt.setString(4,u.getTel());
			pstmt.setString(5,u.getGrade());
			
			int i=pstmt.executeUpdate();
			System.out.println(i+"개의 레코드가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}
	
	public ArrayList<User> getUserList() {
		ArrayList<User> userList=new ArrayList<User>();
		
		
		
		close();
		return userList;
	}
	
	public void printUserList() {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/bookdb";
			String id="root";
			String pwd="1234";
			conn=DriverManager.getConnection(url,id,pwd);
			
			String sql="select * from user";
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch(Exception e) {
			System.out.println("출력중 예외발생");
		}
		close();
	}
}
