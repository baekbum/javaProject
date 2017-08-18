import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;

public class btnFunc{
   
   static Random random = new Random();
   
   static int r;
   static int g; 
   static int b; 
   
   public void btnSet(int size){
      
      for(int i=0; i<size*size; i++){
    	  r = random.nextInt(150)+50;
          g = random.nextInt(150)+50;
          b = random.nextInt(150)+50;
           CountGame.btn[i]=new JButton(String.valueOf(i+1));
           CountGame.btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
           CountGame.btn[i].setBackground(new Color(r, g, b));
         }
   }
   
   public void btnMix(){
       for(int i=0 ; i<1000000 ; i++) {
              int r = random.nextInt(CountGame.btn.length-1)+1;
              JButton temp = CountGame.btn[0];
              CountGame.btn[0] = CountGame.btn[r];
              CountGame.btn[r] = temp;         
          } 
   }
   
   public void btnAdd(int size){
        for(int j=0;j<size*size;j++){  
              CountGame.centerP.add(CountGame.btn[j]);
        }
   }
}