package kr.koreaitsynchronizedBlockTest1;

//무한 급수를 이용한 원주율을 계산하는 스레드, 실행 시간이 많이 걸리는 스레드
public class CalculatorThread extends Thread {
	ShareArea shareArea;
	
	public CalculatorThread() { }
	
	public CalculatorThread(ShareArea shareArea) {
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
		//원주율 계산
		double total = 0.0;
		long st = System.currentTimeMillis();
		for(int i=1; i<210000000; i++){
			if(i/2 % 2 == 0){
				total += 1.0 / i;
			}
			else{
				total += -1.0 / i;
			}
		}
		long et = System.currentTimeMillis();
		System.out.println();
		System.out.println("계산 시간 : " + (et-st) / 1000.);
		//System.out.println("원주율 : " + total *  4);
		shareArea.reuslt = total * 4; // 계산 결과를 공유 영역에 저장한다.
		shareArea.ready = true; // 계산이 완료되었음을 공유 영역에 저장한다.
		
		synchronized (shareArea) {
			//notify() : 잠시 멈춘 스레드 1개를 깨운다.
			//notifyAll() : 잠시 멈춘 모든 스레드를 깨운다.
			shareArea.notify();
		}		
	}	
}
