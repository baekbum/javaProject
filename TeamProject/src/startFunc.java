public class startFunc {
	/*시작 버튼을 눌렀을 때 작동 하는 메소드 */
	public static void start1(){
		CountGame.round++;
		CountGame.frame.setTitle(CountGame.round + " Round");
		CountGame.startBtn.setEnabled(false);
        if(CountGame.chance != 0) {
        	CountGame.chanceBtn.setEnabled(true);
        }
	}
	/* mixBtn과 addBtn이 작동한 후에 버튼을 보여줘야 하기 때문에 메소드를 따로 분리 시켜놓음*/
	public static void start2(){
		for(int i=0; i<CountGame.btn.length; i++){
			CountGame.btn[i].setEnabled(true);
	    }	
	}
}
