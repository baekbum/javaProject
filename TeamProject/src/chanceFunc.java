public class chanceFunc {
   public static void chance(){
      if(CountGame.chance>0&&Double.parseDouble((CountGame.rTime.getText()))<49){
         CountGame.bonus+=10000;
         CountGame.chance--;
         CountGame.chanceNum.setText(String.valueOf(CountGame.chance));
          
         CountGame.flag = 3;
         CountGame.cho=700;
           if(CountGame.chance==0)
              CountGame.chanceBtn.setEnabled(false);           
       }      
   }   
}