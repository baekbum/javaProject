package kr.koreaitsynchronizedBlockTest1;

public class MainThread {
	public static void main(String[] args) {
		//공유 영역으로 사용할 클래스의 객체를 생성한다.
		ShareArea shareArea = new ShareArea();
		
		/*
		//공유 영역을 사용할 클래스 객체를 생성한다.
		PrintThread print = new PrintThread();
		CalculatorThread calculator = new CalculatorThread();
		
		//공유 영역을 사용할 클래스 객체의 멤버에 공유 영역의 주소를 넣어준다.
		print.shareArea = shareArea;
		calculator.shareArea = shareArea;
		*/
		
		
		/*
		//공유 영역을 사용할 클래스의 객체를 생성하면서 생성자의 인수로 공유 영역의 주소를 넘겨준다.
		PrintThread print = new PrintThread(shareArea);
		CalculatorThread calculator = new CalculatorThread(shareArea);
		*/
		
		PrintThread print = new PrintThread(shareArea);
		CalculatorThread calculator = new CalculatorThread(shareArea);
		//공유 영역의 주소를 setter를 통해서 넣어준다.
		//print.setShareArea(shareArea);
		//calculator.setShareArea(shareArea);
		
		calculator.start();
		print.start();
		
		//테스트
		/*print.shareArea.reuslt = 100;
		System.out.println(calculator.shareArea.reuslt);*/
		
	}
}
