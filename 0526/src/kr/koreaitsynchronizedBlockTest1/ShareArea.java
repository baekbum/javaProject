package kr.koreaitsynchronizedBlockTest1;

// PrintThread 클래스와 CalculatorThread 클래스에서 공유 영역으로 사용할 클래스
public class ShareArea {
	
	double reuslt; // 초기화 안하면 자동으로 0.0으로 초기화, 연산 결과
	boolean ready; // 초기화 안하면 자동으로 false로 초기화, 연산 완료 여부	

}
