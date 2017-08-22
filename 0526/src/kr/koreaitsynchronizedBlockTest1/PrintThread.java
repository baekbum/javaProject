package kr.koreaitsynchronizedBlockTest1;

// 연산 결과를 출력하는 스레드, 실행 시간이 적게 걸리는 스레드
public class PrintThread extends Thread {
	// 공유 영역으로 사용할 클래스를 멤버로 선언한다.
	ShareArea shareArea; // shareArea는 참조 변수로 주소를 기억한다. 

	public PrintThread() {	}

	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	public ShareArea getShareArea() {
		return shareArea;
	}

	public void setShareArea(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		/*
		// 계산이 완료되는 순간까지 의미없는 반복을 시킨다. => 불필요한 작업 전환이 이루어 진다.
		System.out.print("계산 중");
		while(!shareArea.ready){
			System.out.print(".");
			//스레드가 너무 빠르게 실행되면 정상적인 동작이 안되므로 적당한 시간 간격으로 끊어줘야 한다.
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		System.out.print("계산 중");
		synchronized (shareArea) {	// 동기화 블록
			// 동기화 블록의 괄호에는 공유 영역의 이름을 적는다.
			// 동기화의 의미는 실행 순서를 정한다는 의미로 동기화 블록 내부의 스레드가 실행중일 때 다른 
			// 스레드가 실행되는 것을 막아준다.
			try {
				// wait() : 스레드를 깨우기 전까지 잠깐 멈춘다. 반드시 동기화 블록에 적어야한다.
				shareArea.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		
		
		//공유 영역에 저장된 게산 결과를 출력한다.
		System.out.println("원주율 : " + shareArea.reuslt);
		
	}
	
	
}
