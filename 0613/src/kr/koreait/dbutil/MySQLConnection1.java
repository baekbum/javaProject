package kr.koreait.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection1 {
	public static void main(String[] args) {
		// 데이터베이스 작업에 사용할 각종 변수를 선언한다.
		Connection conn = null;		// 데이터베이스와 연결한다.
		Statement stmt = null;		// 정적 쿼리를 실행한다. 간단한 SQL 명령문을 실행한다.
		PreparedStatement pstmt = null;		// 동적 쿼리를 실행한다. 복잡한 SQL 명령문을 실행한다.
		ResultSet rs = null;		// SELECT SQL 명령을 실행한 결과를 저정한다.
		
		try {
			// 데이터베이스 드라이버 클래스를 로드한다.
			Class.forName("com.mysql.jdbc.Driver");
			// 데이터베이스에 연결한다.
			String url = "jdbc:mysql://localhost:3306/javadbpm";
			String user = "root";
			String password = "0000";
			
			conn = DriverManager.getConnection(url, user, password);
			// 데이터베이스와 정상적으로 연결되었으므로 사용한다.
		} catch (ClassNotFoundException e) {
			System.out.println("드리이버 클래스를 로드할 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 정보가 올바르지 않습니다.");
			e.printStackTrace();
		} finally {
			
			// 데이터베이스 사용이 완료되었으면 데이터베이스 작업에 필요한 변수를 닫는다.
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}		
	}
}
