package kr.koreait.threadTest;

// Thread 클래스를 상속받고 run() 메소드를 override해서 스레드 구현하기
public class DigitThread extends Thread {

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
