import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphP extends JPanel{

   
   static int xPos=0;
//   int x = 50;
   
   
   @Override
   public void paint(Graphics g) {
      
      g.setColor(new Color(240, 240, 240));
      g.fillRect(0, 0, CountGame.chanceBtn.getWidth(), CountGame.chanceBtn.getHeight());
      
      if(xPos>=20){
         g.setColor(new Color(153, 204, 0));
      } else if(xPos>=10) {
         g.setColor(new Color(255, 204, 051));
      } else {
         g.setColor(new Color(255, 0, 0));
      }
//      g.fillRect(0, 0, xPos*4, 26);
       g.fillRect(0, 0, xPos*((int)(CountGame.chanceBtn.getWidth())/60), 26);
   }


}