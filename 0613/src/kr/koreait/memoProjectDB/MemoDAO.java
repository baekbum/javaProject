package kr.koreait.memoProjectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import kr.koreait.dbutil.DBUtil;

// DAO(Data Access Object) : SQL 명령을 실행하는 클래스
public class MemoDAO {
	
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
	
	public static void insert(){
		System.out.println("저장할 데이터를 입력하세요");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("메모 : ");
		String memo = sc.nextLine();
		
		// 데이터베이스에 접속한다.
		Connection conn = DBUtil.getMySQLConnection();
		
				
		// SQL 명령을 실행할 준비를 한다.
		try {			
			// Statement를 이용해서 SQL 실행하기
			// SQL 명령을 만든다. 문자열은 반드시 작은 따옴표로 묶어줘야 한다.
			// String sql = "insert into memo(name,password,memo) values('" + name + "','" + password + "','" + memo + "')";
			// System.out.println(sql);
			
			//Statement stmt = conn.createStatement();
			
			// SQL 명령을 실행한다.
			// executeQuery() : 테이블에 저장된 내용이 변경되지 않는 SQL 명령을 실행한다. select
			// executeUpdate() : 테이블에 저장된 내용이 변경되는 SQL 명령을 실행한다. insert, delete, update
			// stmt.executeUpdate(sql);
			// PreparedStatement를 이용해서 SQL 실행하기
			// SQL 명령을 만든다. 변경되는 값이 들어갈 자리를 "?"로 표시한다.
			
			// ====================================================================== 
			
			String sql = "insert into memo(name,password,memo) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ?를 채운다.
			// pstmt.setString(parameterIndex, x) : ?를 채운다. 
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, memo);
			// SQL 명령을 실행한다.
			pstmt.executeUpdate();			
			System.out.println("저장완료");
			
			DBUtil.close(conn);
			DBUtil.close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 테이블에 저장된 글 전체를 얻어오는 메소드
	public static void select() {
		Connection conn = DBUtil.getMySQLConnection();
		String sql = "select * from memo order by idx DESC";
		
		try {			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// select SQL 명령의 실행 결과를 ResultSet 객체에 저장시킨다.			
			ResultSet rs = pstmt.executeQuery();
			
			// 테이블에서 얻어와 rs에 저장된 글 목록이 있으면 글을 출력하고 없으면 글이 없다는 메시지를 출력한다.
			// next() : ResultSet 객체에 저장된 데이터를 다음 데이터로 넘겨준다.
			// next()는 다음 데이터가 있으면 true, 없으면 false를 리턴시킨다.
			if(rs.next()){
				// 테이블에서 얻어온 글을 화면에 출력한다.
				do{
					System.out.println(rs.getInt("idx") + ". " + rs.getString("name") + ", " + rs.getString("password") + ", " + rs.getString("memo") + ", " + sdf.format(rs.getTimestamp("writeDate")));
					// 한건을 출력하고 다음 데이터가 있으면 반복하고 없으면 반복을 중지한다.
				} while(rs.next());				
			}
			else{
				System.out.println("저장된 글이 없습니다.");
			}
			
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 테이블에 저장된 글을 수정하는 메소드
	public static void update() {
		Connection conn = DBUtil.getMySQLConnection();
		int num = 0;
		String pw;
		System.out.print("수정할 글 번호를 입력하세요 : ");
		num = sc.nextInt();
		 sc.nextLine();
		System.out.println();
		System.out.print("비밀번호를 입력하세요 : ");
		pw = sc.nextLine();
		System.out.println();
		
		String sql = "select * from memo where idx = ? and password = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("수정하시려는 글이 맞습니까?");
				sql = "select * from memo where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				ResultSet rs1 = pstmt.executeQuery();
				if(rs1.next()){			
					System.out.println(rs.getInt("idx") + ". " + rs.getString("name") + ", " + rs.getString("password") + ", " + rs.getString("memo") + ", " + sdf.format(rs.getTimestamp("writeDate")));									
				}
				else{
					System.out.println("일치하는 글이 없습니다.");
				}
				
				System.out.println("1)수정, 2)취소");
				int no = sc.nextInt();
				sc.nextLine();
				if(no == 1){
					String memo;
					System.out.print("수정할 메모를 입력하세요 : ");
					memo = sc.nextLine();
					sql = "update memo set memo = ? where idx = ? and password = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, memo);
					pstmt.setInt(2, num);
					pstmt.setString(3, pw);
					pstmt.executeUpdate();
					System.out.println("글이 수정 되었습니다.");					
				}
				else{
					System.out.println("글 수정이 취소되었습니다");
				}				
			}
			else{
				System.out.println(num + "번 글을 수정할 수 없습니다.");
			}

			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 테이블에 저장된 글을 삭제하는 메소드
	public static void delete() {
		Connection conn = DBUtil.getMySQLConnection();
		System.out.print("삭제할 글 번호를 입력하세요 : ");
		int num = sc.nextInt();
		 sc.nextLine();
		System.out.println();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
		System.out.println();
		
		
		String sql = "select * from memo where idx = ? and password = ?";		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("삭제하시려는 글이 맞습니까?");
				sql = "select * from memo where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				ResultSet rs1 = pstmt.executeQuery();
				if(rs1.next()){										
					System.out.println(rs.getInt("idx") + ". " + rs.getString("name") + ", " + rs.getString("password") + ", " + rs.getString("memo") + ", " + sdf.format(rs.getTimestamp("writeDate")));									
				}
				else{
					System.out.println("일치하는 글이 없습니다.");
				}
				System.out.println("1)삭제, 2)취소");
				int no = sc.nextInt();
				if(no == 1){
					sql = "delete from memo where idx = ? and password = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.setString(2, pw);
					pstmt.executeUpdate();
					System.out.println("글이 삭제 되었습니다.");					
				}
				else{
					System.out.println("취소 되었습니다");
				}			
			}
			else{
				System.out.println(num + "번 글이 없습니다.");
			}	
			
			DBUtil.close(conn);
			DBUtil.close(pstmt);
			DBUtil.close(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


		
}
