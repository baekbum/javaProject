package kr.koreait.threadTest;

public class GamePlay {
	public static void main(String[] args) {
		
		BGMPlay bgmPlay = new BGMPlay();
		
		//Daemon 스레드 : 다른 스레드가 모두 종료되면 같이 종료되는 스레드
		bgmPlay.setDaemon(true);
		bgmPlay.start();		
		
		for(int i=1; i<=10; i++){
			System.out.println("게임을 신나게 하는 중~~~~~");
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(i == 9) {
				System.out.println("!!");
				System.out.println("게임을 종료합니다");
				break;
			}
		}
	}
}
