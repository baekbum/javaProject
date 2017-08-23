package kr.koreait.memoProjectWin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MemoDAO {

	public static void insert(String name, String password, String memo) {
		
		Boolean flag = true;
		// 이름 , 비밀번호, 메모가 모두 입력되었으면 테이블에 저장한다.
		
		if(name.length() <= 0){
			JOptionPane.showMessageDialog(null, "이름이 입력되지 않았습니다.");
			flag = false;
		}
		
		if(password.length() <= 0){
			JOptionPane.showMessageDialog(null, "비밀번호가 입력되지 않았습니다.");
			flag = false;
		}
		
		if(memo.length() <= 0){
			JOptionPane.showMessageDialog(null, "메모가 입력되지 않았습니다.");
			flag = false;
		}
		
		if(flag){
			Connection conn = DBUtil.getMySQLConnection();
									
			try {
				String sql = "insert into memo(name,password,memo) values(?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				pstmt.setString(3, memo);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "저장되었습니다.");
				
				
				DBUtil.close(conn);
				DBUtil.close(pstmt);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static ResultSet select() {
		Connection conn = DBUtil.getMySQLConnection();
		
		String sql = "select * from memo order by idx desc";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			/*DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);*/			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}

	public static void update(int no, String password, String memo) {
		Connection conn = DBUtil.getMySQLConnection();
		
		String sql = "select * from memo where idx = ? and password = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sql = "update memo set memo = ? where idx = ? and password = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memo);
				pstmt.setInt(2, no);
				pstmt.setString(3, password);
				pstmt.executeUpdate();				
			}
			else{
				JOptionPane.showMessageDialog(null, "데이터가 일치하지 않습니다.");
			}
			
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void delete(int no, String password) {
		Connection conn = DBUtil.getMySQLConnection();
		
		String sql = "select * from memo where idx = ? and password = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sql = "delete from memo where idx = ? and password = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setString(2, password);
				pstmt.executeUpdate();				
			}
			else{
				JOptionPane.showMessageDialog(null, "데이터가 일치하지 않습니다.");
			}
			
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
