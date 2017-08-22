package kr.koreait.threadTest;

public class MainThread {
	public static void main(String[] args) {
		
		//Thread 클래스를 상속받아 구현한 스레드 실행 방법
		//1. Thread 클래스를 상속받은 클래스 객체를 선언한다.
		DigitThread digitThread = new DigitThread();
		//2. 생성된 객체에서 start() 메소드
		// digitThread.run(); // run() 메소드를 실행하면 일반 메소드가 실행된다.
		digitThread.start(); // == new digitThread().strat()		
		
		//Runnable 인터페이스를 구현받아 구현한 스레드 실행 방법
		//1. Runnble 인터페이스를 구현받은 클래스 객체를 선언한다.
		AlphaThread alphaThread = new AlphaThread();
		//2. Thread 클래스 객체를 생성하면서 Runnable 인터페이스를 구현받은 클래스 객체를 생성자의 인수로 넘긴다.
		Thread thread = new Thread(alphaThread);
		//3. Thread 클래스의 객체에서 start()
		thread.start(); // == new Thread(new AlphaThread).strat();
		
		for(char ch = 'A'; ch <='Z'; ch++){			
			try {
				System.out.println(ch);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
