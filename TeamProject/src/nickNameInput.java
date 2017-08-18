import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class nickNameInput {
   /*메인 클래스에서 윈도우 창이 생성되면 바로 닉네임 입력을 받고 중복 확인을 하며 중복 확인이 되면 시작버튼을 활성화 시키는 메소드*/
   public static String nickCheck(String nickName, JButton startBtn){
      
       if(!nickName.equals("")){
              Connection conn = DBUtil.getMySQLConnection();
            ResultSet rs;
            String sql1 = "select * from game where nickname = ? ";
            try {
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, nickName);
            rs = pstmt1.executeQuery();
            
            if(!rs.next()){
               String sql2 = "insert into game(nickname) values(?)";
               try {
                  PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                  pstmt2.setString(1, nickName);
                  pstmt2.executeUpdate();
                  
                  DBUtil.close(pstmt2);
                  CountGame.checkflag = true;
                  
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            else {
               JOptionPane.showMessageDialog(null, "닉네임 중복!");
               CountGame.nickField.setText("");
               CountGame.nickField.requestFocus();
               nickName = "";
            }
            
            DBUtil.close(conn);
            DBUtil.close(pstmt1);
            DBUtil.close(rs);
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
            
      }
      else{
         System.out.println("닉네임 공백");
      }   
      
      return nickName;
   }

}