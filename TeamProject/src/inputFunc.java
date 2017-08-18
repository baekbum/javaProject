import java.awt.GridLayout;

import javax.swing.JPanel;

public class inputFunc {
	public static void convert(int size){
		 for(int i=0; i<size*size; i++){
	            CountGame.btn[i].setEnabled(false);         
	         }        
	         
		 CountGame.timeP = new JPanel();
		 CountGame.LlowP = new JPanel(new GridLayout(1,3));
		 CountGame.p=new JPanel();
	   	 CountGame.p2=new JPanel();
	   	 CountGame.LlowP.add(CountGame.p);
	   	 CountGame.energeP = new GraphP();
	   	 CountGame.p.add(CountGame.timela);
	   	 CountGame.p.add(CountGame.rTime);
	   	
	   	 CountGame.LlowP.add(CountGame.energeP);
	   	 CountGame.p2.add(CountGame.chancela);
	   	 CountGame.p2.add(CountGame.chanceNum);
	   	 CountGame.LlowP.add(CountGame.p2);   
	   	    
	   	 CountGame.RlowP = new JPanel(new GridLayout(1,1));
	   	 CountGame.RlowP.add(CountGame.rankBtn);
	   	 CountGame.RlowP.add(CountGame.chanceBtn);
	   	 CountGame.RlowP.add(CountGame.startBtn);    
	   	 CountGame.BotP = new JPanel(new GridLayout(1,2));
	   	 CountGame.BotP.add(CountGame.LlowP);
	   	  
	   	 CountGame.bigBotP = new JPanel(new GridLayout(2,1));
	   	 CountGame.bigBotP.add(CountGame.BotP);
	   	 CountGame.bigBotP.add(CountGame.RlowP);
	   	 
	   	 CountGame.rTime.setText(30.0 + "");
        
	   	 CountGame.chanceBtn.setEnabled(false);
	   	 CountGame.startBtn.setEnabled(false);
	}
}
