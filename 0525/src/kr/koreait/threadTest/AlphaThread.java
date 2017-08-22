package kr.koreait.threadTest;

// Runnable 인터페이스를 구현 받고 run() 메소드를 override해서 스레드 구현하기
public class AlphaThread implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<26; i++){
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}
