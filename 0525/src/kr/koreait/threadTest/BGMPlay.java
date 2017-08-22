package kr.koreait.threadTest;

public class BGMPlay extends Thread{

	@Override
	public void run() {
		while(true){
			System.out.println("음악 연주 중~");
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}		
	}	
}
