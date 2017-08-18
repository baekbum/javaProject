import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class threadFunc {
   static SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
   
   /*스레드 내부에서 돌아가는 메소드 */
   public static void threadF(){
         
       if(CountGame.flag==2){
          if(CountGame.cho>0){
                 CountGame.rTime.setForeground(Color.magenta);
                 CountGame.cho--;
               }
              
              if(CountGame.cho==0){
                 CountGame.flag=1;
              }
              
       }
       else if(CountGame.flag==3){
               
          if(CountGame.cho>0){
                  CountGame.rTime.setForeground(Color.blue);
                  CountGame.cho--;
               }
               
               if(CountGame.cho==0){
                  CountGame.flag=1;
               }
         }
       else{
            CountGame.rTime.setForeground(Color.BLACK);
               
         }
       
       CountGame.boom--;
      
       if(CountGame.round>3)
          CountGame.shit--;
          
       if(CountGame.boom==4000){
             for(int j=0;j<CountGame.btn.length;j++)
                CountGame.btn[j].setForeground(Color.BLACK);
         }
          
       if(CountGame.boom==0){
             int k;
             for(k=0;k<CountGame.btn.length;k++){
                if(CountGame.btn[k].getText().equals(String.valueOf(CountGame.countCheck+1))){
                   CountGame.btn[k].setForeground(Color.red);
                    break;
                }
             }
             
             CountGame.boom=5000;
         }
       
       if(CountGame.round==4){
    	   if(CountGame.shit<=4000){
    		   for(int k=0;k<CountGame.btn.length;k++){
    	             if(Integer.parseInt((CountGame.btn[k].getText()))%2==0){
//    	                CountGame.btn[k].setBackground(Color.black);
    	                CountGame.btn[k].setForeground(CountGame.btn[k].getBackground());
    	             }
    	          }
    	        
    	   }
    	   else if(CountGame.shit>4000){
    	          for(int k=0;k<CountGame.btn.length;k++){
    	              if(Integer.parseInt((CountGame.btn[k].getText()))%2==0)
    	                 CountGame.btn[k].setForeground(Color.black);
    	           }
    	        }
    	   if(CountGame.shit==0)
    		   CountGame.shit=8000;
       }
          
       
      
       
       if(CountGame.round==5){
          if(CountGame.shit%1000<=500){
             for(int k=0;k<CountGame.btn.length;k++){
                if(Integer.parseInt((CountGame.btn[k].getText()))%2==0)
	                CountGame.btn[k].setForeground(CountGame.btn[k].getBackground());
                else
                   CountGame.btn[k].setForeground(Color.black);
             }
          }else{
             for(int k=0;k<CountGame.btn.length;k++){
                if(Integer.parseInt((CountGame.btn[k].getText()))%2==0)
                   CountGame.btn[k].setForeground(Color.BLACK);
                else
	                CountGame.btn[k].setForeground(CountGame.btn[k].getBackground());

             }
          }
          if(CountGame.shit==0)
             CountGame.shit=8000;
       }
       
       if(CountGame.round==6){
           if(CountGame.shit/1000<=5){
              for(int k=0;k<CountGame.btn.length;k++){
                     CountGame.btn[k].setBackground(new Color(btnFunc.r, btnFunc.g, btnFunc.b));
              }
           }else{
              for(int k=0;k<CountGame.btn.length;k++){
                 CountGame.btn[k].setBackground(Color.black);
              }
           }
           if(CountGame.shit==0)
              CountGame.shit=8000;
        }
       
       if(CountGame.round==7){
           if(CountGame.shit%2000<=1000){
              for(int k=0;k<CountGame.btn.length;k+=2){
	                CountGame.btn[k].setForeground(CountGame.btn[k].getBackground());
              }
              for(int k=1;k<CountGame.btn.length;k+=2){
                  CountGame.btn[k].setForeground(Color.black);
              }
           }else{
              for(int k=1;k<CountGame.btn.length;k+=2){
	                CountGame.btn[k].setForeground(CountGame.btn[k].getBackground());
              }
              for(int k=0;k<CountGame.btn.length;k+=2){
                  CountGame.btn[k].setForeground(Color.black);
              }
             
           }
           if(CountGame.shit==0)
              CountGame.shit=8000;
        }
       if(CountGame.round==8){
    	 if(CountGame.shit/1000==2){
    		 for(int i=0;i<CountGame.btn.length;i++){
    			 CountGame.btn[i].setForeground(Color.black);
    		 }
    	 }
    	 else {
    		 for(int i=0;i<CountGame.btn.length;i++){
    			 CountGame.btn[i].setForeground(CountGame.btn[i].getBackground());
    		 }
    	 }
       }
      
       
       
       CountGame.time = CountGame.end-- - CountGame.start - 32340000/2+CountGame.bonus;
       CountGame.rTime.setText(sdf.format(CountGame.time));
       
       if(CountGame.time >= 50000 - 32400000/2) {
         CountGame.black = true;
         }
         
       if(CountGame.time <= 10000 - 32400000/2) {
         CountGame.rTime.setForeground(Color.RED);
         }
       
   }
   
   /* 게임이 종료 되었을 경우 사용자의 점수를 화면에 표시해주고 데이터베이스에 저장해주는 메소드*/
   public static void threadexit(){
      CountGame.rTime.setText(sdf.format(0));
       CountGame.chanceBtn.setEnabled(false);
        JOptionPane.showMessageDialog(null, String.format("시간 초과 \n 당신의 점수는 %.2f 입니다", CountGame.point));
          
        try {
           Connection conn = DBUtil.getMySQLConnection();
           String sql3 = "UPDATE game SET score = ? WHERE nickname = ?";
           PreparedStatement pstmt3 = conn.prepareStatement(sql3);
           pstmt3.setDouble(1, CountGame.point);
           pstmt3.setString(2, CountGame.nickName);
           pstmt3.executeUpdate();
           DBUtil.close(pstmt3);                 
        } catch (SQLException e) {
             e.printStackTrace();
        }
          
        for(int i=0; i<CountGame.size*CountGame.size; i++) {
           CountGame.btn[i].setEnabled(false);
        }
      
   }
}