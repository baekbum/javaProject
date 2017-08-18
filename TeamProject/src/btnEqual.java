import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class btnEqual {
   /*현재 누른 버튼과 사용자가 눌러야할 버튼이 일치 하는지 확인하는 메소드*/
   public static void Equal1(){
      CountGame.combo += 1;
        CountGame.countCheck++;
        CountGame.point = CountGame.point+(1*CountGame.pointBonus);
        CountGame.pointBonus+=(CountGame.pointBonus<7?0.1:0.0);
        CountGame.flag=1;
        CountGame.boom=5000;
   }
   
   /*현재 누른 버튼이 마지막 경우일 경우 현재 단계를 종료하고 다음 단계로 넘어가기 위한 메소드*/
   public static void Equal2(){
      CountGame.combo = 0;
      CountGame.count=false;
      CountGame.bonus+=12000;
      CountGame.chanceBtn.setEnabled(false);
        JOptionPane.showMessageDialog(null, CountGame.round + "단계 Clear! 다음단계로!");
        
        CountGame.startBtn.setEnabled(true);
        CountGame.countCheck = 0;
        if( CountGame.round<=2)
           CountGame.size++;
        CountGame.centerP.removeAll();
        CountGame.centerP = new JPanel(new GridLayout(CountGame.size, CountGame.size));
        CountGame.btn = new JButton[CountGame.size * CountGame.size];
   }
}